package redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

import java.io.*;
import java.util.*;

public class RedisManager {

	private final static Logger logger = LoggerFactory.getLogger(RedisManager.class);

	private static JedisPoolConfig config = null;

	private static int maxActive = 10;

	private static Vector<Integer> flag_pool = null; // 状态标识 0|空闲；1|非空闲
	private static Vector<JedisCluster315> jedis_cluster_pool = null;

	 public static void main(String[] args) {
//	 Set<HostAndPort> jedisClusterNodes = new HashSet<HostAndPort>();
//	 // Jedis Cluster will attempt to discover cluster nodes automatically
//	 jedisClusterNodes.add(new HostAndPort("192.168.1.240", 6379));
//	 jedisClusterNodes.add(new HostAndPort("192.168.1.241", 6379));
//	 // ...
//
//	 JedisCluster jc = new JedisCluster(jedisClusterNodes, 60, 60, 3,
//	 "fa2dd47aef2b795aa7ec2d180f850974", config);
//	 jc.set("315che", "xxxxxxx");
//	 String value = jc.get("315che");
//	 System.out.println(value);

		 init();

        int res =  RedisHandler.setPhoneCode("1333333333",111111,2);

		 System.out.println("-->"+res);
	 }



	public static void init() {
		Properties props = new Properties();

		InputStream is = null;
		try {
			is = RedisManager.class.getResourceAsStream("/redis.properties");
			props.load(is);
			is.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}


//		try {
//
//			props.load(RedisManager.class.getClassLoader().getResourceAsStream("redis.properties"));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

		maxActive = Integer.valueOf(props.getProperty("jedis.pool.maxActive"));
		int timeout = Integer.valueOf(props.getProperty("jedis.pool.timeout"));

		config = new JedisPoolConfig();
		config.setMinIdle(Integer.valueOf(props.getProperty("jedis.pool.minIdle")));
		config.setMaxIdle(Integer.valueOf(props.getProperty("jedis.pool.maxIdle")));
		config.setMaxWaitMillis(Long.valueOf(props.getProperty("jedis.pool.maxWaitMillis")));
		config.setTestOnBorrow(Boolean.valueOf(props.getProperty("jedis.pool.testOnBorrow")));
		config.setTestOnReturn(Boolean.valueOf(props.getProperty("jedis.pool.testOnReturn")));
		config.setMaxTotal(maxActive);

		List<String> host_list = Arrays.asList(props.getProperty("host_list").split(","));
		List<String> port_list = Arrays.asList(props.getProperty("port_list").split(","));
		String password = props.getProperty("password");

		Set<HostAndPort> jedisClusterNodes = new HashSet<HostAndPort>();
		int port = 6379;
		for (int i = 0; i < host_list.size(); i++) {
			String host = host_list.get(i);

			if (port_list != null && port_list.size() >= i)
				port = Integer.valueOf(port_list.get(i));
			HostAndPort hostAndPort = new HostAndPort(host, port);
			jedisClusterNodes.add(hostAndPort);
		}
		// jedisCluster(Set<HostAndPort> jedisClusterNode, int
		// connectionTimeout, int soTimeout, int maxAttempts, String password,
		// GenericObjectPoolConfig poolConfig)

		// pool
		flag_pool = new Vector<Integer>(maxActive);
		jedis_cluster_pool = new Vector<JedisCluster315>(maxActive);
		for (int i = 0; i < maxActive; i++) {
			JedisCluster315 jc315 = new JedisCluster315(i, jedisClusterNodes, timeout, 60, 3, password, config);
			jedis_cluster_pool.add(i, jc315);
			flag_pool.add(i, 0); // 初始化状态位
		}

	}

	/**
	 * 获取jedis cluster 实例
	 * @return
	 */
	private static JedisCluster315 getJedisCluster() {
		// 关键，锁住状态位
		synchronized (flag_pool) {
			for (int i = 0; i < flag_pool.size(); i++) {
				int flag = flag_pool.get(i);
				if (flag == 0) {
					flag_pool.set(i, 1); // 设置非空闲状态
					 JedisCluster315 jedisCluster = jedis_cluster_pool.get(i);
					return jedisCluster;
				}
			}
		}

		try {
			throw new Exception("redis >>> >>> 没有找到空闲的jedisCluster!!!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	
	/**
	 * 恢复jedis cluster实例的空闲状态
	 * @param jc
	 */
	private static void returnJedisCluster(JedisCluster315 jc) {
		synchronized (flag_pool) {
			int idx = jc.getIdx();
			flag_pool.set(idx, 0); // 恢复空闲状态
		}
	}

	/**
	 * 分布式连接池同步调用
	 * 
	 * @param jedisHandler
	 * @return
	 */
	public static <T> T doSomething(JedisHandler<T> jedisHandler) {

		if(jedisHandler == null){
			logger.error("160912 002 >>> JedisHandler对象不能为空");
			return null;
		}

		JedisCluster315 jedis = null;
		try {
			jedis = getJedisCluster();

			if (jedis == null) {
				return null;
			}

			return jedisHandler.handle(jedis);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (jedis != null)
				returnJedisCluster(jedis);
		}

		return null;
	}
	

	public static abstract class JedisHandler<T> {
		protected abstract T handle(JedisCluster jedis);
	}

}

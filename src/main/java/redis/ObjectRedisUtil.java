package redis;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * redis java 对象存取
 * @author 钮海东
 * 2015年5月4日
 */
public class ObjectRedisUtil {
	/**
	 * 默认过期时间 120 秒
	 */
	public final static Integer EXPIRE_SECOND = 120;
	
//	/**
//	 * 根据key ，获取对象
//	 * @param key 
//	 * @return java 对象
//	 * @throws Exception
//	 */
//	public static Object getDateObject(String key) throws Exception {
//		Jedis jedis = RedisManager.getJedis();
//		byte[] byteValue;
//		try{
//			byteValue = jedis.get(key.getBytes());
//		} finally {
//			if(jedis != null){
//				RedisManager.recycleJedisConnection(jedis);
//			}
//		}
//		return unSerialize(byteValue);
//	}
//	
//	/**
//	 * 将一个对象序列化后，保存到redis内 默认过期 120 秒
//	 * @param key   rediskey
//	 * @param value   value
//	 */
//	public static void setDataObject(String key, Object value) {
//		setDataObject(key, value, EXPIRE_SECOND);
//	}
//	
//	/**
//	 * 将一个对象序列化后，保存到redis内
//	 * @param key   rediskey
//	 * @param value   value
//	 * @param expireSecond  过期时间，单位（秒）， 如果是null，则默认120 秒过期
//	 */
//	public static void setDataObject(String key, Object value, Integer expireSecond) {
//		Jedis jedis = RedisManager.getJedis();
//		try {
//			jedis.set(key.getBytes(), serialize(value));
//			jedis.expire(key.getBytes(), expireSecond);
//		} catch (IOException e) {
//			e.printStackTrace();
//			if(jedis != null) {
//				RedisManager.recycleJedisConnection(jedis);
//			}
//		} finally {
//			if(jedis != null) {
//				RedisManager.recycleJedisConnection(jedis);
//			}
//		}
//	}
	
	/**
	 * 从byte 内反序列化对象
	 * @param byteValue
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static Object unSerialize(byte [] byteValue) throws IOException, ClassNotFoundException {
		ByteArrayInputStream bai = new ByteArrayInputStream(byteValue);
		ObjectInputStream ois = new ObjectInputStream(bai);
		return ois.readObject();
	}
	
	/**
	 * 将一个对象序列化byte数组
	 * @param object
	 * @return
	 * @throws IOException
	 */
	public static byte[] serialize(Object object) throws IOException {
		ByteArrayOutputStream bao = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(bao);
		oos.writeObject(object);
		return bao.toByteArray();
	}
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		HashMap<String, String> m = new HashMap<String, String>();
		m.put("aaa", "123");
		m.put("bbb", "31");
		byte[] b = ObjectRedisUtil.serialize(m);
		Map mm =(Map)ObjectRedisUtil.unSerialize(b);
//		RedisManager.getJedis().set("jjj", "ddddddddd");
//		System.out.println(mm);
	}
}

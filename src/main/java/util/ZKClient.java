package util;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ZKClient {
	private String zk_server;
	private int zk_timeout;
	private ZooKeeper zk_handle;
	private boolean init_flag = false;
	private final static Logger logger = LoggerFactory.getLogger(ZKClient.class);
	
	//初始化连接
	public boolean init(String server,int timeout)
	{
		try {
			logger.info("connect zookeeper server: " + server + ",timeout: " + timeout + "...");
			zk_handle = new ZooKeeper(server, timeout,new Watcher() { 
	            // 监控所有被触发的事件
	            public void process(WatchedEvent event) { 
	        		String message = "";
	        		Watcher.Event.EventType type = event.getType();
	        		if (type.equals(Watcher.Event.EventType.None)) {
	        			logger.info("connect zookeeper server sucess.");
	        			init_flag = true;
	        		} else if (type.equals(Watcher.Event.EventType.NodeCreated)) {
	        			message = "znode create sucess!!!";
	        		} else if (type.equals(Watcher.Event.EventType.NodeChildrenChanged)) {
	        			message = "child of znode create sucess!!!";
	        		} else if (type.equals(Watcher.Event.EventType.NodeDataChanged)) {
	        			message = "znode update success!!!,reload db's information";
	        		} else if (type.equals(Watcher.Event.EventType.NodeDeleted)) {
	        			message = "znode delete success!!!";
	        		}	            	
	        		else
	        		{
	        			logger.warn("aaaaaaaaaaaaaa");
	        		}
	            } 
			});
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.error(e.getStackTrace().toString());
			return false;
		}
		init_flag = true;
		zk_server = server;
		zk_timeout = timeout;
		return true;
	}
	
	//注册服务器节点
	public boolean regedit_service(String root,String service_module,String serv_info)
	{
		boolean ret = false;
		if(init_flag == false)
		{
			logger.error("zookeer handler don't init.");
			return false;
		}
		try {
			String[] paths = root.split("/");
			String tmp = "/";
			byte[] localhost = InetAddress.getLocalHost().getAddress(); 
			for (int i = 1;i < paths.length;i++)
			{
				tmp = tmp + paths[i];
				if (zk_handle.exists(tmp, false) == null)
				{
					zk_handle.create(tmp,localhost, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);			
				}
				tmp = tmp + "/";
			}
			if (zk_handle.exists(root + "/" + service_module, false) == null)
			{
				zk_handle.create(root + "/" + service_module,localhost, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);			
			}
			if (zk_handle.exists(root + "/" + service_module + "/" + serv_info, false) == null)
			{
				zk_handle.create(root + "/" + service_module + "/" + serv_info,localhost, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
			}			
			ret = true;
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			logger.error(e.getStackTrace().toString());
		} catch (KeeperException e) {
			// TODO Auto-generated catch block
			logger.error(e.getStackTrace().toString());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			logger.error(e.getStackTrace().toString());
		}
		return ret;
	}
	
	//获取服务节点列表
	public List<String> get_service_list(String root,String service_module)
	{
		List<String> serverList = new ArrayList<String>();
		try {
			serverList = zk_handle.getChildren(root + "/" + service_module,true);
		} catch (KeeperException e) {
			// TODO Auto-generated catch block
			logger.error(e.getStackTrace().toString());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			logger.error(e.getStackTrace().toString());
		}
		return serverList;
	}
	//获取服务列表中随机一条记录
	public String get_service(String root,String service_module)
	{
		String server = null;
		List<String> serverList = get_service_list(root,service_module);
		if (serverList.size() > 0)
		{
			Random rdm = new Random();
			int min = 0;
			int max = serverList.size() - 1;
			int idx = rdm.nextInt(max-min+1)+min;
			server = serverList.get(idx);
		}
		return server;
	}



	//删除注册点
	public boolean delete_service(String root,String service_module,String serv_info)
	{
		boolean ret = false;
		try {
			if (zk_handle.exists(root + "/" + service_module + "/" + serv_info, false) != null)
			{
				zk_handle.delete(root + "/" + service_module + "/" + serv_info,-1);
			}
			ret = true;
		} catch (KeeperException e) {
			// TODO Auto-generated catch block
			logger.error(e.getStackTrace().toString());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			logger.error(e.getStackTrace().toString());
		}
		return ret;
	}
	
//    public static void main(String[] args) {
//    	ZKClient zkClient = new ZKClient();
//		if (zkClient.init("192.168.1.251:2181", 3000) == false)
//		{
//			logger.error("connect zookeeper fail.");
//			return;
//		}
//		String serv = zkClient.get_service("/gx/cfg/service", "GX-Service-User");
//		String[] info = serv.split(":");
//    }	
}
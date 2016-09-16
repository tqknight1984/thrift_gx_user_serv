
import net.gx.thrift.User;
import net.gx.thrift.User.Processor;

import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TBinaryProtocol.Factory;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.server.TThreadPoolServer.Args;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.RedisManager;
import util.MyConfig;
import util.ZKClient;


public class UserService {
    private final static Logger logger = LoggerFactory.getLogger(UserService.class);


    private ZKClient zkClient = new ZKClient();
    private boolean init_flag = false;
//	private String service_module;
//	private String service_ip;
//	private int service_port;
//	private String zk_root;


    public boolean init() {

        System.out.println("MyConfig.zk_server====>>"+ MyConfig.zk_server);
        System.out.println("MyConfig.zk_timeout====>>"+MyConfig.zk_timeout);

        if (!zkClient.init(MyConfig.zk_server, MyConfig.zk_timeout)) {
            logger.error("connect zookeeper fail.");
            return false;
        }
        boolean registFlag = zkClient.regedit_service(MyConfig.zk_root, MyConfig.service_module, MyConfig.service_ip + ":" + String.valueOf(MyConfig.service_port));
        if (!registFlag) {
            logger.error("regedit service: %s,%s,%s:%d to zookeeper fail.", MyConfig.zk_root, MyConfig.service_module, MyConfig.service_ip, MyConfig.service_port);
            return false;
        } else {
            logger.debug("regedit service: %s,%s,%s:%d to zookeeper success.", MyConfig.zk_root, MyConfig.service_module, MyConfig.service_ip, MyConfig.service_port);
            return true;
        }

    }

    private TServer tServer;

    public void startServer() {
        try {
            // 设置服务端口为
            TServerSocket serverTransport = new TServerSocket(MyConfig.service_port);
            // 关联处理器与 User 服务的实现
            User.Processor process = new Processor(new UserImpl());
            //设置协议工厂为 TBinaryProtocol.Factory
            Factory portFactory = new TBinaryProtocol.Factory(true, true);

            Args args = new Args(serverTransport);
            args.processor(process);
            args.protocolFactory(portFactory);
            tServer = new TThreadPoolServer(args);
            logger.info("Start rpc server(User) on port:" + MyConfig.service_port + " ...");
            tServer.serve();
        } catch (TTransportException e) {
            logger.error(e.getStackTrace().toString());
        }
    }


    private void stopServer() {

        if (tServer != null) {
            zkClient.delete_service(MyConfig.zk_root, MyConfig.service_module, MyConfig.service_ip + ":" + String.valueOf(MyConfig.service_port));
            logger.info("Stop rpc server(User) on port:" + MyConfig.service_port + " ...");
            System.out.println("stop server ok");
            tServer.stop();
            tServer = null;
        }
    }


    public static void main(String[] args) {

        //init redis
        RedisManager.init();

        final UserService userService = new UserService();
        if (!userService.init()) {
            logger.error(">>> user server init fail,then exit...");
            return;
        }

        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                userService.stopServer();
                System.out.println("Shutdown hook ran!");
            }
        });


        logger.info("start server...");
        userService.startServer();
    }
}

package util;

import java.io.InputStream;
import java.util.Properties;

/**
 * 加载我的配置
 *
 * @author 2015年5月12日
 */
public class MyConfig {




    public static String zk_client;

    public static  String zk_server;
    public static  String zk_root;
    public static  int zk_timeout;


    public static  String service_module;
    public static String service_ip;
    public static  int service_port;








    static {
        Properties props = new Properties();
        try {
            InputStream in = MyConfig.class.getResourceAsStream("/myconfig.properties");
            props.load(in);
            in.close();

//            String path = UserService.class.getResource("/").toString();
//            System.out.println("path=======00========>>>"+path);
//            path = path + "myconfig.properties";
//            System.out.println("path==========22=====>>>"+path);
//            path = path.replace("file:", "");
//            InputStream in = new BufferedInputStream(new FileInputStream(path));
//            props.load(in);


        } catch (Throwable e) {
            e.printStackTrace();
        }


        zk_server = props.getProperty("zk_server");
        zk_root = props.getProperty("zk_root");
        zk_timeout = Integer.parseInt(props.getProperty("zk_timeout"));

        service_module = props.getProperty("service_module");
        service_ip = props.getProperty("service_ip");
        service_port = Integer.parseInt(props.getProperty("service_port"));

        zk_client = props.getProperty("zk_client");


    }
}

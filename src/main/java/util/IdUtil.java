package util;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by app on 16/8/31.
 */
public class IdUtil {

    private final static Logger logger = LoggerFactory.getLogger(IdUtil.class);


    private static CustomUUID customUUID = null;

    private static int workid = 0;

    private static int init() {

        Properties props = new Properties();

        try {
//            String path = UserService.class.getResource("/").toString() + "myconfig.properties";
//            path = path.replace("file:", "");
//            InputStream in = new BufferedInputStream(new FileInputStream(path));
//            props.load(in);
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            props.load(classloader.getResourceAsStream("/myconfig.properties"));

        } catch (IOException e1) {
            // TODO Auto-generated catch block
            logger.error(e1.getStackTrace().toString());
        }
        workid = Integer.parseInt(props.getProperty("workid"));

        if (customUUID == null) {
            customUUID = new CustomUUID(workid);
        }

        return 1;
    }


    public static long getId() {
        if (workid == 0 || customUUID == null) {
            init();
        }
        return customUUID.generate();
    }


}

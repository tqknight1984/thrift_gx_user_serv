package mybatis;

import com.gx.dao.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import util.MyConfig;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;

/**
 * Created by app on 16/9/1.
 */
public class MybatisManager {

    private final static Logger logger = LoggerFactory.getLogger(MybatisManager.class);

    private static SqlSessionFactory factory = null;



    public static void main(String[] args) {

        logger.info("start server...");

        SqlSession session = null;
        try {
            init();

            //打开一个Session会话
            session = factory.openSession();

            UserMapper mapper = session.getMapper(UserMapper.class);

            HashMap registParam = new HashMap();
            registParam.put("v_uid", 3005);
            registParam.put("v_uname", "zzz3005");
            registParam.put("v_upass", "xxxx3005");
            registParam.put("v_mobile", "15026693005");

            mapper.pro_regist_p(registParam);
            String int_ret = String.valueOf(registParam.get("int_ret"));
            System.out.println("-160909 001----->" + int_ret);




//20160909
//            UserMapper mapper = session.getMapper(UserMapper.class);
//            ObjUser u1 = mapper.selectUserById(3001);
//            System.out.println("-111----->" + u1.getU_name());


            //通过session获得一个mapper
//            ObjUserMapper mapper = session.getMapper(ObjUserMapper.class);
//             ObjUser u1 = mapper.selectByPrimaryKey(123L);





        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            session.close();
        }
    }

    private static void init() {

        logger.info("init mybatis...");
        InputStream is = null;
        try {
           is = MybatisManager.class.getResourceAsStream("/mybatis.xml");
            factory = new SqlSessionFactoryBuilder().build(is);
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }



    private static SqlSession getSqlSession() {
        if (factory == null) {
            init();
        }
        return factory.openSession(true);
    }


    private static void closeSqlSession(SqlSession sqlSession) {
        if (sqlSession == null) {
            return;
        }
        sqlSession.close();
    }

    public static <T> T doSomething(Handler<T> handler) {

        SqlSession sqlSession = null;

        try {

            sqlSession = getSqlSession();
            return handler.handle(sqlSession);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            if (sqlSession != null) {
                closeSqlSession(sqlSession);
            }

        }

        return null;
    }


    public abstract static class Handler<T> {

        protected abstract T handle(SqlSession sqlSession);

    }


}

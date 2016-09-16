package mybatis;

import com.gx.dao.*;
import com.gx.model.ObjIndUser;
import com.gx.model.ObjUserShipAddress;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.RedisHandler;
import util.ObjectToMapUtil;
import util.String2Date;

import java.util.*;

/**
 * Created by app on 16/9/12.
 */
public class MybatisHandler {

    private final static Logger logger = LoggerFactory.getLogger(MybatisHandler.class);


    public static int callProRegistP(final long uid, final String name, final String password, final String mobile) {

        int callRes = MybatisManager.doSomething(new MybatisManager.Handler<Integer>() {
            @Override
            protected Integer handle(SqlSession sqlSession) {

                UserMapper mapper = sqlSession.getMapper(UserMapper.class);
                HashMap registParam = new HashMap();
                registParam.put("v_uid", uid);
                registParam.put("v_uname", name);
                registParam.put("v_upass", password);
                registParam.put("v_mobile", mobile);

                mapper.pro_regist_p(registParam);
                String int_ret = String.valueOf(registParam.get("int_ret"));
                logger.info("160909 001 >>> CALL REGIST P >>> " + int_ret);
                return Integer.parseInt(int_ret);
            }
        });

        return callRes;
    }

    public static int callProRegistB(final long uid, final String name, final String password, final String mobile, final String company) {

        int callRes = MybatisManager.doSomething(new MybatisManager.Handler<Integer>() {
            @Override
            protected Integer handle(SqlSession sqlSession) {

                UserMapper mapper = sqlSession.getMapper(UserMapper.class);
                HashMap registParam = new HashMap();
                registParam.put("v_uid", uid);
                registParam.put("v_uname", name);
                registParam.put("v_upass", password);
                registParam.put("v_mobile", mobile);

                mapper.pro_regist_b(registParam);
                String int_ret = String.valueOf(registParam.get("int_ret"));
                System.out.println("--- 160909 011----->" + int_ret);

                return Integer.parseInt(int_ret);
            }
        });

        return callRes;
    }


    //保存地址
    public static int saveUserAddress(final String uid, final String consignee, final String areaid, final String address, final String mobile, final String telephone, final String zipcode, final byte flag) {

        final ObjUserShipAddress registParam = new ObjUserShipAddress();
        registParam.setUid(Long.parseLong(uid));
        registParam.setConsignee(consignee);
        registParam.setAreaid(Integer.parseInt(areaid));
        registParam.setAddress(address);
        registParam.setMobile(mobile);
        registParam.setTelephone(telephone);
        registParam.setZipcode(zipcode);
        registParam.setFlag(flag);

        int res = MybatisManager.doSomething(new MybatisManager.Handler<Integer>() {
            @Override
            protected Integer handle(SqlSession sqlSession) {

                UserShipAddressMapper shipAddressMapper = sqlSession.getMapper(UserShipAddressMapper.class);
                int res = shipAddressMapper.insertSelective(registParam);
                return res;

            }
        });

        //to redis
        if (res == 1) {

            Map<String, String> shipAddressMap = ObjectToMapUtil.changeToMap(registParam);
            RedisHandler.addUserShipAddress(shipAddressMap);
            return 1;
        }

        return 0;
    }


    public static int updateUserAddress(String id, String consignee, String areaid, String address, String mobile, String telephone, String zipcode) {

        final ObjUserShipAddress registParam = new ObjUserShipAddress();

        registParam.setId(Integer.parseInt(id));
        registParam.setConsignee(consignee);
        registParam.setAreaid(Integer.parseInt(areaid));
        registParam.setAddress(address);
        registParam.setMobile(mobile);
        registParam.setTelephone(telephone);
        registParam.setZipcode(zipcode);

        int res = MybatisManager.doSomething(new MybatisManager.Handler<Integer>() {
            @Override
            protected Integer handle(SqlSession sqlSession) {

                ObjUserShipAddressMapper shipAddressMapper = sqlSession.getMapper(ObjUserShipAddressMapper.class);
                return shipAddressMapper.updateByPrimaryKeySelective(registParam);
            }
        });

        //to redis
        if (res == 1) {

            Map<String, String> map = ObjectToMapUtil.changeToMap(registParam);
            map.remove("uid");
            map.remove("flag");
            RedisHandler.updateUserAddress(map);
            return 1;
        }

        return res;
    }

    public static int delUserAddress(final String id, final String uid) {
        int res = MybatisManager.doSomething(new MybatisManager.Handler<Integer>() {
            @Override
            protected Integer handle(SqlSession sqlSession) {

                ObjUserShipAddressMapper shipAddressMapper = sqlSession.getMapper(ObjUserShipAddressMapper.class);
                return shipAddressMapper.deleteByPrimaryKey(Integer.parseInt(id));

            }
        });

        //del redis
        if (res == 1) {
            RedisHandler.delUserAddress(id, uid);
            return 1;
        }

        return res;
    }

    public static int setDefaultAddress(final long uid, final int address_id) {

//        final ObjUserShipAddress objUserShipAddress = new ObjUserShipAddress();
//        objUserShipAddress.setId(Integer.valueOf(address_id));
//        objUserShipAddress.setFlag(Byte.valueOf("1"));


        int res = MybatisManager.doSomething(new MybatisManager.Handler<Integer>() {
            @Override
            protected Integer handle(SqlSession sqlSession) {


                UserShipAddressMapper shipAddressMapper = sqlSession.getMapper(UserShipAddressMapper.class);

                HashMap proParam = new HashMap();
                proParam.put("v_uid", uid);
                proParam.put("v_address_id", address_id);

                shipAddressMapper.pro_change_def_ship_address(proParam);
                int int_ret = (int)proParam.get("int_ret");
                System.out.println("--- 160916 011----->" + int_ret);
                return int_ret;
            }
        });

        //to redis
        if (res == 200) {
            return RedisHandler.setDefaultAddress(String.valueOf(uid), String.valueOf(address_id));
        }
        else{
            return -1;
        }
    }

    public static int updateIndUser(String uid, String nick, String sex, String real_name, String brithday, String email, String company, String photo) {

        final ObjIndUser objIndUser = new ObjIndUser();
        objIndUser.setUid(Long.parseLong(uid));
        objIndUser.setNick(nick);
        objIndUser.setSex(sex);
        objIndUser.setReal_name(real_name);
        objIndUser.setBrithday(String2Date.getBirthdayByStr(brithday));
        objIndUser.setEmail(email);
        objIndUser.setCompany(company);
        objIndUser.setPhoto(photo);

        int res = MybatisManager.doSomething(new MybatisManager.Handler<Integer>() {
            @Override
            protected Integer handle(SqlSession sqlSession) {

                ObjIndUserMapper objIndUserMapper = sqlSession.getMapper(ObjIndUserMapper.class);
                return objIndUserMapper.updateByPrimaryKeySelective(objIndUser);

            }
        });

        //del redis
        if (res == 1) {
            Map<String, String> map = ObjectToMapUtil.changeToMap(objIndUser);
            RedisHandler.updateIndUser(map);
            return 1;
        }
        return 0;
    }

    public static int changePwd(final long uid , final String old_pwd, final String new_pwd) {

        int res = MybatisManager.doSomething(new MybatisManager.Handler<Integer>() {
            @Override
            protected Integer handle(SqlSession sqlSession) {

                HashMap proParam = new HashMap();
                proParam.put("v_uid", uid);
                proParam.put("v_old_pwd", old_pwd);
                proParam.put("v_new_pwd", new_pwd);

                UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
                userMapper.pro_change_pwd(proParam);
                int int_ret = (int)proParam.get("int_ret");
                System.out.println("--- 160916 012----->" + int_ret);
                return int_ret;
            }
        });

        //redis
        if(res == 200){
            res =  RedisHandler.changePwd(String.valueOf(uid), new_pwd);
        }

        return res;

    }


}

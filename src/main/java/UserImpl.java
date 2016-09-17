
import com.gx.model.ObjIndUser;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import mybatis.MybatisHandler;
import net.gx.thrift.ResList;
import net.gx.thrift.ResObj;
import net.gx.thrift.User;
import org.apache.commons.lang.StringUtils;
import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.RedisHandler;
import smsClient.SmsHandler;
import util.ConfigUtil;
import util.IdUtil;
import util.MobileUtil;
import util.ObjectToMapUtil;

public class UserImpl implements User.Iface {

    private final static Logger logger = LoggerFactory.getLogger(UserImpl.class);


    public void ping() throws TException {
        System.out.println("calling ping ,length=" + System.currentTimeMillis());
    }

    @Override
    public ResObj gen_phone_code(String mobile, int type) throws TException {

        ResObj resObj = new ResObj();

        if (!MobileUtil.isMobile(mobile)) {
            resObj.setCode(201);
            resObj.setText("手机格式不对");
            return resObj;
        }

        final int phoneCode = (int) (new Random().nextDouble() * (900000) + 100000);
        logger.info("1609021831 001 >>> gen_phone_code >>> " + mobile + ":" + phoneCode);

        //插入redis
        int res = RedisHandler.setPhoneCode(mobile, phoneCode, type);

        if (res != 1) {
            resObj.setCode(501);
            resObj.setText("插入redis错误");
            return resObj;
        }

        final String msg = "尊敬的用户：" + phoneCode + " 是您本次的短信验证码，2分钟内有效。";
        //短消息
        int smsRes = SmsHandler.sendSms(mobile, msg);

        if (smsRes == 1) {
            resObj.setCode(200);
            resObj.setText("短消息发送成功");
            resObj.putToData("code", String.valueOf(phoneCode));
            resObj.putToData("mobile", mobile);
        } else {
            resObj.setCode(500);
            resObj.setText("短消息发送失败");
            return resObj;
        }
        return resObj;
    }

    @Override
    public ResObj check_phone_code(String mobile, String code, int type) throws TException {

        ResObj resObj = new ResObj();

        if (StringUtils.isEmpty(mobile)) {
            resObj.setCode(201);
            resObj.setText("参数错误：mobile");
            return resObj;
        }
        if (StringUtils.isEmpty(code)) {
            resObj.setCode(202);
            resObj.setText("参数错误：code");
            return resObj;
        }

        String curCode = RedisHandler.getPhoneCode(mobile, type);
        if (StringUtils.isEmpty(curCode)) {
            resObj.setCode(203);
            resObj.setText("验证码已过期");
            return resObj;
        }

        if (code.equals(curCode)) {
            resObj.setCode(200);
            resObj.setText("success");
            return resObj;
        } else {
            resObj.setCode(500);
            resObj.setText("fail");
            return resObj;
        }

    }


    @Override
    public ResObj regedit_p(final String name, final String password, final String mobile, final String code) throws TException {
        System.out.println("regedit_p -----name--->>" + name);
        System.out.println("regedit_p ------mobile-->>" + mobile);

        ResObj resObj = new ResObj();

        if (StringUtils.isEmpty(name)) {
            logger.info("1609021402001 >>> regedit_p >>> 参数错误!用户名为空!。");
            resObj.setCode(201);
            resObj.setText("用户名格式错误");
            return resObj;
        }

        if (StringUtils.isEmpty(mobile)) {
            logger.info("1609021402002 >>> regedit_p >>> 参数错误!手机号为空!。");
            resObj.setCode(202);
            resObj.setText("手机号格式错误");
            return resObj;
        }

        boolean isMobile = ConfigUtil.isMobile(mobile);
        if (!isMobile) {
            logger.info("1609021402003 >>> regedit_p >>> 参数错误!手机号格式不对。");
            resObj.setCode(202);
            resObj.setText("手机号格式错误");
            return resObj;
        }


        if (StringUtils.isEmpty(code)) {
            logger.info("160912 003 >>> regedit_p >>> 参数错误!code不能为空。");
            resObj.setCode(203);
            resObj.setText("验证码不能为空");
            return resObj;
        }

        String currCode = RedisHandler.getPhoneCode(mobile, 1);
        if (StringUtils.isEmpty(currCode) || !code.equals(currCode)) {
            resObj.setCode(203);
            resObj.setText("验证码错误");
            return resObj;
        }

        //mysql procedures
//        CALL `gxweb`.`pro_regist_p`('3004', 'name3004', 'pass3004', '15092293004', @ret);
//        select @ret;

        final Long uid = IdUtil.getId();
        int callRes = MybatisHandler.callProRegistP(uid, name, password, mobile);

        //插入redis
        if (callRes == 200) {

            Map<String, String> userInfo = new HashMap<>();
            userInfo.put("uid", String.valueOf(uid));
            userInfo.put("u_name", name);
            userInfo.put("mobile", mobile);
            userInfo.put("u_pass", password);
            int redisRes = RedisHandler.addUserInfo(userInfo);
            logger.info("160912 001 >>> insert db for regist p >>> " + redisRes);

            //初始化 redis 用户详细信息
            if (redisRes == 1) {

                ObjIndUser objIndUser = new ObjIndUser();
                objIndUser.setUid(Long.valueOf(uid));
                final Map<String, String> indUserMap = ObjectToMapUtil.changeToMap(objIndUser);

                redisRes = RedisHandler.addIndUser(indUserMap);
            }

            if (redisRes != 1) {
                resObj.setCode(600);
                resObj.setText("插入redis失败");
                return resObj;
            }

        }

        resObj.setCode(callRes);

        switch (callRes) {
            case 200: {
                resObj.setText("注册成功");
                resObj.putToData("uid", String.valueOf(uid));
                break;
            }
            case 501: {
                resObj.setText("UID冲突");
                break;
            }
            case 502: {
                resObj.setText("用户名重复");
                break;
            }
            case 503: {
                resObj.setText("手机重复");
                break;
            }
            default: {
                resObj.setText("注册失败");
            }
        }

        return resObj;
    }

    @Override
    public ResObj regedit_b(final String name, final String password, final String mobile, final String code, final String company) throws TException {

        ResObj resObj = new ResObj();

        if (StringUtils.isEmpty(name)) {
            logger.info("1609021402001 >>> regedit_b >>> 参数错误!用户名为空!。");
            resObj.setCode(201);
            resObj.setText("用户名格式错误");
            return resObj;
        }

        if (StringUtils.isEmpty(mobile)) {
            logger.info("1609021402002 >>> regedit_b >>> 参数错误!手机号为空!。");
            resObj.setCode(202);
            resObj.setText("手机号格式错误");
            return resObj;
        }

        boolean isMobile = ConfigUtil.isMobile(mobile);
        if (!isMobile) {
            logger.info("1609021402003 >>> regedit_b >>> 参数错误!手机号格式不对。");
            resObj.setCode(202);
            resObj.setText("手机号格式错误");
            return resObj;
        }

        if (StringUtils.isEmpty(code)) {
            logger.info("160912 003 >>> regedit_b >>> 参数错误!code不能为空。");
            resObj.setCode(203);
            resObj.setText("验证码不能为空");
            return resObj;
        }

        String currCode = RedisHandler.getPhoneCode(mobile, 1);
        if (StringUtils.isEmpty(currCode) || !code.equals(currCode)) {
            resObj.setCode(203);
            resObj.setText("验证码错误");
            return resObj;
        }

        //mysql procedures
//        CALL `gxweb`.`pro_regist_p`('3004', 'name3004', 'pass3004', '15092293004', @ret);
//        select @ret;

        final Long uid = IdUtil.getId();
        int callRes = MybatisHandler.callProRegistB(uid, name, password, mobile, company);

        //插入redis
        if (callRes == 200) {

            Map<String, String> userInfo = new HashMap<>();
            userInfo.put("uid", String.valueOf(uid));
            userInfo.put("u_name", name);
            userInfo.put("mobile", mobile);
            userInfo.put("u_pass", password);

            int redisRes = RedisHandler.addUserInfo(userInfo);
            if (redisRes != 1) {
                resObj.setCode(600);
                resObj.setText("插入redis失败");
                return resObj;
            }
        }

        resObj.setCode(callRes);

        switch (callRes) {
            case 200: {
                resObj.setText("注册成功");
                resObj.putToData("uid", String.valueOf(uid));
                break;
            }
            case 501: {
                resObj.setText("UID冲突");
                break;
            }
            case 502: {
                resObj.setText("用户名重复");
                break;
            }
            case 503: {
                resObj.setText("手机重复");
                break;
            }
            default: {
                resObj.setText("注册失败");
            }
        }

        return resObj;
    }

    @Override
    public ResObj check_auth(String name, String mobile) throws TException {
        ResObj resObj = new ResObj();

        if (StringUtils.isEmpty(name)) {
            logger.info("160912 004 >>> check_auth >>> 参数错误!用户名为空!。");
            resObj.setCode(201);
            resObj.setText("用户名格式错误");
            return resObj;
        }

        if (StringUtils.isEmpty(mobile)) {
            logger.info("160912 004 >>> check_auth >>> 参数错误!密码不能为空!。");
            resObj.setCode(202);
            resObj.setText("密码不能为空");
            return resObj;
        }


        return null;
    }

    @Override
    public ResObj login(String nameOrPhone, String password) throws TException {

        ResObj resObj = new ResObj();

        if (StringUtils.isEmpty(nameOrPhone)) {
            logger.info("160912 005 >>> login >>> 参数错误!用户名为空!。");
            resObj.setCode(201);
            resObj.setText("用户名格式错误");
            return resObj;
        }

        if (StringUtils.isEmpty(password)) {
            logger.info("160912 006 >>> login >>> 参数错误!密码不能为空!。");
            resObj.setCode(202);
            resObj.setText("密码不能为空");
            return resObj;
        }

        boolean isMobile = ConfigUtil.isMobile(nameOrPhone);

        Map<String, String> userInfo = null;
        if (isMobile) {
            userInfo = RedisHandler.getUserInfoByPhone(nameOrPhone);
        } else {
            userInfo = RedisHandler.getUserInfoByUname(nameOrPhone);
        }

        if (userInfo != null) {
            if (userInfo.get("u_pass").equals(password)) {
                resObj.setCode(200);
                resObj.setText("登录成功");
                resObj.setData(userInfo);
            } else {
                resObj.setCode(203);
                resObj.setText("密码错误");
            }
        } else {
            resObj.setCode(500);
            resObj.setText("登录失败");
        }

        return resObj;
    }

    @Override
    public ResObj get_user(String name, String mobile) throws TException {


        return null;
    }

    @Override
    public ResObj setUserInfo(String name, String password) throws TException {
        return null;
    }

    @Override
    public ResList getUserAddress(String uid) throws TException {
        ResList resList = new ResList();

        List<Map<String, String>> lsData = RedisHandler.getUserAddresss(uid);
        resList.setCode(200);
        resList.setText("success");
        resList.setLsdata(lsData);

        return resList;
    }

    @Override
    public ResObj setUserAddress(final String uid, final String consignee, final String areaid, final String address, final String mobile, final String telephone, final String zipcode, final byte flag) throws TException {
        ResObj resObj = new ResObj();

        if (StringUtils.isEmpty(uid) || Long.parseLong(uid) < 1L) {
            resObj.setCode(201);
            resObj.setText("参数错误：uid");
            return resObj;
        }
        if (StringUtils.isEmpty(consignee)) {
            resObj.setCode(202);
            resObj.setText("参数错误：consignee");
            return resObj;
        }
        if (StringUtils.isEmpty(areaid)) {
            resObj.setCode(203);
            resObj.setText("参数错误：areaid");
            return resObj;
        }
        if (StringUtils.isEmpty(address)) {
            resObj.setCode(204);
            resObj.setText("参数错误：address");
            return resObj;
        }
        if (StringUtils.isEmpty(mobile)) {
            resObj.setCode(205);
            resObj.setText("参数错误：mobile");
            return resObj;
        }

        int res = MybatisHandler.saveUserAddress(uid, consignee, areaid, address, mobile, telephone, zipcode, flag);
        if (res == 1) {
            resObj.setCode(200);
            resObj.setText("保存成功");

        } else {
            resObj.setCode(500);
            resObj.setText("保存失败");
        }
        return resObj;
    }

    @Override
    public ResObj updateUserAddress(String id, String consignee, String areaid, String address, String mobile, String telephone, String zipcode) throws TException {
        ResObj resObj = new ResObj();

        if (StringUtils.isEmpty(id) || Long.parseLong(id) < 1L) {
            resObj.setCode(201);
            resObj.setText("参数错误：uid");
            return resObj;
        }
        if (StringUtils.isEmpty(consignee)) {
            resObj.setCode(202);
            resObj.setText("参数错误：consignee");
            return resObj;
        }
        if (StringUtils.isEmpty(areaid)) {
            resObj.setCode(203);
            resObj.setText("参数错误：areaid");
            return resObj;
        }
        if (StringUtils.isEmpty(address)) {
            resObj.setCode(204);
            resObj.setText("参数错误：address");
            return resObj;
        }
        if (StringUtils.isEmpty(mobile)) {
            resObj.setCode(205);
            resObj.setText("参数错误：mobile");
            return resObj;
        }

        System.out.println("=========>>>>>" + address);

        int res = MybatisHandler.updateUserAddress(id, consignee, areaid, address, mobile, telephone, zipcode);
        if (res == 1) {
            resObj.setCode(200);
            resObj.setText("修改成功");
        } else {
            resObj.setCode(500);
            resObj.setText("修改失败");
        }
        return resObj;
    }

    @Override
    public ResObj delUserAddress(String id, String uid) throws TException {

        ResObj resObj = new ResObj();

        if (StringUtils.isEmpty(id) || Long.parseLong(id) < 1L) {
            resObj.setCode(201);
            resObj.setText("参数错误：uid");
            return resObj;
        }

        int res = MybatisHandler.delUserAddress(id, uid);
        if (res == 1) {
            resObj.setCode(200);
            resObj.setText("删除成功");
        } else {
            resObj.setCode(500);
            resObj.setText("删除失败");
        }
        return resObj;
    }

    @Override
    public ResObj changeDefaultAddress(long uid, int address_id) throws TException {
        ResObj resObj = new ResObj();

        if (uid < 1) {
            resObj.setCode(201);
            resObj.setText("参数错误：uid");
            return resObj;
        }

        if (address_id < 1) {
            resObj.setCode(202);
            resObj.setText("参数错误：address_id");
            return resObj;
        }

        int res = MybatisHandler.setDefaultAddress(uid, address_id);

        if (res == 1) {
            resObj.setCode(200);
            resObj.setText("删除成功");
            return resObj;
        }
        resObj.setCode(500);
        resObj.setText("删除失败");
        return resObj;
    }

    @Override
    public ResObj getAreaInfo(String areaId) throws TException {
        ResObj resObj = new ResObj();

        Map<String, String> data = RedisHandler.getAreaInfo(areaId);
        resObj.setCode(200);
        resObj.setText("success");
        resObj.setData(data);
        return resObj;
    }

    @Override
    public ResList getCitysInfo() throws TException {
        ResList resList = new ResList();

        List<Map<String, String>> lsdata = RedisHandler.getCitysInfo();

        resList.setCode(200);
        resList.setText("success");
        resList.setLsdata(lsdata);

        return resList;
    }

    @Override
    public ResList getCountysInfo(int cityid) throws TException {
        ResList resList = new ResList();

        if (cityid < 1) {
            resList.setCode(201);
            resList.setText("参数错误：cityid");
            return resList;
        }

        List<Map<String, String>> lsdata = RedisHandler.getCountysInfo(String.valueOf(cityid));

        resList.setCode(200);
        resList.setText("success");
        resList.setLsdata(lsdata);

        return resList;
    }

    @Override
    public ResObj updateIndUser(String uid, String nick, String sex, String real_name, String brithday, String email, String company, String photo) throws TException {
        ResObj resObj = new ResObj();

        if (StringUtils.isEmpty(uid)) {
            resObj.setCode(201);
            resObj.setText("参数错误：uid");
            return resObj;
        }

        int res = MybatisHandler.updateIndUser(uid, nick, sex, real_name, brithday, email, company, photo);
        if (res == 1) {
            resObj.setCode(200);
            resObj.setText("删除成功");
        } else {
            resObj.setCode(500);
            resObj.setText("删除失败");
        }
        return resObj;
    }

    @Override
    public ResObj changePwd(long uid, String old_pwd, String new_pwd) throws TException {
        ResObj resObj = new ResObj();

        if (StringUtils.isEmpty(old_pwd) || StringUtils.isEmpty(new_pwd)) {
            resObj.setCode(201);
            resObj.setText("参数错误：old_pwd or new_pwd");
            return resObj;
        }

        int res = MybatisHandler.changePwd(uid, old_pwd, new_pwd);

        if (res == 502) {
            resObj.setCode(502);
            resObj.setText("密码错误");
            return resObj;
        }

        if (res == 1) {
            resObj.setCode(200);
            resObj.setText("success");
            return resObj;
        } else {
            resObj.setCode(500);
            resObj.setText("修改失败");
            return resObj;
        }
    }

    @Override
    public ResList getUserInvoice(long uid, byte invoice_type) throws TException {
        ResList resList = new ResList();

        List<Map<String, String>> lsData = RedisHandler.getUserInvoice(uid, invoice_type);
        resList.setCode(200);
        resList.setText("success");
        resList.setLsdata(lsData);

        return resList;
    }

    @Override
    public ResObj setUserInvoice(long uid, String i_type, String title, byte flag, String company, String telephone, String taxpayer, String address, String bank, String bank_no) throws TException {
        ResObj resObj = new ResObj();

        if (uid < 0L) {
            resObj.setCode(201);
            resObj.setText("参数错误：uid");
            return resObj;
        }
        if (StringUtils.isEmpty(i_type)) {
            resObj.setCode(202);
            resObj.setText("参数错误：i_type");
            return resObj;
        }

        int res = MybatisHandler.saveUserInvoice(uid, i_type, title, flag, company, telephone, taxpayer, address, bank, bank_no);
        if (res == 1) {
            resObj.setCode(200);
            resObj.setText("保存成功");
            return resObj;
        }
        resObj.setCode(500);
        resObj.setText("保存失败");
        return resObj;
    }

    @Override
    public ResObj updateUserInvoice(int invoice_id, String i_type, String title, byte flag, String company, String telephone, String taxpayer, String address, String bank, String bank_no) throws TException {
        ResObj resObj = new ResObj();

        if (invoice_id > 1L) {
            resObj.setCode(201);
            resObj.setText("参数错误：uid");
            return resObj;
        }

        int res = MybatisHandler.updateUserInvoice(invoice_id, i_type, title, flag, company, telephone, taxpayer, address, bank, bank_no);
        if (res == 1) {
            resObj.setCode(200);
            resObj.setText("修改成功");
            return resObj;
        }

        resObj.setCode(500);
        resObj.setText("修改失败");
        return resObj;
    }

    @Override
    public ResObj delUserInvoice(int invoice_id, String uid, byte i_type) throws TException {
        ResObj resObj = new ResObj();

        if (invoice_id < 1L) {
            resObj.setCode(201);
            resObj.setText("参数错误：invoice_id");
            return resObj;
        }

        int res = MybatisHandler.delUserInvoice(invoice_id, uid, i_type);
        if (res == 1) {
            resObj.setCode(200);
            resObj.setText("删除成功");
            return resObj;
        }

        resObj.setCode(500);
        resObj.setText("删除失败");
        return resObj;
    }

    @Override
    public ResObj changeDefaultInvoice(long uid, int invoice_id, byte i_type) throws TException {
        ResObj resObj = new ResObj();

        if (uid < 1) {
            resObj.setCode(201);
            resObj.setText("参数错误：uid");
            return resObj;
        }

        if (invoice_id < 1) {
            resObj.setCode(202);
            resObj.setText("参数错误：invoice_id");
            return resObj;
        }

        int res = MybatisHandler.setDefaultInvoice(uid, invoice_id, i_type);
        if (res == 1) {
            resObj.setCode(200);
            resObj.setText("修改成功");
            return resObj;
        }

        resObj.setCode(500);
        resObj.setText("修改失败");
        return resObj;
    }


}
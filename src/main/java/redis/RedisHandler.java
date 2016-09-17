package redis;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.JedisCluster;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RedisHandler {


    private final static Logger logger = LoggerFactory.getLogger(RedisHandler.class);

    /**
     * 根据id取用户信息
     *
     * @param uId
     * @return
     */
    public static Map<String, String> getUserInfo(final String uId) {
        Map<String, String> postsMap = RedisManager.doSomething(new RedisManager.JedisHandler<Map<String, String>>() {
            @Override
            protected Map<String, String> handle(JedisCluster jedis) {
                Map<String, String> map = jedis.hgetAll("obj_user:uid:" + uId);
                return map;
            }
        });
        return postsMap;
    }


    /**
     * 手机验证码 存入redis
     *
     * @param mobile
     * @return
     */
    public static String getPhoneCode(final String mobile, final int type) {

        String res = RedisManager.doSomething(new RedisManager.JedisHandler<String>() {
            @Override
            protected String handle(JedisCluster jedis) {
                if (type == 1) {
                    return jedis.get("gx_phone_code:" + mobile);
                }

                if (type == 2) {
                    return jedis.get("gx_change_password_code:" + mobile);
                }

                return null;

            }
        });
        return res;
    }

    /**
     * 手机验证码 存入redis，120s
     * type |
     *
     * @param mobile
     * @return
     */
    public static int setPhoneCode(final String mobile, final int phoneCode, final int type) {

        int res = RedisManager.doSomething(new RedisManager.JedisHandler<Integer>() {
            @Override
            protected Integer handle(JedisCluster jedis) {
                //注册
                if (type == 1) {
                    String key1 = "gx_phone_code:" + mobile;
                    jedis.set(key1, String.valueOf(phoneCode));
                    jedis.expire(key1, 120);
                    logger.debug("160917 001 >>> 手机验证码存入redis:" + key1 + ":" + phoneCode);
                    return 1;
                }

                //修改密码
                if (type == 2) {
                    String key2 = "gx_change_password_code:" + mobile;
                    String setsStr = jedis.set(key2, String.valueOf(phoneCode));
                    Long expire = jedis.expire(key2 + mobile, 120);
                    logger.debug("160917 001 >>> 手机验证码存入redis:" + key2 + ":" + phoneCode);
                    return 1;
                }

                return 0;
            }
        });
        return res;
    }

    /**
     * 根据uid取收货地址
     *
     * @param uid
     * @return
     */
    public static List<Map<String, String>> getUserAddresss(final String uid) {
        List<Map<String, String>> address = RedisManager.doSomething(new RedisManager.JedisHandler<List<Map<String, String>>>() {
            @Override
            protected List<Map<String, String>> handle(JedisCluster jedis) {
                List<Map<String, String>> address = new ArrayList<Map<String, String>>();
                Set<String> ids = jedis.zrevrange("obj_user_ship_address:sset:uid:" + uid, 0, -1);
                for (int i = 0; i < ids.size(); i++) {
                    Map<String, String> map = jedis.hgetAll("obj_user_ship_address:id:" + ids.toArray()[i]);
                    if (map != null && map.size() > 0) {
                        Map<String, String> areaInfo = jedis.hgetAll("ref_area:areaid:" + map.get("areaid"));
                        String areaStr = areaInfo.get("name");
                        if (!areaInfo.get("fatherid").equals("0")) {
                            Map<String, String> fatherAreaInfo = jedis.hgetAll("ref_area:areaid:" + areaInfo.get("fatherid"));
                            areaStr = fatherAreaInfo.get("name") + areaStr;
                            if (!fatherAreaInfo.get("fatherid").equals("0")) {
                                Map<String, String> grandfatherAreaInfo = jedis.hgetAll("ref_area:areaid:" + fatherAreaInfo.get("fatherid"));
                                areaStr = grandfatherAreaInfo.get("name") + areaStr;
                            }
                        }
                        map.put("areaStr", areaStr);
                        address.add(map);
                    }
                }

                return address;
            }
        });
        return address;
    }


    /**
     * 新增用户
     *
     * @param userInfo
     */
    public static int addUserInfo(final Map<String, String> userInfo) {
        return RedisManager.doSomething(new RedisManager.JedisHandler<Integer>() {
            @Override
            protected Integer handle(JedisCluster jedis) {
                jedis.zadd("obj_user:sset:u_name:" + userInfo.get("u_name"), 0, userInfo.get("uid"));
                jedis.zadd("obj_user:sset:mobile:" + userInfo.get("mobile"), 0, userInfo.get("uid"));
                jedis.hmset("obj_user:uid:" + userInfo.get("uid"), userInfo);
                return 1;
            }
        });
    }

    /**
     * 更新用户信息
     *
     * @param userInfo
     */
    public static void updateUserInfo(final Map<String, String> userInfo) {
        RedisManager.doSomething(new RedisManager.JedisHandler<Map<String, String>>() {
            @Override
            protected Map<String, String> handle(JedisCluster jedis) {
                jedis.hmset("obj_user:uid:" + userInfo.get("uid"), userInfo);
                return null;
            }
        });
    }

    /**
     * 删除用户信息
     *
     * @param userInfo
     */
    public static void deleteUserInfo(final Map<String, String> userInfo) {
        RedisManager.doSomething(new RedisManager.JedisHandler<Map<String, String>>() {
            @Override
            protected Map<String, String> handle(JedisCluster jedis) {
                jedis.del("obj_user:uid:" + userInfo.get("uid"));
                jedis.del("obj_user:sset:u_name:" + userInfo.get("u_name"));
                jedis.del("obj_user:sset:mobile:" + userInfo.get("mobile"));
                return null;
            }
        });
    }


    /**
     * 根据名称取用户信息
     *
     * @param uName
     * @return
     */
    public static Map<String, String> getUserInfoByUname(final String uName) {
        Map<String, String> postsMap = RedisManager.doSomething(new RedisManager.JedisHandler<Map<String, String>>() {
            @Override
            protected Map<String, String> handle(JedisCluster jedis) {
                Set<String> ids = jedis.zrange("obj_user:sset:u_name:" + uName, 0, -1);
                Map<String, String> map = jedis.hgetAll("obj_user:uid:" + ids.toArray()[0]);
                return map;
            }
        });
        return postsMap;
    }

    /**
     * 根据手机号取用户信息
     *
     * @param phone
     * @return
     */
    public static Map<String, String> getUserInfoByPhone(final String phone) {
        Map<String, String> postsMap = RedisManager.doSomething(new RedisManager.JedisHandler<Map<String, String>>() {
            @Override
            protected Map<String, String> handle(JedisCluster jedis) {
                Set<String> ids = jedis.zrange("obj_user:sset:mobile:" + phone, 0, -1);
                Map<String, String> map = jedis.hgetAll("obj_user:uid:" + ids.toArray()[0]);
                return map;
            }
        });
        return postsMap;
    }

    public static int addUserShipAddress(final Map<String, String> shipAddressMap) {
        final String id = shipAddressMap.get("id");
        final String uid = shipAddressMap.get("uid");
        final String flag = shipAddressMap.get("flag");

        int res = RedisManager.doSomething(new RedisManager.JedisHandler<Integer>() {
            @Override
            protected Integer handle(JedisCluster jedis) {
                String hmsetRes = jedis.hmset("obj_user_ship_address:id:" + id, shipAddressMap);
                System.out.println("===1========>>" + hmsetRes);
                Long zaddRes = jedis.zadd("obj_user_ship_address:sset:uid:" + uid, Long.parseLong(flag), id);
                System.out.println("===2========>>" + zaddRes);

                //默认地址
                if ("1".equals(flag)) {
                    jedis.zadd("obj_user_ship_address:sset:uid_flag:" + uid, 1, id);
                }

                return 1;
            }
        });

        return res;
    }


    public static int updateUserAddress(final Map<String, String> map) {
        final String id = map.get("id");
        final String uid = map.get("uid");
        final String flag = map.get("flag");

        int res = RedisManager.doSomething(new RedisManager.JedisHandler<Integer>() {
            @Override
            protected Integer handle(JedisCluster jedis) {

                String key = "obj_user_ship_address:id:" + id;
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    String field = entry.getKey();
                    String value = entry.getValue();
                    jedis.hset(key, field, value);
                }
                return 1;
            }
        });

        return res;
    }


    public static int delUserAddress(final String id, final String uid) {

        int res = RedisManager.doSomething(new RedisManager.JedisHandler<Integer>() {
            @Override
            protected Integer handle(JedisCluster jedis) {
                jedis.del("obj_user_ship_address:id:" + id);
                jedis.zrem("obj_user_ship_address:sset:uid:" + uid, id);
                jedis.zrem("obj_user_ship_address:sset:uid_flag:" + uid, id);
                return 1;
            }
        });

        return res;
    }


    public static Map<String, String> getAreaInfo(final String areaId) {
        Map<String, String> postsMap = RedisManager.doSomething(new RedisManager.JedisHandler<Map<String, String>>() {
            @Override
            protected Map<String, String> handle(JedisCluster jedis) {
                Map<String, String> map = jedis.hgetAll("ref_area:areaid:" + areaId);
                if (map != null && map.size() > 0) {
                    Map<String, String> areaInfo = jedis.hgetAll("ref_area:areaid:" + map.get("areaid"));
                    String areaStr = areaInfo.get("name");
                    if (!areaInfo.get("fatherid").equals("0")) {
                        Map<String, String> fatherAreaInfo = jedis.hgetAll("ref_area:areaid:" + areaInfo.get("fatherid"));
                        areaStr = fatherAreaInfo.get("name") + areaStr;
                        if (!fatherAreaInfo.get("fatherid").equals("0")) {
                            Map<String, String> grandfatherAreaInfo = jedis.hgetAll("ref_area:areaid:" + fatherAreaInfo.get("fatherid"));
                            areaStr = grandfatherAreaInfo.get("name") + areaStr;
                        }
                    }
                    map.put("areaStr", areaStr);
                }
                return map;
            }
        });
        return postsMap;
    }

    /**
     * 取城市列表
     *
     * @return
     */
    public static List<Map<String, String>> getCitysInfo() {
        List<Map<String, String>> citysInfo = RedisManager.doSomething(new RedisManager.JedisHandler<List<Map<String, String>>>() {
            @Override
            protected List<Map<String, String>> handle(JedisCluster jedis) {
                List<Map<String, String>> citys = new ArrayList<Map<String, String>>();
                Set<String> ids = jedis.zrange("ref_area:sset:path_level:1", 0, -1);
                for (int i = 0; i < ids.size(); i++) {
                    Map<String, String> map = jedis.hgetAll("ref_area:areaid:" + ids.toArray()[i]);
                    if (map != null && map.size() > 0) {
                        citys.add(map);
                    }
                }
                return citys;
            }
        });
        return citysInfo;
    }

    /**
     * 根据城市id取地区列表
     *
     * @return
     */
    public static List<Map<String, String>> getCountysInfo(final String cityid) {
        List<Map<String, String>> citysInfo = RedisManager.doSomething(new RedisManager.JedisHandler<List<Map<String, String>>>() {
            @Override
            protected List<Map<String, String>> handle(JedisCluster jedis) {
                List<Map<String, String>> citys = new ArrayList<Map<String, String>>();
                Set<String> ids = jedis.zrange("ref_area:sset:fatherid:" + cityid, 0, -1);
                for (int i = 0; i < ids.size(); i++) {
                    Map<String, String> map = jedis.hgetAll("ref_area:areaid:" + ids.toArray()[i]);
                    if (map != null && map.size() > 0) {
                        citys.add(map);
                    }
                }
                return citys;
            }
        });
        return citysInfo;
    }


    public static int setDefaultAddress(final String uid, final String address_id) {
        int res = RedisManager.doSomething(new RedisManager.JedisHandler<Integer>() {
            @Override
            protected Integer handle(JedisCluster jedis) {



                Set<String> addIdSet = jedis.zrange("obj_user_ship_address:sset:uid:" + uid, 0, -1);
                for (String addId :addIdSet){
                    if(addId.equals(address_id)){
                        jedis.hset("obj_user_ship_address:id:" + addId, "flag", "1");
                    }else{
                        jedis.hset("obj_user_ship_address:id:" + addId, "flag", "0");
                    }
                }

                Long zaddRes = jedis.zadd("obj_user_ship_address:sset:uid:" + uid, 1L, address_id);


                jedis.del("obj_user_ship_address:sset:uid_flag:" + uid);
                jedis.zadd("obj_user_ship_address:sset:uid_flag:" + uid, 1, address_id);
                return 1;
            }
        });

        return res;
    }


    public static int changeDefaultAddress(final String uid, final String pre_address_id, final String cur_address_id) {
        int res = RedisManager.doSomething(new RedisManager.JedisHandler<Integer>() {
            @Override
            protected Integer handle(JedisCluster jedis) {

                jedis.hset("obj_user_ship_address:id:" + pre_address_id, "flag", "0");
                jedis.hset("obj_user_ship_address:id:" + cur_address_id, "flag", "1");

                Long zaddRes = jedis.zadd("obj_user_ship_address:sset:uid:" + uid, 0L, pre_address_id);
                System.out.println("160914 001 >>> changeDefaultAddress >>> ========>>" + zaddRes);
                zaddRes = jedis.zadd("obj_user_ship_address:sset:uid:" + uid, 1L, cur_address_id);
                System.out.println("160914 002 >>> changeDefaultAddress >>> ========>>" + zaddRes);

                jedis.zrem("obj_user_ship_address:sset:uid_flag:" + uid, pre_address_id);
                jedis.zadd("obj_user_ship_address:sset:uid_flag:" + uid, 1L, cur_address_id);
                return 1;
            }
        });

        return res;
    }

    public static int updateIndUser(final Map<String, String> map) {

        final String uid = map.get("uid");

        int res = RedisManager.doSomething(new RedisManager.JedisHandler<Integer>() {
            @Override
            protected Integer handle(JedisCluster jedis) {

                String key = "obj_ind_user:uid:" + uid;
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    String field = entry.getKey();
                    String value = entry.getValue();

                    System.out.println(field + "<---------->" + value);
                    jedis.hset(key, field, value);
                }
                return 1;
            }
        });

        return res;
    }


    public static int addIndUser(final Map<String, String> indUserMap) {

        final String uid = indUserMap.get("uid");

        int res = RedisManager.doSomething(new RedisManager.JedisHandler<Integer>() {
            @Override
            protected Integer handle(JedisCluster jedis) {

                jedis.hmset("obj_ind_user:uid:" + uid, indUserMap);

                return 1;
            }
        });
        return res;
    }

    //获取默认地址
    public static Map getDefaultAddress(final long uid) {
        Map<String, String> ship_address = null;

        ship_address = RedisManager.doSomething(new RedisManager.JedisHandler<Map<String, String>>() {
            @Override
            protected Map<String, String> handle(JedisCluster jedis) {

                Set<String> set = jedis.zrevrange("obj_user_ship_address:sset:uid_flag:" + uid, 0, 1);

                if (set != null && set.size() > 0) {
                    String def_address_id = String.valueOf(set.toArray()[0]);
                    System.out.println("==123123=====>>" + def_address_id);

                    if (StringUtils.isNotEmpty(def_address_id)) {
                        return jedis.hgetAll("obj_user_ship_address:id:" + def_address_id);
                    }
                }

                return null;
            }
        });
        return ship_address;
    }


    //
    public static int changePwd(final String uid, final String new_pwd) {

        int res = RedisManager.doSomething(new RedisManager.JedisHandler<Integer>() {
            @Override
            protected Integer handle(JedisCluster jedis) {


                jedis.hset("obj_user:uid:" + uid, "u_pass", new_pwd);

                return 1;
            }
        });
        return res;
    }


    public static List<Map<String, String>> getUserInvoice(final long uid, final byte invoice_type) {

        return RedisManager.doSomething(new RedisManager.JedisHandler<List<Map<String, String>>>() {
            @Override
            protected List<Map<String, String>> handle(JedisCluster jedis) {
                List<Map<String, String>> invoiceList = new ArrayList<Map<String, String>>();

                String rangKey = "obj_user_invoice:sset:uid_i_type:" + uid + "_" + invoice_type;
                Set<String> ids = jedis.zrevrange(rangKey, 0, -1);

                for (int i = 0; i < ids.size(); i++) {
                    Map<String, String> map = jedis.hgetAll("obj_user_invoice:id:" + ids.toArray()[i]);
                    if (map != null && map.size() > 0) {
                        invoiceList.add(map);
                    }
                }

                return invoiceList;
            }
        });
    }

    public static int addUserInvoice(final Map<String, String> userInvoiceMap) {
        final String id = userInvoiceMap.get("id");
        final String uid = userInvoiceMap.get("uid");
        final String flag = userInvoiceMap.get("flag");
        final String i_type = userInvoiceMap.get("i_type");


        int res = RedisManager.doSomething(new RedisManager.JedisHandler<Integer>() {
            @Override
            protected Integer handle(JedisCluster jedis) {

                String hmsetRes = jedis.hmset("obj_user_invoice:id:" + id, userInvoiceMap);
                Long zaddRes = jedis.zadd("obj_user_invoice:sset:uid_i_type:" + uid + "_" + i_type, Long.parseLong(flag), id);

                //默认发票
                if ("1".equals(flag)) {
                    jedis.zadd("obj_user_invoice:sset:uid_i_type_flag:" + uid+"_"+i_type, 1, id);
                }

                return 1;
            }
        });

        return res;
    }

    public static int updateUserInvoice(final Map<String, String> map) {
        final String id = map.get("id");
        final String uid = map.get("uid");
        final String flag = map.get("flag");

        int res = RedisManager.doSomething(new RedisManager.JedisHandler<Integer>() {
            @Override
            protected Integer handle(JedisCluster jedis) {

                String key = "obj_user_address:id:" + id;
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    String field = entry.getKey();
                    String value = entry.getValue();
                    jedis.hset(key, field, value);
                }
                return 1;
            }
        });

        return res;
    }

    public static int delUserInvoice(final int invoice_id, final String uid, final byte i_type) {
        return RedisManager.doSomething(new RedisManager.JedisHandler<Integer>() {
            @Override
            protected Integer handle(JedisCluster jedis) {
                jedis.del("obj_user_invoice:id:" + invoice_id);
                jedis.zrem("obj_user_invoice:sset:uid_i_type:" + uid+"_"+i_type, String.valueOf(invoice_id));
                jedis.zrem("obj_user_invoice:sset:uid_i_type_flag:" + uid+"_"+i_type, String.valueOf(invoice_id));
                return 1;
            }
        });
    }

    public static int setDefaultInvoice(final long uid, final int invoice_id, final byte i_type) {
        int res = RedisManager.doSomething(new RedisManager.JedisHandler<Integer>() {
            @Override
            protected Integer handle(JedisCluster jedis) {

                Set<String> idSet = jedis.zrange("obj_user_invoice:sset:uid_i_type:" + uid+"_"+i_type, 0, -1);
                for (String id : idSet) {
                    if (id.equals(invoice_id)) {
                        jedis.hset("obj_user_invoice:id:" + id, "flag", "1");
                        jedis.zadd("obj_user_invoice:sset:uid_i_type:" + uid+"_"+i_type, 1L, id);
                    } else {
                        jedis.hset("obj_user_invoice:id:" + id, "flag", "0");
                        jedis.zadd("obj_user_invoice:sset:uid_i_type:" + uid+"_"+i_type, 0L, id);
                    }
                }

                jedis.del("obj_user_invoice:sset:uid_i_type_flag:" + uid+"_"+i_type);
                jedis.zadd("obj_user_invoice:sset:uid_i_type_flag:" + uid+"_"+i_type, 1L, String.valueOf(invoice_id));
                return 1;
            }
        });

        return res;
    }
}

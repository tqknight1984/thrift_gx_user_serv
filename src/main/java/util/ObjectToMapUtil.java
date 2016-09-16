package util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class ObjectToMapUtil {
    public static void main(String args[]) {
//		DboDntTousu tousu = new DboDntTousu();
//		tousu.setAddress("你好  北京 ");
//		tousu.setId(998);
//		tousu.setAddtime(new Date());
//		Map<String, String> map = changeToMap(tousu);
//		Set<String> sets = map.keySet();
//		for (String string : sets) {
//			com.poly.util.PrintUtil.println(string +":"+map.get(string));
//		}
    }


    public static Map<String, String> changeToMap(Object model) {
        Map<String, String> map = new HashMap<String, String>();
        Field[] field = model.getClass().getDeclaredFields(); // 获取实体类的所有属性，返回Field数组
        String newname = "";
        //StringUtils.parseRedisStr();
        try {
            for (int j = 0; j < field.length; j++) {
                // 遍历所有属性
                String name = field[j].getName(); // 获取属性的名字
                if ("KEY".equals(name) || "COLUMN_FLAG".equals(name))
                    continue;
                newname = name.toLowerCase();
                name = name.substring(0, 1).toUpperCase() + name.substring(1); // 将属性的首字符大写，方便构造get，set方法
                String type = field[j].getGenericType().toString(); // 获取属性的类型


                if (type.equals("class java.lang.String")) { // 如果type是类类型，则前面包含"class "，后面跟类名
                    Method m = model.getClass().getMethod("get" + name);
                    String value = (String) m.invoke(model); // 调用getter方法获取属性值
                    if (value == null)
                        map.put(newname, "NULL");
                    else
                        map.put(newname, parseRedisStr(value));

                }

                if (type.equals("class java.lang.Long")) {
                    Method m = model.getClass().getMethod("get" + name);
                    Long value = (Long) m.invoke(model);
                    if (value == null)
                        map.put(newname, "0");
                    else
                        map.put(newname, value + "");

                }

                if (type.equals("class java.lang.Byte")) {
                    Method m = model.getClass().getMethod("get" + name);
                    Byte value = (Byte) m.invoke(model);
                    if (value == null)
                        map.put(newname, "0");
                    else
                        map.put(newname, String.valueOf(value));
                }

                if (type.equals("class java.lang.Integer")) {
                    Method m = model.getClass().getMethod("get" + name);
                    Integer value = (Integer) m.invoke(model);
                    if (value == null)
                        map.put(newname, "0");
                    else
                        map.put(newname, value + "");

                }
                if (type.equals("int")) {
                    Method m = model.getClass().getMethod("get" + name);
                    Integer value = (Integer) m.invoke(model);
                    if (value == null)
                        map.put(newname, "0");
                    else
                        map.put(newname, value + "");

                }
                if (type.equals("class java.lang.Boolean")) {
                    Method m = model.getClass().getMethod("get" + name);
                    Boolean value = (Boolean) m.invoke(model);
                    if (value == null)
                        map.put(newname, "false");
                    else
                        map.put(newname, "" + value);
                }
                if (type.equals("class java.util.Date")) {
                    Method m = model.getClass().getMethod("get" + name);
                    Date value = (Date) m.invoke(model);
                    if (value == null)
                        map.put(newname, "NULL");
                    else {
                        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        String time = format.format(value);
                        time = time.replace("&nbsp", " ");
                        map.put(newname, parseRedisStr(time));
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }


    //为redis转换string
    public static String parseRedisStr(String str) {
        if (str == null || str.length() == 0)
            return "NULL";
        else if (" ".equals(str))
            return "&nbsp";
        else if (str.trim().length() == 0)
            return "NULL";
        return str.replace(" ", "&nbsp").replace("%", "&kmdt");
    }
}

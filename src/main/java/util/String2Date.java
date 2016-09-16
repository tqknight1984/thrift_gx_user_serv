package util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by app on 16/9/14.
 */
public class String2Date {

    //String dateStr = "2010/05/04 12:34:23";
    public static Date getDateByStr(String dateStr){

        Date date = new Date();
        //注意format的格式要与日期String的格式相匹配
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            date = sdf.parse(dateStr);
            System.out.println(date.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }

    public static Date getBirthdayByStr(String dateStr) {

        Date date = new Date();
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date = sdf.parse(dateStr);
            System.out.println(date.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }


}

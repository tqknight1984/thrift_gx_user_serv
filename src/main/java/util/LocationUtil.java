package util;

import org.apache.commons.lang.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * longitude and latitude
 *  http://lbsyun.baidu.com/index.php?title=webapi/guide/webservice-geocoding
 * Created by app on 16/9/16.
 */
public class LocationUtil {


    //tianqinhot        http://developer.baidu.com/platform/s10
    public static final String ak_key = "QOdQKGajcuPgRN1tkPFZnXRldKfd2IEf";


    /**
     * 返回输入地址的经纬度坐标
     * key lng(经度),lat(纬度)
     */
    public static Map<String,String> getGeocoderLatitude(String address){

        BufferedReader in = null;
        try {
            //将地址转换成utf-8的16进制
            address = URLEncoder.encode(address, "UTF-8");
//       如果有代理，要设置代理，没代理可注释
//      System.setProperty("http.proxyHost","192.168.1.188");
//      System.setProperty("http.proxyPort","3128");
            URL tirc = new URL("http://api.map.baidu.com/geocoder/v2/?address="+address+"&output=json&ak="+ak_key+"&callback=showLocation");

            in = new BufferedReader(new InputStreamReader(tirc.openStream(),"UTF-8"));
            String res;
            StringBuilder sb = new StringBuilder("");
            while((res = in.readLine())!=null){
                sb.append(res.trim());
            }
            String str = sb.toString();
            Map<String,String> map = null;
            if(StringUtils.isNotEmpty(str)){
                int lngStart = str.indexOf("lng\":");
                int lngEnd = str.indexOf(",\"lat");
                int latEnd = str.indexOf("},\"precise");
                if(lngStart > 0 && lngEnd > 0 && latEnd > 0){
                    String lng = str.substring(lngStart+5, lngEnd);
                    String lat = str.substring(lngEnd+7, latEnd);
                    map = new HashMap<String,String>();
                    map.put("lng", lng);
                    map.put("lat", lat);
                    return map;
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    public static void main(String args[]){
        Map<String, String> json = LocationUtil.getGeocoderLatitude("福建泉州安溪湖头");
        System.out.println("lng : "+json.get("lng"));
        System.out.println("lat : "+json.get("lat"));
    }

}

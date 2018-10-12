package cn.wonderxiao.util;

import com.alibaba.fastjson.JSONObject;
import com.qiniu.util.StringUtils;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.InetAddress;

/**
 * Created by xiaokai on 2018/10/10.
 */
@Service
public class AddressInfo {
    private static final Logger logger = LoggerFactory.getLogger(AddressInfo.class);
    private static final String URL_STR = "http://ip.taobao.com/service/getIpInfo.php?ip=";
    private static final String SOHU_IP = "http://pv.sohu.com/cityjson";
    private static final String[] HUADONG = {"上海","江苏","浙江","山东","安徽","江西","福建"};
    private static final String[] HUABEI = {"北京","天津","河北","山西","内蒙古"};
    //private static final String[] HUANAN = {"广东","广西","海南"};
    //private OkHttpClient client = new OkHttpClient();

    public Area getArea() throws IOException{
        String areaInfo = getInternetIp().getString("cname");
        String region = areaInfo.substring(0,2);
        for (String str: HUADONG){
            if(str.indexOf(region) > 0){
                return Area.HUA_DONG;
            }
        }
        for (String str: HUABEI){
            if (str.indexOf(region) > 0){
                return Area.HUA_BEI;
            }
        }
        return Area.HUA_NAN;
    }
    public Area getRegionToArea( ) throws IOException{
        String ip = getInternetIp().getString("cip");
        String region = getRegion(URL_STR,ip);
        for (String str: HUADONG){
            if(str.indexOf(region) > 0){
                return Area.HUA_DONG;
            }
        }
        for (String str: HUABEI){
            if (str.indexOf(region) > 0){
                return Area.HUA_BEI;
            }
        }
        return Area.HUA_NAN;
    }



    private String getRegion(String urlStr,String ip) {
        OkHttpClient client = new OkHttpClient();
        urlStr = urlStr + ip;
        Request request = new Request.Builder()
                .url(urlStr)
                .build();
        try (Response response = client.newCall(request).execute()){
            String retStr = response.body().string();
            JSONObject jsonObject = JSONObject.parseObject(retStr);
            return jsonObject.getString("region");
        } catch (Exception e){
            throw new RuntimeException();
        }
    }


    /**
     * 获得内网IP
     * @author xiaokai
     * @date 2018/10/10 17:49
     * @param
     * @return java.lang.String
     */        
    private String getIntranetIp() {
        try {
            InetAddress addr = InetAddress.getLocalHost();
            return addr.getHostAddress();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取外网ip
     * @author xiaokai
     * @date 2018/10/10 18:56
     * @param
     * @return java.lang.String
     */
    private JSONObject getInternetIp(){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(SOHU_IP)
                .build();
        try (Response response = client.newCall(request).execute()){
            String retStr = response.body().string();
            String subRetStr = retStr.substring(19,retStr.length()-1);
            System.out.println(subRetStr);
            JSONObject jsonTemp = JSONObject.parseObject(subRetStr);
            return jsonTemp;
        }catch (IOException e){
            throw new RuntimeException();
        }

    }

    /*
    private String getLocation(){
        Request request = new Request.Builder()
                .url(LOCATION_IP)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String retStr = response.body().string();
            JSONObject json = JSONObject.parseObject(retStr);
            String location = json.getString("location");
            return AddressInfo.decodeUnicode(location);
        }catch (Exception e){
            throw new RuntimeException();
        }
    }

    private static String decodeUnicode(String s){
        StringBuffer buffer = new StringBuffer();
        int start = 0;
        while (start > -1){
            int end = s.indexOf("\\u",start + 2);
            String charStr;
            if (end == -1){
                charStr = s.substring(start + 2, s.length());
            } else {
                charStr = s.substring(start + 2, end);
            }
            char letter = (char) Integer.parseInt(charStr,16);
            buffer.append(Character.toString(letter));
            start = end;
        }
        return buffer.toString();
    }
    */



    public static void main(String[] args) throws Exception{
        AddressInfo addressInfo = new AddressInfo();
        Area area = addressInfo.getArea();
        System.out.println(area);

    }
}

package cn.wonderxiao.services;

import cn.wonderxiao.util.AddressInfo;
import cn.wonderxiao.util.Area;
import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;


/**
 * Created with IntelliJ IDEA.
 * Description:
 * Created by xiaokai on 2018/10/10.
 */

public class FileUpload {
    /*@Autowired
    private AddressInfo addressInfo;*/

    private static final Logger logger = LoggerFactory.getLogger(FileUpload.class);

    public DefaultPutRet getUploadResult(String accessKey, String secretKey, String bucket, String path)
            throws IOException{
        AddressInfo addressInfo = new AddressInfo();
        Area locationIndex = addressInfo.getArea();
        Zone zone;
        switch (locationIndex){
            case HUA_DONG: zone = Zone.zone0();break;
            case HUA_BEI: zone = Zone.zone1();break;
            case HUA_NAN: zone = Zone.zone2();break;
            default: zone = Zone.zone0();
        }
        Configuration cfg = new Configuration(zone);
        UploadManager uploadManager = new UploadManager(cfg);
        String key = null;
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);
        try {
            Response response = uploadManager.put(path,key,upToken);
            return new Gson().fromJson(response.bodyString(),DefaultPutRet.class);
        }catch (QiniuException e){
            logger.error(e.response.toString());
            try {
                logger.error(e.response.bodyString());
            }catch (QiniuException e1){
                logger.error(e1.toString());
            }
        }
        return null;
    }

    public static void main(String[] args) throws IOException{
        String accessKey = "afpdvmikmQfjTRWcYySHaL7QHP1h0QkIBHssRjj_";
        String secretKey = "0VebZvkvzVCcQTSmYszeNaw8RJkW9jEKQxpeEb1Z";
        String bucket = "img1001";
        String path = "D:\\Downloads\\Operating_Systems_Three_Easy_Pieces_.pdf";
        FileUpload fileUpload = new FileUpload();
        DefaultPutRet putRet = fileUpload.getUploadResult(accessKey,secretKey,bucket,path);
        System.out.println(putRet.key);
        System.out.println(putRet.hash);

    }
}

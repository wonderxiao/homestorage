package cn.wonderxiao.util;

import com.qiniu.util.Auth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by xiaokai on 2018/10/10.
 */
public class TokenInfo {
    private static final Logger logger = LoggerFactory.getLogger(TokenInfo.class);

    public static String getSimpleUpToken(String accessKey, String secretKey, String bucket){
        Auth auth = Auth.create(accessKey, secretKey);
        return auth.uploadToken(bucket);
    }

    public static String getCoverUpToken(String accessKey, String secretKey, String bucket, String key){
        Auth auth = Auth.create(accessKey, secretKey);
        return auth.uploadToken(bucket, key);
    }


}

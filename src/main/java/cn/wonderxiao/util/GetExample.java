package cn.wonderxiao.util;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Created by xiaokai on 2018/10/10.
 */
public class GetExample {
    OkHttpClient client = new OkHttpClient();

    String run(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    public static void main(String[] args) throws IOException {
        GetExample example = new GetExample();
        String response = example.run("http://ip.taobao.com/service/getIpInfo.php?ip=125.71.229.17");
        System.out.println(response);
    }
}

package com.xiaoju.uemc.wheeljack.web;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

public class PostDemo {
    @SuppressWarnings("deprecation")
    public static void main(String []args) throws IOException {
        HttpClient httpClient = new DefaultHttpClient();
        try {
            //HttpPost request = new HttpPost("http://kefu.xiaojukeji.com/crm/index.php?r=service/satisfaction/recordEvent");
            HttpPost request = new HttpPost("http://httpbin.org/post");
            StringEntity params =new StringEntity("details={\"name\":\"myname\",\"age\":\"20\"} ");
            request.addHeader("content-type", "application/json");
            request.addHeader("Accept","application/json");
            request.setEntity(params);
            HttpResponse resp = httpClient.execute(request);
            InputStream in = resp.getEntity().getContent();
            String result = IOUtils.toString(in, "UTF-8");
            System.out.println(result);
        }catch (Exception ex) {
            // handle exception here
            //ex.printStackTrace();
        } finally {
            httpClient.getConnectionManager().shutdown();
        }
    }
}


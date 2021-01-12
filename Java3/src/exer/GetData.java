package exer;

import com.alibaba.fastjson.JSONObject;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * @author 石致彬
 * @create 2020-12-28 15:13
 */
public class GetData {
    public static String getData(String country)  {
        HttpGet get = new HttpGet("https://covid-api.mmediagroup.fr/v1/cases?country="+country);
        CloseableHttpClient client = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        String buffer = "";
        try {
            response = client.execute(get);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (response.getCode() == 200) {
            InputStream in = null;
            try {
                HttpEntity entity = response.getEntity();
                in = entity.getContent();
                byte[] bytes = new byte[100000];
                int len;
                while ((len = in.read(bytes))!=-1) {
                     buffer += new String(bytes,0,len);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (in != null)
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return buffer;
    }

    public static ArrayList<String> getAllKey(JSONObject jsonObject) {
        ArrayList<String> list = new ArrayList<>();
        if (jsonObject == null || jsonObject.isEmpty()) {
            return null;
        }
        String str = "";
        jsonObject.forEach((key,value)->{
            list.add(key);
        });
        return list;
    }
}

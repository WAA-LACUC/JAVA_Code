import org.apache.http.*;
import org.apache.http.NameValuePair;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.util.*;

public class Client {
    static final int HTTP_OK = 200;
    static final int HTTP_UNAUTORIZED = 401;

    public Client() {

    }

    public boolean LoginCheckByGet(String adminID, String adminPass) {
        String iptimeURL = "/cgi-bin/timepro.cgi?tmenu=main_frame&smenu=main_frame";
//        String requestURL = "http://" + TraceRoute.GetGateWay() + iptimeURL;
        String requestURL = "http://" + "192.168.0.1" + iptimeURL;

        try {
            CloseableHttpClient client = HttpClients.createDefault();
            HttpGet request = new HttpGet(requestURL);

            String encodedAuth = Base64.getEncoder().encodeToString((adminID + ":" + adminPass).getBytes());
            request.setHeader("Authorization", "Basic " + encodedAuth);

            CloseableHttpResponse response = client.execute(request);
            int responseCode = response.getStatusLine().getStatusCode();
            response.close();


            return responseCode == HTTP_OK;

        } catch (Exception e) {
            System.out.println(e.toString());
            System.exit(1);
        }
        return false;
    }

    public boolean LoginCheckByPost(String adminID, String adminPass) {
        String iptimeURL = "/sess-bin/login_handler.cgi";
//            String requestURL = "http://" + TraceRoute.GetGateWay() + iptimeURL;
        String requestURL = "http://" + "192.168.0.1" + iptimeURL;
        try {
            CloseableHttpClient client = HttpClients.createDefault();
            HttpPost request = new HttpPost(requestURL);

            List<NameValuePair> params = new ArrayList<>();

            params.add(new BasicNameValuePair("username", adminID));
            params.add(new BasicNameValuePair("passwd", adminPass));
            request.setEntity(new UrlEncodedFormEntity(params));

            CloseableHttpResponse response = client.execute(request);
            HttpEntity entity = response.getEntity();
            boolean result = EntityUtils.toString(entity).contains("setCookie");
            int responseCode = response.getStatusLine().getStatusCode();
            response.close();

            return responseCode == HTTP_OK && result;

        } catch (Exception e) {
            System.out.println(e.toString());
            System.exit(1);
        }
        return false;
    }
}

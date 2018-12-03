import java.io.Closeable;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

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
            System.out.println(response.getStatusLine().toString());
            response.close();


            return responseCode == HTTP_OK;

        } catch (Exception e) {
            System.out.println(e.toString());
            System.exit(1);
        }
        return false;
    }

    public boolean LoginCheckByPost(String adminID, String adminPass) {
//        try {
//            URL routerURL = new URL(TraceRoute.GetGateWay());
//            HttpURLConnection connection = (HttpURLConnection) routerURL.openConnection();
//
//            connection.setRequestMethod("POST");
//            connection.setDoOutput(true);
//        } catch (Exception e) {
//            System.out.println(e.toString());
//            System.exit(1);
//        }
        return false;
    }
}

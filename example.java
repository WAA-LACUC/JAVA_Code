import java.io.IOException;
import java.net.MalformedURLException;
import java.util.*;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

class ConnectToUrlUsingBasicAuthentication {

//    public static void main(String[] args) {
//
//        try {
//            String webPage = "http://192.168.0.1";
//            String name = "admin";
//            String password = "admin";
//
//            String authString = name + ":" + password;
//            System.out.println("auth string: " + authString);
//            byte[] authEncBytes = Base64.getEncoder().encode(authString.getBytes());
//            String authStringEnc = new String(authEncBytes);
//            System.out.println("Base64 encoded auth string: " + authStringEnc);
//
//            URL url = new URL(webPage);
//            URLConnection urlConnection = url.openConnection();
//            urlConnection.setRequestProperty("Authorization", "Basic " + authStringEnc);
//            InputStream is = urlConnection.getInputStream();
//            InputStreamReader isr = new InputStreamReader(is);
//
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

}

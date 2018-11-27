import java.net.*;

public class Client
{
    private String adminID;
    private String adminPass;

    public Client()
    {

    }

    private String GetGatewayIP()
    {
        return "";
    }

    public boolean LoginCheckByGet()
    {
        try
        {
            URL routerURL = new URL(GetGatewayIP());
            HttpURLConnection connection = (HttpURLConnection) routerURL.openConnection();

            connection.setRequestMethod("GET");
        }
        catch (Exception e)
        {
            System.out.println(e.toString());
            System.exit(1);
        }
        return false;
    }

    public boolean LoginCheckByPost()
    {
        try
        {
            URL routerURL = new URL(GetGatewayIP());
            HttpURLConnection connection = (HttpURLConnection) routerURL.openConnection();

            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
        }
        catch (Exception e)
        {
            System.out.println(e.toString());
            System.exit(1);
        }
        return false;
    }
}

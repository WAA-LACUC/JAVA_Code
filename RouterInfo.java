public class RouterInfo
{
    private RouterInfo()
    {

    }

    public static String GetAdminID(Company company)
    {
        switch (company)
        {
            case ASUS:
                return "admin";
            case IPTIME:
                return "admin";
            default:
                return null;
        }
    }

    public static String GetAdminPass(Company company)
    {
        switch (company)
        {
            case ASUS:
                return "admin";
            case IPTIME:
                return "admin";
            default:
                return null;
        }
    }
}

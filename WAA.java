public class WAA {
    public static void main(String args[]) {
        Client client = new Client();
        String adminID;
        String adminPass;


        boolean getCheck = false;
        for (Company company : Company.values()) {
            if (getCheck)
                break;
            adminID = RouterInfo.GetAdminID(company);
            adminPass = RouterInfo.GetAdminPass(company);

            getCheck = client.LoginCheckByGet(adminID, adminPass);
        }

        boolean postCheck = false;
        for (Company company : Company.values()) {
            if (postCheck)
                break;
            adminID = RouterInfo.GetAdminID(company);
            adminPass = RouterInfo.GetAdminPass(company);

            postCheck = client.LoginCheckByPost(adminID, adminPass);
        }
        System.out.println(getCheck);
        System.out.println(postCheck);

        if(getCheck || postCheck)
        {
            System.out.println("라우터 시스템의 보안수준이 낮습니다.");
            System.out.println("관리자 아이디, 비밀번호를 변경해주세요.");
        }
        else
        {
            System.out.println("정상.");
        }
    }
}

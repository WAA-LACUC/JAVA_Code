import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//상원 고생했어!
public class TraceRoute {

    public static String GetGateWay() {
        BufferedReader in;
        int count = 0;
        String iptime; //최종 gatway저장 변수
        try {
            Runtime runtime = Runtime.getRuntime();
            Process process = runtime.exec("traceroute www.google.com"); //경로 구글로 임의로 설정

            in = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line; //line변수에 경로저장후 출력

            if (process == null)
                return null;

            while ((line = in.readLine()) != null) { //trace router(경로가 구글로해서 ) 탐색 반복문

                //System.out.println(count);
                count++;
                if (count == 2) //count값 설정해서 첫번째 trace값(gateway)만 얻고 탈출
                    break;
            }

            return line.substring(line.length() - 14, line.length()); //iptime변수에 trace값 을 잘라서 원하는 gateway값만 얻어서 저장
        } catch (IOException e) {
            System.out.println(e.toString());
        }
        return null;
    }
}

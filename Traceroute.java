package test1;
import java.io.*;
import java.net.*;
import java.lang.*;
//상원 고생했어!
public class Traceroute {
	public static void main(String args[]) {
		BufferedReader in;
		int count=0;
		String iptime; //최종 gatway저장 변수
		try {
			Runtime r = Runtime.getRuntime();
			Process p = r.exec("tracert www.google.com"); //경로 구글로 임의로 설정
			
			in = new BufferedReader(new InputStreamReader(p.getInputStream()));
			
			String line; //line변수에 경로저장후 출력
			
			if(p==null)
				System.out.println("could not connect");
			
			while((line=in.readLine())!=null) { //trace router(경로가 구글로해서 ) 탐색 반복문
				
				System.out.println(line); //경로 출력
				//System.out.println(count);
				count++;
				if(count==5) //count값 설정해서 첫번째 trace값(gateway)만 얻고 탈출 
					break;
			}
			System.out.println("두번째"+line);
			iptime = line.substring(line.length()-14,line.length()); //iptime변수에 trace값 을 잘라서 원하는 gateway값만 얻어서 저장
			System.out.println("결과값 "+iptime); //iptime 출력
		}catch(IOException e) {
			System.out.println(e.toString());
		}
		
	}

}

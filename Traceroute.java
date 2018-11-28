package test1;
import java.io.*;
import java.net.*;
import java.lang.*;

public class Traceroute {
	public static void main(String args[]) {
		BufferedReader in;
		int count=0;
		String iptime; //���� gatway���� ����
		try {
			Runtime r = Runtime.getRuntime();
			Process p = r.exec("tracert www.google.com"); //��� ���۷� ���Ƿ� ����
			
			in = new BufferedReader(new InputStreamReader(p.getInputStream()));
			
			String line; //line������ ��������� ���
			
			if(p==null)
				System.out.println("could not connect");
			
			while((line=in.readLine())!=null) { //trace router(��ΰ� ���۷��ؼ� ) Ž�� �ݺ���
				
				System.out.println(line); //��� ���
				//System.out.println(count);
				count++;
				if(count==5) //count�� �����ؼ� ù��° trace��(gateway)�� ��� Ż�� 
					break;
			}
			System.out.println("�ι�°"+line);
			iptime = line.substring(line.length()-14,line.length()); //iptime������ trace�� �� �߶� ���ϴ� gateway���� �� ����
			System.out.println("����� "+iptime); //iptime ���
		}catch(IOException e) {
			System.out.println(e.toString());
		}
		
	}

}

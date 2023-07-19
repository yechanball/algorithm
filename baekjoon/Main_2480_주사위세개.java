package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2480_주사위세개 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());		
		int c = Integer.parseInt(st.nextToken());
		
		if(a == b) {
			if(b == c) System.out.println(10000 + a*1000);
			else System.out.println(1000 + a*100);
		}else if(b == c) System.out.println(1000 + b*100);
		else if(c == a) System.out.println(1000 + c*100);
		else System.out.println(Math.max(Math.max(a, b), c)*100);	
	}
}

package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11005_진법변환2 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		StringBuffer sb = new StringBuffer();

		while(N > 0) {
			int value = N % B;
			
			if(value >= 10) sb.append((char)(value-10+'A'));
			else sb.append(value);
			
			N /= B;
		}
		
		System.out.println(sb.reverse().toString());
	}
}

package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2745_진법변환 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		String N = st.nextToken();
		int B = Integer.parseInt(st.nextToken());
		
		long num = 0, value = 1;
		for (int i = N.length()-1; i >= 0; i--) {
			char ch = N.charAt(i);
			
			if(Character.isDigit(ch)) num += (ch-'0')*value;
			else num += (ch-'A'+10)*value;
			
			value *= B;
		}
		
		System.out.println(num);
	}
}

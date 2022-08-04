package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_4153_직각삼각형 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int a, b, c;
		
		while(true) {
			st = new StringTokenizer(in.readLine(), " ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			
			if(a == 0 && b == 0 && c == 0) break;
			
			a *= a;
			b *= b;
			c *= c;
			
			if(a+b == c || b+c == a || c+a == b) sb.append("right").append("\n");
			else sb.append("wrong").append("\n");
		}
		System.out.print(sb);
	}
}

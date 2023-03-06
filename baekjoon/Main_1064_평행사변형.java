package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1064_평행사변형 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int xa = Integer.parseInt(st.nextToken());
		int ya = Integer.parseInt(st.nextToken());
		int xb = Integer.parseInt(st.nextToken());
		int yb = Integer.parseInt(st.nextToken());
		int xc = Integer.parseInt(st.nextToken());
		int yc = Integer.parseInt(st.nextToken());
		
		if((ya-yb)*(xb-xc) == (yb-yc)*(xa-xb)) System.out.print(-1.0);
		else {
			double dist1 = Math.sqrt(Math.pow(xa-xb, 2) + Math.pow(ya-yb, 2));
			double dist2 = Math.sqrt(Math.pow(xb-xc, 2) + Math.pow(yb-yc, 2));
			double dist3 = Math.sqrt(Math.pow(xc-xa, 2) + Math.pow(yc-ya, 2));
			
			double len1 = (dist1 + dist2) * 2;
			double len2 = (dist2 + dist3) * 2;
			double len3 = (dist3 + dist1) * 2;
			
			double maxLen = Math.max(Math.max(len1,len2), len3);
			double minLen = Math.min(Math.min(len1,len2), len3);
			
			System.out.print(maxLen - minLen);
		}
	}
}

package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1069_집으로 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		
		double dist = Math.sqrt(X*X + Y*Y);
		double minTime = dist;
		
		if(dist >= D) {
			minTime = Math.min(minTime, (int)dist/D * T + dist%D);
			minTime = Math.min(minTime, ((int)dist/D+1) * T);
		}else {
			minTime = Math.min(minTime, T + D - dist);
			minTime = Math.min(minTime, 2 * T);			
		}
		
		System.out.print(minTime);
	}
}

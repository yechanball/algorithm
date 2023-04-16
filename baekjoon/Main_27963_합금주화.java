package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_27963_합금주화 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int d1 = Integer.parseInt(st.nextToken());
		int d2 = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		
		int maxD = Math.max(d1, d2);
		int minD = Math.min(d1, d2);
		
		double V = ((double)X)/((double)maxD) + ((double)(100 - X))/((double)minD);
		double D = 100/V;
		
		System.out.print(D);
	}
}

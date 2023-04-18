package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_13305_주유소 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		long[] road = new long[N-1];
		for (int i = 0; i < N-1; i++) {
			road[i] = Long.parseLong(st.nextToken());
		}
		
		long cost = 0, minPrice = Long.MAX_VALUE;
		
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N-1; i++) {
			minPrice = Math.min(minPrice, Long.parseLong(st.nextToken()));
			cost += minPrice*road[i];
		}
		
		System.out.print(cost);
	}
}

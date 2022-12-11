package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_17626_FourSquares {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[] dp = new int[N+1];
		dp[1] = 1;
		for (int i = 2; i <= N; i++) {
			int num = 0, min = Integer.MAX_VALUE;
			while(++num <= Math.sqrt(i)) {
				min = Math.min(min, dp[i - num*num]);
			}
			dp[i] = min + 1;
		}
		System.out.print(dp[N]);
	}
}

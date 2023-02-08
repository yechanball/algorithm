package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2748_피보나치수2 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		long[] dp = new long[N+1];
		dp[1] = 1;

		for (int i = 2; i <= N; i++){
			dp[i] = dp[i-1] + dp[i-2];
		}
		System.out.print(dp[N]);
	}
}

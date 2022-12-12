package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_11727_2xn타일링2 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine()), mod = 10_007;
		int[] dp = new int[N+1];
		dp[1] = 1;
		if(N > 1) {
			dp[2] = 3;
			for (int i = 3; i <= N; i++) {
				dp[i] = (dp[i-2]*2 + dp[i-1]) % mod;
			}			
		}
		System.out.print(dp[N]);
	}
}

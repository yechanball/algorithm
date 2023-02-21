package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_15624_피보나치수7 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
        if(N > 0) {
        	long dp[] = new long[N + 1];
        	dp[1] = 1;
        	for (int i = 2; i <= N; i++) {
				dp[i] = (dp[i-1] + dp[i-2]) % 1_000_000_007;
			}
        	System.out.print(dp[N]);
        }else {
        	System.out.print(0);
        }
	}
}

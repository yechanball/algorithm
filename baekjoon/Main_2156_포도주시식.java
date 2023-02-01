package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2156_포도주시식 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int[][] dp = new int[n][3];
		dp[0][1] = Integer.parseInt(in.readLine());
		for (int i = 1; i < n; i++) {
			int wine = Integer.parseInt(in.readLine());
			dp[i][0] = Math.max(Math.max(dp[i-1][0], dp[i-1][1]), dp[i-1][2]);
			dp[i][1] = dp[i-1][0] + wine;
			dp[i][2] = dp[i-1][1] + wine;
		}
		System.out.print(Math.max(Math.max(dp[n-1][0], dp[n-1][1]), dp[n-1][2]));
	}
}

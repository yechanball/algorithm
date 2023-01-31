package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1912_연속합 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int[] arr = new int[n];
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[n];
		dp[0] = arr[0];
		int max = arr[0];
		for (int i = 1; i < n; i++) {
			dp[i] = Math.max(dp[i-1] + arr[i], arr[i]);
			max = Math.max(max, dp[i]);
		}
		
		System.out.print(max);
	}
}

package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11722_가장긴감소하는부분수열 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine()), maxLen = 0;
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int[] A = new int[N];
		int[] dp = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if(A[j] > A[i]) dp[i] = Math.max(dp[i], dp[j] + 1);
			}
			maxLen = Math.max(maxLen, dp[i]);
		}
		System.out.print(maxLen);
	}
}

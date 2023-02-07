package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11055_가장큰증가부분수열 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine()), maxSum = 0;
		int[] A = new int[N+1];
		int[] dp = new int[N+1];

		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 1; i <= N; i++){
			A[i] = Integer.parseInt(st.nextToken());
			for (int j = 0; j < i; j++){
				if(A[j] < A[i] && dp[i] < dp[j] + A[i]){
					dp[i] = dp[j] + A[i];
					maxSum = Math.max(maxSum, dp[i]);
				}
			}
		}
		System.out.print(maxSum);
	}
}

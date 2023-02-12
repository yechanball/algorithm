package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14501_퇴사 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		
		int[] T = new int[N+1];
		int[] P = new int[N+1];
		int[] dp = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
			
			if(i + T[i] <= N + 1) dp[i] = P[i];
		}
		
		for (int i = N; i >= 0; i--) {
			int max = 0;
			for (int j = i + T[i]; j <= N; j++) {
				max = Math.max(max, dp[j]);
			}
			dp[i] += max;
		}
		
		System.out.print(dp[0]);
	}
}

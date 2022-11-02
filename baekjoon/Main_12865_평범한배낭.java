package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_12865_평범한배낭 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); // 물품의 수
		int K = Integer.parseInt(st.nextToken()); // 가능한 최대 무게
		
		int[] w = new int[N+1]; // 각 물건의 무게
		int[] v = new int[N+1]; // 각 물건의 가치
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			w[i] = Integer.parseInt(st.nextToken());
			v[i] = Integer.parseInt(st.nextToken());
		}
		
		int[][] dp = new int[N+1][K+1]; // dp 배열
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= K; j++) {
				if(w[i] > j) dp[i][j] = dp[i-1][j];
				else dp[i][j] = Math.max(v[i] + dp[i-1][j-w[i]], dp[i-1][j]);
			}
		}
		
		int maxValue = 0;
		for (int i = 0; i <= K ; i++) {
			if(dp[N][i] > maxValue) {
				maxValue = dp[N][i];
			}
		}
		
		System.out.print(maxValue);
	}
}

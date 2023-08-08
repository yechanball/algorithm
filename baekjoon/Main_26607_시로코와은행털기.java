package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_26607_시로코와은행털기 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		
		int[] power = new int[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			power[i] = Integer.parseInt(st.nextToken());
		}
		
		boolean[][][] dp = new boolean[80][81][16001];
		dp[0][1][power[0]] = true;
		
	    for (int i = 1; i < n; i++) {
	        dp[i][0][0] = true;
	        dp[i][1][power[i]] = true;
	        
	        for (int j = 1; j <= i+1; j++) {
	            for (int p = 0; p <= x*k; p++) {
	                if (p - power[i] >= 0 && j > 0) {
	                	dp[i][j][p] |= dp[i - 1][j - 1][p - power[i]];	                	
	                }
	                dp[i][j][p] |= dp[i - 1][j][p];
	            }
	        }
	    }

	    int ans = 0;
	    for (int p = 0; p <= x*k; p++) {
	        if (dp[n - 1][k][p]) ans = Math.max(ans, p * (k * x - p));
	    }
		System.out.print(ans);
	}
}

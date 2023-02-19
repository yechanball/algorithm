package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_10211_MaximumSubarray {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine());
		for (int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(in.readLine()), maxSum = -1000;
			int[] dp = new int[N+1];
			
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int i = 1; i <= N; i++) {
				int x = Integer.parseInt(st.nextToken());
				
				dp[i] = Math.max(0, dp[i-1]) + x;
				maxSum = Math.max(maxSum, dp[i]);
			}
			sb.append(maxSum + "\n");
		}
		
		out.write(sb.toString());
		out.flush();
		out.close();
	}
}

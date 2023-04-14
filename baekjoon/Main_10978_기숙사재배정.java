package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_10978_기숙사재배정 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		long[] dp = new long[21];
		dp[1] = 0;
		dp[2] = 1;
		for(int i = 3; i <= 20; i++){
			dp[i] = (dp[i-1] + dp[i-2]) * (i-1);
		}

		int T = Integer.parseInt(in.readLine());
		for(int tc = 1; tc <= T; tc++){
			int N = Integer.parseInt(in.readLine());
			out.write(dp[N] + "\n");
		}
		out.flush();
		out.close();
	}
}

package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1699_제곱수의합 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
        int dp[] = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            dp[i] = i;
            
            int num = 1;
            while(num * num <= i) {
            	dp[i] = Math.min(dp[i], dp[i - num * num] + 1);
            	num++;
            }
        }
        System.out.print(dp[N]);
	}
}

package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_5582_공통부분문자열 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str1 = in.readLine(), str2 = in.readLine();
		int len1 = str1.length(), len2 = str2.length();
		
		int maxLen = 0;
		int[][] dp = new int[len1+1][len2+1];
		for (int i = 1; i <= len1; i++) {
			for (int j = 1; j <= len2; j++) {
				if(str1.charAt(i-1) == str2.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1] + 1;
					maxLen = Math.max(dp[i][j], maxLen);
				}
			}
		}
		System.out.print(maxLen);
	}
}

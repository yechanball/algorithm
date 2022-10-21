package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_9251_LCS {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String str1 = in.readLine();
		String str2 = in.readLine();
		int len1 = str1.length();
		int len2 = str2.length();
		
		int[][] LCS = new int[len1+1][len2+1];
		for (int i = 1; i <= len1; i++) {
			for (int j = 1; j <= len2; j++) {
				if(str1.charAt(i-1) == str2.charAt(j-1)) {
					LCS[i][j] = LCS[i-1][j-1] + 1;
				}else {
					LCS[i][j] = Math.max(LCS[i-1][j], LCS[i][j-1]);
				}
			}
		}
		
		System.out.print(LCS[len1][len2]);
		
		/*for (int i = 0; i <= len1; i++) {
			for (int j = 0; j <= len2; j++) {
				System.out.print(LCS[i][j]+" ");
			}
			System.out.println("");
		}
		
		StringBuilder sb = new StringBuilder();
		int r = len1, c = len2, cnt = LCS[r][c];
		while(cnt > 0) {
			if(cnt == LCS[r-1][c]) {
				r--;
			}else if(cnt == LCS[r][c-1]) {
				c--;
			}else {
				sb.append(str1.charAt(r-1));
				cnt--;
				r--;
				c--;
			}
		}
		
		System.out.println(sb.reverse().toString());*/
	}
}

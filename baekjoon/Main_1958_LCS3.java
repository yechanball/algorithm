package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1958_LCS3 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String str1 = in.readLine();
		String str2 = in.readLine();
		String str3 = in.readLine();
		
		int len1 = str1.length();
		int len2 = str2.length();
		int len3 = str3.length();
		
		int[][][] LCS = new int[len1+1][len2+1][len3+1];
		for (int i = 1; i <= len1; i++) {
			for (int j = 1; j <= len2; j++) {
				for (int k = 1; k <= len3; k++) {
					if(str1.charAt(i-1) == str2.charAt(j-1) && str2.charAt(j-1) == str3.charAt(k-1)) {
						LCS[i][j][k] = LCS[i-1][j-1][k-1] + 1;
					}else {
						LCS[i][j][k] = Math.max(Math.max(LCS[i-1][j][k], LCS[i][j-1][k]), LCS[i][j][k-1]);
					}
				}
			}
		}
		
		System.out.println(LCS[len1][len2][len3]);

//		StringBuilder sb = new StringBuilder();
//		int x = len1, y = len2, z = len3, cnt = LCS[x][y][z];
//		while(cnt > 0) {
//			if(cnt == LCS[x-1][y][z]) {
//				x--;
//			}else if(cnt == LCS[x][y-1][z]) {
//				y--;
//			}else if(cnt == LCS[x][y][z-1]) {
//				z--;
//			}else {
//				sb.append(str1.charAt(x-1));
//				cnt--;
//				x--;
//				y--;
//				z--;
//			}
//		}
//		
//		System.out.println(sb.reverse().toString());
	}
}

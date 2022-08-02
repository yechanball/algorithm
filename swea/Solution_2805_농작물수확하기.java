package algorithm.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_2805_농작물수확하기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str;
		int T = Integer.parseInt(in.readLine());
		int N = 0, delCnt, value;
		
		for (int testcase = 1; testcase <= T; testcase++) {
			sb.append("#").append(testcase).append(" ");
			value = 0;
			N = Integer.parseInt(in.readLine());
			for (int i = 0; i < N; i++) {
				str = in.readLine();
				// 입력 받지 않을 부분 처리
				delCnt = Math.abs(N/2 - i);
				// 마름모 영역만 읽어서 총합 구하기
				for (int j = delCnt; j < N-delCnt; j++) {
					value += str.charAt(j)-'0';
				}
			}
			sb.append(value).append("\n");
		}
		System.out.println(sb);
	}
}

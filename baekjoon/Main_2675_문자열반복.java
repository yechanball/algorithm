package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2675_문자열반복 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(in.readLine());
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(in.readLine(), " ");
			int R = Integer.parseInt(st.nextToken());
			String S = st.nextToken();
			for (int i = 0; i < S.length(); i++) {
				char ch = S.charAt(i);
				for (int j = 0; j < R; j++) {
					sb.append(ch);
				}
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
}

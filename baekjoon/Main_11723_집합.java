package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_11723_집합 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int[] S = new int[21]; // 공집합 생성
		int M = Integer.parseInt(in.readLine());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			if(st.countTokens() == 1) { // all, empty 인 경우
				if(st.nextToken().equals("all")) {
					Arrays.fill(S, 1);
				}else { // empty
					Arrays.fill(S, 0);					
				}
			}else { // add, remove, check, toggle 인 경우
				String input = st.nextToken();
				int num = Integer.parseInt(st.nextToken());
				if(input.equals("add")) {
					S[num] = 1;
				}else if(input.equals("remove")) {
					S[num] = 0;
				}else if(input.equals("check")) {
					if(S[num] == 1) sb.append(1).append("\n");
					else sb.append(0).append("\n");
				}else { // toggle
					S[num] = (S[num]==1) ? 0 : 1;
				}
			}
		}
		out.write(sb.toString());
		out.flush();
		out.close();
	}
}

package algorithm.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_1228_암호문1 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st, subStr;
		StringBuilder sb = new StringBuilder();
		List<Integer> code = new ArrayList<Integer>();
		int N, M, idx, cnt;
		
		for (int tc = 1; tc <= 10; tc++) {
			sb.append("#").append(tc).append(" ");
			N = Integer.parseInt(in.readLine());
			st = new StringTokenizer(in.readLine(), " ");
			for (int i = 0; i < N; i++) {
				code.add(Integer.parseInt(st.nextToken()));
			}
			M = Integer.parseInt(in.readLine());
			st = new StringTokenizer(in.readLine(), "I");
			for (int i = 0; i < M; i++) {
				subStr = new StringTokenizer(st.nextToken(), " ");
				idx = Integer.parseInt(subStr.nextToken());
				cnt = Integer.parseInt(subStr.nextToken());
				for (int j = 0; j < cnt; j++) {
					code.add(idx+j, Integer.parseInt(subStr.nextToken()));
				}
			}
			for (int i = 0; i < 10; i++) {
				sb.append(code.get(i)).append(" ");
			}
			sb.append("\n");
			code.removeAll(code);
		}
		System.out.print(sb);
	}
}

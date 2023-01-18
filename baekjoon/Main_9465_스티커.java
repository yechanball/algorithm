package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_9465_스티커 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine());
		for (int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(in.readLine());
			int[][] score = new int[N+1][2];
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int i = 1; i <= N; i++) {
				score[i][0] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(in.readLine());
			for (int i = 1; i <= N; i++) {
				score[i][1] = Integer.parseInt(st.nextToken());
			}
			
			for (int i = 2; i <= N; i++) {
				score[i][0] += Math.max(score[i-2][1], score[i-1][1]);
				score[i][1] += Math.max(score[i-2][0], score[i-1][0]);
			}
			
			sb.append(Math.max(score[N][0], score[N][1]) + "\n");
		}

		out.write(sb.toString());
		out.flush();
		out.close();
	}
}

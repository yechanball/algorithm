package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_11403_경로찾기 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(in.readLine());
		int[][] edge = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < N; j++) {
				edge[i][j] = Integer.parseInt(st.nextToken());							
			}
		}
		
		// 플로이드-워셜 알고리즘
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(edge[i][j] == 0 && edge[i][k] + edge[k][j] == 2) { // 경유하는 경로가 있는 경우
						edge[i][j] = 1;
					}
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(edge[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		out.write(sb.toString());
		out.flush();
		out.close();
	}
}

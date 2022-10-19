package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_11404_플로이드 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(in.readLine());
		int[][] cost = new int[N+1][N+1];
		for (int i = 0; i <= N; i++) {
			for (int j = 0; j <= N; j++) {
				cost[i][j] = Integer.MAX_VALUE; // 모든 간선 비용 무한대로 초기화
			}
		}
		
		int M = Integer.parseInt(in.readLine());
		int from, to, oneCost;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			oneCost = Integer.parseInt(st.nextToken());
			
			if(cost[from][to] == 0) { // 추가된 경로가 없는 경우
				cost[from][to] = oneCost;				
			}else { // 이미 경로가 있는 경우 -> 최소 경로로 저장
				cost[from][to] = Math.min(oneCost, cost[from][to]);				
			}
		}
		
		// 플로이드-워셜 알고리즘
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if(i == j || i == k || j == k) continue;
					
					if(cost[i][k] == Integer.MAX_VALUE || cost[k][j] == Integer.MAX_VALUE) continue;
					
					if(cost[i][j] > cost[i][k] + cost[k][j]) { // 경유하는 경로 비용이 적으면 비용 갱신
						cost[i][j] = cost[i][k] + cost[k][j];
					}
				}
			}
		}
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				sb.append((cost[i][j] == Integer.MAX_VALUE) ? 0 : cost[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		out.write(sb.toString());
		out.flush();
		out.close();
	}
}

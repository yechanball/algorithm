package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1325_효율적인해킹 {
	static int N, M; // N:정점의 개수, M:간선의 개수
	static List<Integer>[] list; // 노드의 인접 노드 정보를 저장할 배열
	static boolean[] visited; // 방문 배열
	static int[] depth; // 최종 깊이 저장 배열
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		int from, to;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			list[from].add(to);
		}
				
		depth = new int[N+1];
		for (int i = 1; i <= N; i++) {
			visited = new boolean[N+1];
			dfs(i); // DFS
		}
		
		int max = Integer.MIN_VALUE;
		for (int i = 1; i <= N; i++) {
			max = (depth[i] > max) ? depth[i] : max;
		}
		for (int i = 1; i <= N; i++) {
			if(depth[i] == max)
				sb.append(i).append(" ");
		}
		
		out.write(sb.toString());
		out.flush();
		out.close();
	}
	
	public static void dfs(int curr) { // DFS 재귀 메서드
		visited[curr] = true;

		for (int next : list[curr]) { // 인접 노드 탐색
			if(!visited[next]) { // 방문기록이 없다면 
				depth[next]++;
				dfs(next); // 재귀 호출			
			}
		}
	}
}

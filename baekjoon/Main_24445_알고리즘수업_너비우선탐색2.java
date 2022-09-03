package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main_24445_알고리즘수업_너비우선탐색2 {
	static int N, M, R, depth; // N:정점의 개수, M:간선의 개수, R:탐색을 시작할 정점의 번호, depth: 깊이
	static List<Integer>[] list; // 노드의 인접 노드 정보를 저장할 배열
	static int[] visited; // 방문 배열
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N+1];
		visited = new int[N+1];
		int from, to;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			if(list[from] == null) list[from] = new ArrayList<Integer>();
			list[from].add(to);
			if(list[to] == null) list[to] = new ArrayList<Integer>();
			list[to].add(from);
		}
		
		depth = 1;
		bfs(R); // BFS
		
		for (int i = 1; i <= N; i++) {
			sb.append(visited[i]).append("\n");
		}
		
		out.write(sb.toString());
		out.flush();
		out.close();
	}
	
	public static void bfs(int start) { // BFS 재귀 메서드
		Deque<Integer> q = new ArrayDeque<Integer>(); // 큐
		
		int order = 1;
		q.offer(start); // 시작 정점 큐에 삽입
		visited[start] = order; // 시작 정점 방문 처리
		
		while(!q.isEmpty()) { // 큐가 비어있지 않은 경우
			int curr = q.poll(); // 현재 노드
			
			if(list[curr] == null) return;
			
			list[curr].sort(new Comparator<Integer>() { // 인접한 노드 번호가 작은것부터 내림차순으로 정렬
				@Override
				public int compare(Integer n1, Integer n2) {
					return n2 - n1;
				}
			});
			
			for (int next : list[curr]) { // 인접 노드 탐색
				if(visited[next] == 0) { // 방문기록이 없다면 
					q.offer(next);
					visited[next] = ++order;
				}
			}
		}
	}
}

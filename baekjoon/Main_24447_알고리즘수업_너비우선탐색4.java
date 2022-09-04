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

public class Main_24447_알고리즘수업_너비우선탐색4 {
	static int N, M, R; // N:정점의 개수, M:간선의 개수, R:탐색을 시작할 정점의 번호
	static List<Integer>[] list; // 노드의 인접 노드 정보를 저장할 배열
	static long[] depth; // 깊이 배열
	static long[] time; // 방문 시간 배열	
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N+1];
		depth = new long[N+1];
		time = new long[N+1];
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
		
		bfs(R); // BFS
		
		long answer = 0;
		for (int i = 1; i <= N; i++) {
			answer += ((depth[i]-1) * time[i]);
		}
		
		out.write(Long.toString(answer));
		out.flush();
		out.close();
	}
	
	public static void bfs(int start) { // BFS 재귀 메서드
		Deque<Integer> q = new ArrayDeque<Integer>(); // 큐
		
		long nowTime = 1;
		q.offer(start); // 시작 정점 큐에 삽입
		depth[start] = 1; // 시작 정점 방문 처리
		time[start] = nowTime; // 시작 정점 방문 시간
		
		while(!q.isEmpty()) { // 큐가 비어있지 않은 경우
			int curr = q.poll(); // 현재 노드
			
			if(list[curr] == null) continue;

			list[curr].sort(new Comparator<Integer>() { // 인접한 노드 번호가 작은것부터 오름차순으로 정렬
				@Override
				public int compare(Integer n1, Integer n2) {
					return n1 - n2;
				}
			});
			
			for (int next : list[curr]) { // 인접 노드 탐색
				if(depth[next] == 0) { // 방문기록이 없다면 
					q.offer(next);
					depth[next] = depth[curr] + 1;
					time[next] = ++nowTime;
				}
			}
		}
	}
}

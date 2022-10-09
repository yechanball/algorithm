package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_17396_백도어 {
	static int N, M; // N개 정점, M개 간선
	static List<Edge>[] adjList; // 인접 정보
	static boolean[] visited; // 방문 배열(시야가 있는 곳은 방문 처리)
	static long[] minTime; // 0번부터 각 i번까지 가는데 걸리는 시간
	
	static class Edge {
		int to;
		long time;
		
		public Edge(int to, long time) {
			super();
			this.to = to;
			this.time = time;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		adjList = new List[N];
		visited = new boolean[N];
		minTime = new long[N];
		
		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < N; i++) { // 초기화
			adjList[i] = new ArrayList<Edge>();
			if(Integer.parseInt(st.nextToken()) == 1){
				visited[i] = true;				
			}
			minTime[i] = Long.MAX_VALUE;
		}
			
		int a, b, t;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			t = Integer.parseInt(st.nextToken());
			adjList[a].add(new Edge(b, t));
			adjList[b].add(new Edge(a, t));
		}
		
		dijkstra(0); // 최소 시간 찾기
		
		if(minTime[N-1] == Long.MAX_VALUE) // 갈 수 없는 경우
			out.write("-1");
		else // 갈 수 있는 경우
			out.write(Long.toString(minTime[N-1]));			
		out.flush();
		out.close();
	}
	
	public static void dijkstra(int start) {
		PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> Long.compare(a.time, b.time));
		minTime[start] = 0; // 출발지 시간 초기화
		pq.offer(new Edge(start, minTime[start]));
		
		while(!pq.isEmpty()) {
			Edge now = pq.poll();
			
			if(visited[now.to]) continue; 
			visited[now.to] = true;
			
			for (Edge next : adjList[now.to]) { // 인접 탐색
				if(next.to != N-1 && visited[next.to]) continue; // 도착지가 아닌 곳이 이미 방문한 경우
				if(minTime[next.to] > minTime[now.to] + next.time) { // 다음 장소에 갈 수 있는 시간이 현재 위치를 거치는 것이 더 빠른 경우
					minTime[next.to] = minTime[now.to] + next.time; // 최소 시간 갱신
					pq.offer(new Edge(next.to, minTime[next.to]));
				}
			}
		}
	}
}

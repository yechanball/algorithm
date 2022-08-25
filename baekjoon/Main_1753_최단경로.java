package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1753_최단경로 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		
		int V = Integer.parseInt(st.nextToken()); // 정점
		int E = Integer.parseInt(st.nextToken()); // 간선의 수
		int start = Integer.parseInt(in.readLine()); // 시작 정점				
		int[] distance = new int[V+1]; // 시작정점으로부터 각 정점까지 거리
		Arrays.fill(distance, Integer.MAX_VALUE); // 모든 정점까지 거리 무한대(integer max value)로 초기화
		
		List<int[]>[] vertex = new ArrayList[V+1]; // 각 정점별 인접 노드 정보
		int from, to, weight;
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			weight = Integer.parseInt(st.nextToken());
			if(vertex[from] == null) vertex[from] = new ArrayList<int[]>(); // 해당 정점에서 인접 리스트가 없는 경우 리스트 생성
			vertex[from].add(new int[] {to, weight}); 
		}
		
		// 다익스트라(dijkstra)
		PriorityQueue<int[]> pQ = new PriorityQueue<int[]>(new Comparator<int[]>() { // 가중치가 가장 작은 순서 우선순위 큐
			@Override
			public int compare(int[] v1, int[] v2) {
				return v1[1] - v2[1];
			}
		});
		pQ.add(new int[] {start, 0});
		distance[start] = 0; // 시작 정점 거리는 0으로 초기화
		
		while(!pQ.isEmpty()) {
			int[] curr = pQ.poll();
			int currV = curr[0];
			int currW = curr[1];
			
			if(vertex[currV] == null || distance[currV] < currW) // 현재 정점에 인접한 정점이 없거나 현재 정점까지 거리가 현재 가중치보다 작으면 갱신필요 없음
				continue;
			
			for (int[] next : vertex[currV]) { // 현재 정점과 인접한 정점 탐색
				int nextV = next[0];
				int nextW = next[1];
				
				if(currW + nextW < distance[nextV]) { // 현재 정점을 거쳐 가는 것이 더 가중치가 적은 경우 거리 갱신
					distance[nextV] = currW + nextW;
					pQ.offer(new int[] {nextV, distance[nextV]}); // 인접 정점 큐에 삽입
				}
			}	
		}
		
		for (int i = 1; i <= V; i++) {
			sb.append((distance[i] != Integer.MAX_VALUE) ? distance[i] : "INF").append("\n");
		}
		out.write(sb.toString());
		out.flush();
		out.close();
	}
}

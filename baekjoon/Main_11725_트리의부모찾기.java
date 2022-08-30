package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main_11725_트리의부모찾기 {
	static int N; // 노드의 개수
	static List<Integer>[] adjNodes; // 각 노드 별 인접 노드 정보
	static int[] parents; // 각 노드 별 부모 정보
	static boolean[] visited; // 노드 방문 기록
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		N = Integer.parseInt(in.readLine());
		adjNodes = new ArrayList[N+1];
		parents = new int[N+1];
		
		int from, to;
		for (int i = 0; i < N-1; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			if(adjNodes[from] == null) adjNodes[from] = new ArrayList<Integer>(); // 해당 정점에서 인접 리스트가 없는 경우 리스트 생성
			adjNodes[from].add(to); 
			if(adjNodes[to] == null) adjNodes[to] = new ArrayList<Integer>(); // 해당 정점에서 인접 리스트가 없는 경우 리스트 생성
			adjNodes[to].add(from); 
		}
		
		visited = new boolean[N+1];
		bfs(1);
		
		for (int i = 2; i <= N; i++) {
			sb.append(parents[i]).append("\n");
		}
		out.write(sb.toString());
		out.flush();
		out.close();
	}
	
	public static void bfs(int start) {
		Deque<Integer> q = new ArrayDeque<Integer>(); // 큐
		q.offer(start); // 시작 정점 큐에 삽입
		visited[start] = true; // 시작 정점 방문 처리
		
		while(!q.isEmpty()) { // 큐가 비어있지 않은 경우
			int curr = q.poll(); // 현재 노드
			
			if(adjNodes[curr] == null) continue; // 인접 노드 리스트가 없는 경우
			
			for (int node : adjNodes[curr]) { // 인접 노드 탐색
				if(!visited[node]) { // 방문기록이 없다면
					q.offer(node);
					visited[node] = true;
					parents[node] = curr; // 인접 노드의 부모는 현재 노드
				}
			}
		}
	}
}

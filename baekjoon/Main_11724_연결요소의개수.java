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

public class Main_11724_연결요소의개수 {
	static List<Integer>[] nodes; // 노드 배열
	static boolean[] visited; // 방문 배열

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		nodes = new ArrayList[N+1];
		visited = new boolean[N+1];
		for (int i = 1; i <= N; i++) {
			nodes[i] = new ArrayList<Integer>(); // 각 노드에 리스트 생성
		}
		
		int u, v;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			nodes[u].add(v); // u의 인접 노드리스트에 v 추가
			nodes[v].add(u); // v의 인접 노드리스트에 u 추가
		}
		
		int connectCnt = 0;
		for (int i = 1; i <= N; i++) {
			if(!visited[i]) { // 방문하지 않은 노드면 해당 노드를 기준으로 BFS 탐색
				bfs(i);
				connectCnt++;
			}
		}
		
		out.write(Integer.toString(connectCnt));
		out.flush();
		out.close();
	}
	
	public static void bfs(int startNode) {
		Deque<Integer> q = new ArrayDeque<Integer>();
		
		q.offer(startNode);
		visited[startNode] = true;
		
		while(!q.isEmpty()) {
			int curr = q.poll(); // 현재 노드
			
			for (int i = 0, size = nodes[curr].size(); i < size; i++) { // 현재 노드와 인접한 노드 탐색
				int adjNode = nodes[curr].get(i);
				
				if(!visited[adjNode]) {
					q.offer(adjNode);
					visited[adjNode] = true;
				}
			}
		}
	}
}

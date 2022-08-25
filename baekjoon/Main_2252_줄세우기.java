package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2252_줄세우기 {
	static StringBuilder sb = new StringBuilder();
	static int V, E; // 정점, 간선의 수
	static Node[] adjList; // 각 정점별 인접리스트
	static int[] inDegree; // 정점별 진입차수
	
	static class Node {
		int vertex;
		Node next;

		public Node(int vertex, Node next) {
			this.vertex = vertex;
			this.next = next;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		adjList = new Node[V+1];
		inDegree = new int[V+1];

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			adjList[from] = new Node(to, adjList[from]); // 정점 연결 정보 입력
			inDegree[to]++; // 연결되어 있는 정점 진입차수 늘리기
		}
		
		topologySort(); // 위상 정렬 실행
		
		out.write(sb.toString());
		out.flush();
		out.close();
	}
	
	private static void topologySort(){
		Queue<Integer> queue = new ArrayDeque<>();
		
		// 진입차수가 0인 정점 큐에 넣기
		for (int i = 1; i <= V; i++) {
			if(inDegree[i] == 0) queue.offer(i);
		}
		
		while(!queue.isEmpty()) { // 인접 정점 탐색
			int curr = queue.poll();
			sb.append(curr).append(" ");
			
			for (Node temp = adjList[curr]; temp != null; temp = temp.next) {
				if(--inDegree[temp.vertex]==0) queue.offer(temp.vertex); // 인접 정점이 현재 정점을 제외했을때 진입차수가 0이 되면 큐에 넣기
			}
		}
	}
}

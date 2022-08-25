package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14567_선수과목 {
	static int V, E; // 정점, 간선의 수
	static Node[] adjList; // 각 정점별 인접리스트
	static int[] inDegree; // 정점별 진입차수
	static int[] depth; // 정점별 깊이
	
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
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		adjList = new Node[V+1];
		inDegree = new int[V+1];
		depth = new int[V+1];

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			adjList[from] = new Node(to, adjList[from]); // 정점 연결 정보 입력
			inDegree[to]++; // 연결되어 있는 정점 진입차수 늘리기
		}
				
		topologySort(); // 위상 정렬 실행
		
		for (int i = 1; i <= V; i++) { // 결과 출력
			sb.append(depth[i]).append(" ");
		}
		out.write(sb.toString());
		out.flush();
		out.close();
	}
	
	public static void topologySort(){
		Queue<int[]> queue = new ArrayDeque<int[]>(); // [정점번호, 정점깊이]
		
		// 진입차수가 0인 정점 큐에 넣기
		for (int i = 1; i <= V; i++) {
			if(inDegree[i] == 0) {
				queue.offer(new int[] {i, 1});
				depth[i] = 1;
			}
		}
		
		while(!queue.isEmpty()) { // 인접 정점 탐색
			int[] curr = queue.poll();
			depth[curr[0]] = curr[1]; // 깊이 저장
			
			for (Node temp = adjList[curr[0]]; temp != null; temp = temp.next) {
				if(--inDegree[temp.vertex]==0) queue.offer(new int[] {temp.vertex, curr[1]+1}); // 인접 정점이 현재 정점을 제외했을때 진입차수가 0이 되면 깊이는 현재 기준으로 1더하여 큐에 넣기
			}
		}
	}
}

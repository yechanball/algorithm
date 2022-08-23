package algorithm.swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class Solution_7465_창용마을무리의개수 {
	static int N, M; // N: 사람의 수, M: 간선의 개수
	static ArrayList<Integer>[] nodes;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(in.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			nodes = new ArrayList[N+1]; // 인접 노드 정보를 저장할 리스트 배열 생성
			for (int i = 1; i <= N; i++) {
				nodes[i] = new ArrayList<Integer>();
			}
			
			int from, to;
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				from = Integer.parseInt(st.nextToken());
				to = Integer.parseInt(st.nextToken());
				nodes[from].add(to); // from의 인접 노드 to 추가
				nodes[to].add(from); // to의 인접 노드 from 추가
			}
			
			int answer = 0;
			visited = new boolean[N+1];
			for (int i = 1; i <= N; i++) {
				if(!visited[i]) {
					bfs(i);
					answer++;
				}
			}
			sb.append(answer).append("\n");
		}
		out.write(sb.toString());
		out.flush();
		out.close();
	}
	
	public static void bfs(int startNode) {
		Deque<Integer> q = new ArrayDeque<>();
		q.offer(startNode); // 노드 번호
		
		while(!q.isEmpty()) {
			int now = q.poll();
			visited[now] = true;
			
			for (int i = 0, size = nodes[now].size(); i < size; i++) { // 인접 노드 탐색
				int nextNode = nodes[now].get(i);
				if(!visited[nextNode]) {
					q.offer(nextNode);
					visited[nextNode] = true;
				}
			}
		}
	}
}

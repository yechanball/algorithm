package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1260_DFS와BFS {
	static StringBuilder sb = new StringBuilder();
	static int N, M, V; // N:정점의 개수, M:간선의 개수, V:탐색을 시작할 정점의 번호

	static class Node { // 노드 정보를 입력할 클래스
		int to; // 노드 번호
		Node next; // 노드 연결
		
		public Node(int to, Node next) { // 노드 생성자
			this.to = to;
			this.next = next;
		}
	}
	static Node[] list; // 노드의 간선 정보를 저장할 배열
	static boolean[] visited; // BFS에서 사용할 방문 배열
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		list = new Node[N+1];
		visited = new boolean[N+1];
		boolean[] visitedBfs = new boolean[N+1]; // BFS에서 사용할 방문 배열
		int from, to;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			// 간선 정보 배열에 저장
			list[from] = new Node(to, list[from]);
			list[to] = new Node(from, list[to]);			
		}

		dfs(V); // DFS
		sb.append("\n");
		bfs(V, visitedBfs); // BFS
		
		out.write(sb.toString());
		out.flush();
		out.close();
	}
	
	public static void dfs(int nodeNum) { // DFS 재귀 메서드
		visited[nodeNum] = true; // 현재 노드 방문 처리
		sb.append(nodeNum).append(" ");
		
		List<Integer> adjNodes = new ArrayList<Integer>(); // 인접 노드 리스트
		for (Node temp = list[nodeNum]; temp != null; temp = temp.next) { // 인접한 노드 번호 획득
			adjNodes.add(temp.to);
		}
		adjNodes.sort(new Comparator<Integer>() { // 인접한 노드 번호가 작은것부터 오름차순으로 정렬
			@Override
			public int compare(Integer n1, Integer n2) {
				return n1 - n2;
			}
		});
		for (int node : adjNodes) { // 인접 노드 탐색
			if(!visited[node]) // 방문기록이 없다면 
				dfs(node); // 재귀 호출			
		}
	}
	
	public static void bfs(int nodeNum, boolean[] visitedBfs) {
		Deque<Integer> q = new ArrayDeque<Integer>(); // 큐
		q.offer(nodeNum); // 시작 정점 큐에 삽입
		sb.append(nodeNum).append(" ");
		visitedBfs[nodeNum] = true; // 시작 정점 방문 처리
		
		while(!q.isEmpty()) { // 큐가 비어있지 않은 경우
			int curr = q.poll(); // 현재 노드
			
			List<Integer> adjNodes = new ArrayList<Integer>(); // 인접 노드 리스트
			for (Node temp = list[curr]; temp != null; temp = temp.next) { // 인접한 노드 번호 획득
				adjNodes.add(temp.to);
			}
			adjNodes.sort(new Comparator<Integer>() { // 인접한 노드 번호가 작은것부터 오름차순으로 정렬
				@Override
				public int compare(Integer n1, Integer n2) {
					return n1 - n2;
				}
			});
			for (int node : adjNodes) { // 인접 노드 탐색
				if(!visitedBfs[node]) { // 방문기록이 없다면
					q.offer(node);
					sb.append(node).append(" ");
					visitedBfs[node] = true;
				}
			}
		}
	}
}

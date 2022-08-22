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

public class Solution_1238_Contact {
	static int L, start; // L: 주어진 데이터의 길이, start: 시작 지점
	static ArrayList<Integer>[] nodes;
	static boolean[] visited;
	static int maxTime, maxNode;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		for (int tc = 1; tc <= 10; tc++) {
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(in.readLine(), " ");
			L = Integer.parseInt(st.nextToken());
			start = Integer.parseInt(st.nextToken());
			
			nodes = new ArrayList[101]; // 인접 노드 정보를 저장할 리스트 배열 생성
			for (int i = 1; i <= 100; i++) {
				nodes[i] = new ArrayList<Integer>();
			}
			
			int from, to;
			st = new StringTokenizer(in.readLine(), " ");
			for (int i = 0; i < L/2; i++) {
				from = Integer.parseInt(st.nextToken());
				to = Integer.parseInt(st.nextToken());
				nodes[from].add(to); // from의 인접 노드 to 추가
			}
			
			visited = new boolean[101];
			maxTime = Integer.MIN_VALUE; // 초기화
			maxNode = Integer.MIN_VALUE;
			
			bfs(start);
			sb.append(maxNode).append("\n");
		}
		out.write(sb.toString());
		out.flush();
		out.close();
	}
	
	public static void bfs(int startNode) {
		Deque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {startNode, 0}); // 0: 노드 번호, 1: 소요 시간
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			visited[now[0]] = true;
			
			for (int i = 0, size = nodes[now[0]].size(); i < size; i++) { // 인접 노드 탐색
				int nextNode = nodes[now[0]].get(i);
				if(!visited[nextNode]) {
					q.offer(new int[] {nextNode, now[1]+1});
					visited[nextNode] = true;
				}
			}
			
			if(now[1] > maxTime) { // 현재 노드가 최대 시간 걸린 노드라면 갱신 
				maxTime = now[1];
				maxNode = now[0];
			}else if(now[1] == maxTime) { // 현재 노드가 최대 시간 걸린 노드와 동일한 경우 노드 번호가 큰 것으로 갱신
				maxNode = (now[0] > maxNode) ? now[0] : maxNode;
			}
		}
	}
}

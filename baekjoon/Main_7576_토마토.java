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

public class Main_7576_토마토 {
	static int N, M; // N: 행, M: 열
	static int[][] storage; // 토마토 보관 창고
	static List<int[]> tomato; // 초기에 주어진 익은 토마토 정보를 저장할 리스트
	static int[][] visited; // 토마토 방문 기록 -> -1: 방문할 수 없는 곳, 0: 방문하지 않은 곳, 1 ~ 숫자: 방문하는데 걸린 시간
	static int minTime;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		storage = new int[N][M]; // 토마토 창고 정보 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < M; j++) {
				storage[i][j] = Integer.parseInt(st.nextToken());
				if(storage[i][j] == 1) {
					tomato.add(new int[] {i,j}); // 시작으로 익은 토마토가 주어진 경우
				}
			}
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

		out.write();
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

package algorithm.swea;

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

public class Solution_5643_키순서 {
	static int N; // 학생 수
	static List<Integer>[] adjList; // 인접 학생 정보
	static int[] enterCnt; // 진입 차수
	static int[] outerCnt; // 나가는 차수
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int result = 0;
			N = Integer.parseInt(in.readLine());
			int M = Integer.parseInt(in.readLine());
			
			adjList = new List[N+1];
			for (int i = 1; i <= N; i++) {
				adjList[i] = new ArrayList<Integer>();
			}
			
			int a, b;
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				adjList[a].add(b);
			}
			
			enterCnt = new int[N+1];
			outerCnt = new int[N+1];
			for (int i = 1; i <= N; i++) {
				bfs(i);
			}
			
			for (int i = 1; i <= N; i++) {
				// 진입 차수와 나가는 차수, 자기 자신을 포함한 것이 모든 정점의 개수면 정확한 순서 파악 가능한 정점
				if(enterCnt[i] + outerCnt[i] + 1 == N) {
					result++;
				}
			}
			
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		out.write(sb.toString());
		out.flush();
		out.close();
	}

	private static void bfs(int start) { // 너비 우선 탐색으로 각 노드별 진입 차수와 나가는 차수 카운트
		boolean[] visited = new boolean[N+1];
		Deque<Integer> q = new ArrayDeque<Integer>();
		q.offer(start);
		visited[start] = true;
		
		while(!q.isEmpty()) {
			int now = q.poll();
			
			for(int next : adjList[now]) {
				if(!visited[next]) {
					q.offer(next);
					visited[next] = true;
					enterCnt[next]++;
					outerCnt[start]++;
				}
			}
		}
	}
}

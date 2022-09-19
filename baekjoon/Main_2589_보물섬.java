package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_2589_보물섬 {
	static int M, N; // 행, 열의 크기
	static int minDistMaxTime = Integer.MIN_VALUE; // 최단 거리 최대 이동시간
	static char[][] map; // 주어진 지도
	static int[][] visited; // 방문확인 배열
	static int[] dr = {-1, 1, 0, 0}; // 상, 하, 좌, 우
	static int[] dc = {0, 0, -1, 1}; // 상, 하, 좌, 우	
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new char[M][N];
		for (int i = 0; i < M; i++) {
			String input = in.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = input.charAt(j);
			}
		}
		
		for (int i = 0; i < M; i++) { // 모든 시작할 수 있는 위치로부터 너비우선탐색
			for (int j = 0; j < N; j++) {
				if(map[i][j] == 'L') {
					visited = new int[M][N];
					bfs(i, j);
				}				
			}
		}

		out.write(Integer.toString(--minDistMaxTime));
		out.flush();
		out.close();
	}
	
	public static void bfs(int r, int c) { // BFS
		Deque<int[]> q = new ArrayDeque<int[]>();
		q.offer(new int[] {r, c});
		visited[r][c] = 1;
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			
			for (int i = 0; i < 4; i++) { // 인접 칸 탐색
				int nr = curr[0] + dr[i];
				int nc = curr[1] + dc[i];
				
				if(nr < 0 || nr >= M || nc < 0 || nc >= N || map[nr][nc] == 'W' || visited[nr][nc] != 0) // 지도를 벗어나거나 이동할 수 없는 경우
					continue;
				
				q.offer(new int[] {nr, nc});
				visited[nr][nc] = visited[curr[0]][curr[1]] + 1;
				
				minDistMaxTime = (visited[nr][nc] > minDistMaxTime) ? visited[nr][nc] : minDistMaxTime; // 최단거리 최대시간 갱신
			}
		}
	}
}

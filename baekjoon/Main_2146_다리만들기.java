package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_2146_다리만들기 {
	static int N; // 세로, 가로 크기
	static int landCnt = 0; // 섬 개수
	static int minDist = Integer.MAX_VALUE; // 최소 거리
	static int[][] map; // 지도
	static boolean[][] visited;
	static int[] dr = new int[] {-1, 1, 0, 0};
	static int[] dc = new int[] {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(in.readLine());
		
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!visited[i][j] && map[i][j] == 1) {
					landCnt++;
					bfs(i, j); // 같은 섬 영역끼리 체크
				}
			}
		}
		
		for (int i = 0; i < N; i++) { // 두 섬 사이 최소 거리 찾기
			for (int j = 0; j < N; j++) {
				if(map[i][j] == 0) continue; // 섬이 아닌 경우 생략
				
				visited = new boolean[N][N];
				findDist(i, j);
			}
		}

		out.write(Integer.toString(minDist));
		out.flush();
		out.close();
	}
	
	private static void bfs(int row, int col) {
		Deque<Integer> q = new ArrayDeque<Integer>();
		q.offer(row);
		q.offer(col);
		map[row][col] = landCnt;
		visited[row][col] = true;
		
		while (!q.isEmpty()) {
			int r = q.poll();
			int c = q.poll();

			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc] || map[nr][nc] == 0) {
					continue;
				}
				
				q.offer(nr);
				q.offer(nc);
				map[nr][nc] = landCnt;
				visited[nr][nc] = true;
			}
		}
	}
	
	private static void findDist(int row, int col) {
		Deque<int[]> q = new ArrayDeque<int[]>();
		q.offer(new int[] {row, col, 0});
		visited[row][col] = true;;
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			
			for (int d = 0; d < 4; d++) { // 연결할 수 있는 섬 탐색
				int nr = curr[0] + dr[d];
				int nc = curr[1] + dc[d];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc] || map[nr][nc] == map[row][col]) // 범위를 벗어나거나 같은 섬인 경우
					continue;
				
				if(map[nr][nc] == 0) { // 바다인 경우는 다음 칸 탐색
					q.offer(new int[] {nr, nc, curr[2]+1});
					visited[nr][nc] = true;
					continue;
				}
				
				minDist = Math.min(curr[2], minDist); // 다른 섬을 만난 경우 최소 거리 갱신				
			}					
		}
	}
}

package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_14940_쉬운최단거리 {
	static int N, M;
	static int[][] map;
	static int[][] visited;
	static int[] dr = new int[] {-1, 1, 0, 0};
	static int[] dc = new int[] {0, 0, -1, 1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int startRow = 0, startCol = 0;
		
		map = new int[N][M];
		visited = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

				if(map[i][j] == 2) {
					startRow = i;
					startCol = j;
				}
			}
		}

		bfs(startRow, startCol);
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(visited[i][j] == 0) {
					if(map[i][j] == 1) {
						visited[i][j] = -1;
					}
				}else {
					visited[i][j]--;					
				}
				sb.append(visited[i][j]).append(" ");
			}
			sb.append("\n");
		}

		out.write(sb.toString());
		out.flush();
		out.close();
	}
	
	public static void bfs(int row, int col) {
		Deque<int[]> q = new ArrayDeque<int[]>();
		q.offer(new int[] {row, col});
		visited[row][col] = 1;
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int r = curr[0], c = curr[1];

			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc] != 0 || map[nr][nc] == 0) {
					continue;
				}
				
				q.offer(new int[] {nr, nc});
				visited[nr][nc] = visited[r][c] + 1;
			}
		}
	}
}
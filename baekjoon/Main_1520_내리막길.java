package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_1520_내리막길 {
	static int M, N; // 행, 열의 크기
	static int[][] map; // 주어진 지도
	static int[][] visited; // 방문확인 배열
	static int[] dr = {0, 1, 0, -1}; // 우, 하, 좌, 상
	static int[] dc = {1, 0, -1, 0}; // 우, 하, 좌, 상	
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new int[M][N];
		visited = new int[M][N];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				visited[i][j] = -1;
			}
		}

		out.write(Integer.toString(dfs(0, 0)));
		out.flush();
		out.close();
	}
	
	public static int dfs(int r, int c) {
		if(r == M-1 && c == N-1)  // 도착지에 도착한 경우
			return 1;
		
		if(visited[r][c] == -1) { // 방문한적이 없다면
			visited[r][c] = 0; // 방문처리
			for (int i = 0; i < 4; i++) { // 인접 칸 탐색
				int nr = r + dr[i];
				int nc = c + dc[i];
				
				if(nr < 0 || nr >= M || nc < 0 || nc >= N) // 지도를 벗어나는 경우
					continue;
				
				if(map[nr][nc] < map[r][c]) // 인접 칸이 현재 위치보다 낮은 곳인 경우
					visited[r][c] += dfs(nr, nc); // 재귀 호출			
			}		
		}
		
		return visited[r][c];
	}
}

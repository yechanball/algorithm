package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14500_테트로미노 {
	static int N, M, max = 0;
	static int[][] paper;
	static boolean[][] visited;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int[][] tr = {{-1,-1,-1},{1,1,1},{-1,0,1},{-1,0,1}};
	static int[][] tc = {{-1,0,1},{-1,0,1},{-1,-1,-1},{1,1,1}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		paper = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				visited[i][j] = true;
				dfs(i, j, 1, paper[i][j]);
				visited[i][j] = false;
				checkT(i, j);
			}
		}
		
		System.out.print(max);
	}

	public static void dfs(int row, int col, int cnt, int sum) {
		if(cnt == 4) {
			max = Math.max(max, sum);
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			int nr = row + dr[i];
			int nc = col + dc[i];
			
			if(nr < 0 || nr >= N || nc < 0 || nc >= M)
				continue;
			
			if(!visited[nr][nc]) {
				visited[nr][nc] = true;
				dfs(nr, nc, cnt+1, sum + paper[nr][nc]);
				visited[nr][nc] = false;
			}
		}
	}
	
	public static void checkT(int row, int col) {
		for (int i = 0; i < 4; i++) {
			boolean isPoss = true;
			int sum = paper[row][col];
			
			for (int j = 0; j < 3; j++) {
				int nr = row + tr[i][j];
				int nc = col + tc[i][j];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= M) {
					isPoss = false;
					break;
				}
				
				sum += paper[nr][nc];				
			}
			
			if(isPoss) max = Math.max(max, sum);
		}
	}
}

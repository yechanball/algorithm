package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_21736_헌내기는친구가필요해 {
	static class Pos {
		int x, y;

		public Pos(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Pos start = null;
		
		int[][] campus = new int[N][M];
		for (int i = 0; i < N; i++) {
			String input = in.readLine();
			for (int j = 0; j < M; j++) {
				if(input.charAt(j) == 'O') continue;
				else if(input.charAt(j) == 'X') campus[i][j] = -1;
				else if(input.charAt(j) == 'P') campus[i][j] = 1;
				else start = new Pos(i, j);
			}
		}
		
		int cnt = bfs(campus, N, M, start);
		System.out.print(cnt == 0 ? "TT" : cnt);
	}

	public static int bfs(int[][] campus, int N, int M, Pos start) {
		Queue<Pos> que = new ArrayDeque<>();
		que.offer(start);
		
		boolean[][] visited = new boolean[N][M];
		visited[start.x][start.y] = true;
		
		int[] dx = {-1,1,0,0};
		int[] dy = {0,0,-1,1};
		
		int cnt = 0;
		while(!que.isEmpty()) {
			Pos curr = que.poll();
			
			for (int d = 0; d < 4; d++) {
				int nx = curr.x + dx[d];
				int ny = curr.y + dy[d];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny] || campus[nx][ny] == -1) continue;
				
				if(campus[nx][ny] == 1) cnt++;

				que.offer(new Pos(nx, ny));
				visited[nx][ny] = true;
			}
		}
		
		return cnt;
	}
}

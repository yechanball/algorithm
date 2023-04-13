package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2206_벽부수고이동하기 {
	static class Pos {
		int r, c, len;
		boolean isBreak;

		public Pos(int r, int c, int len, boolean isBreak){
			this.r = r;
			this.c = c;
			this.len = len;
			this.isBreak = isBreak;
		}
	}

	static int N, M;
	static boolean[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new boolean[N+1][M+1];
		for (int i = 1; i <= N; i++){
			String str = in.readLine();
			for (int j = 0; j < M; j++){
				if(str.charAt(j) == '1') map[i][j+1] = true;
			}
		}

		int ans = bfs(new Pos(1, 1, 1, false));

		System.out.print(ans);
	}

	public static int bfs(Pos start){
		boolean[][][] visited = new boolean[N+1][M+1][2];
		int[] dr = {1,0,-1,0};
		int[] dc = {0,1,0,-1};

		Queue<Pos> que = new ArrayDeque<>();
		que.add(start);

		while(!que.isEmpty()){
			Pos curr = que.poll();

			if(curr.r == N && curr.c == M) return curr.len;

			for (int i = 0; i < 4; i++){
				int nr = curr.r + dr[i];
				int nc = curr.c + dc[i];

				if(nr <= 0 || nr > N || nc <= 0 || nc > M) continue;

				if(curr.isBreak){
					if(map[nr][nc] || visited[nr][nc][1]) continue;

					que.add(new Pos(nr, nc, curr.len + 1, true));
					visited[nr][nc][1] = true;
				}else{
					if(map[nr][nc]){
						if(visited[nr][nc][1]) continue;

						que.add(new Pos(nr, nc, curr.len + 1, true));
						visited[nr][nc][1] = true;
					}else{
						if(visited[nr][nc][0]) continue;

						que.add(new Pos(nr, nc, curr.len + 1, false));
						visited[nr][nc][0] = true;
					}
				}
			}
		}

		return -1;
	}
}

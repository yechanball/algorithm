package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_13460_구슬탈출2 {
	static class Ball {
		int r, c;

		public Ball(int r, int c){
			this.r = r;
			this.c = c;
		}

		public boolean equals(Ball otherBall){
			if(this.r == otherBall.r && this.c == otherBall.c) return true;
			return false;
		}
	}
	static class Pos {
		Ball red;
		Ball blue;
		int time;

		public Pos(Ball red, Ball blue, int time) {
			this.red = red;
			this.blue = blue;
			this.time = time;
		}
	}

	static int N, M;
	static int[][] board;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static boolean redOut = false, blueOut = false;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[N][M];

		Ball redBall = null, blueBall = null;
		for (int i = 0; i < N; i++){
			String input = in.readLine();
			for (int j = 0; j < M; j++) {
				if(input.charAt(j) == '.') board[i][j] = 0;
				else if(input.charAt(j) == '#') board[i][j] = -1;
				else if(input.charAt(j) == 'O') board[i][j] = 1;
				else {
					board[i][j] = 0;
					if(input.charAt(j) == 'R') redBall = new Ball(i, j);
					else blueBall = new Ball(i, j);
				}
			}
		}

		int minTime = bfs(redBall, blueBall);
		System.out.print(minTime);
	}

	public static int bfs(Ball redBall, Ball blueBall) {
		Queue<Pos> que = new ArrayDeque<>();
		que.offer(new Pos(redBall, blueBall, 0));

		boolean[][][][] visited = new boolean[N][M][N][M];
		visited[redBall.r][redBall.c][blueBall.r][blueBall.c] = true;

		while(!que.isEmpty()){
			Pos curr = que.poll();
			if(curr.time >= 10) break;

			for(int d = 0; d < 4; d++){
				redOut = false;
				blueOut = false;

				Ball nextRed =  moveBall(curr.red, d, true);
				Ball nextBlue = moveBall(curr.blue, d, false);

				if(blueOut) continue;
				else if(redOut) return curr.time + 1;

				if(nextRed.equals(nextBlue)){
					switch (d){
						case 0:
							if(curr.red.r < curr.blue.r) nextBlue.r++;
							else nextRed.r++;
							break;
						case 1:
							if(curr.red.r < curr.blue.r) nextRed.r--;
							else nextBlue.r--;
							break;
						case 2:
							if(curr.red.c < curr.blue.c) nextBlue.c++;
							else nextRed.c++;
							break;
						case 3:
							if(curr.red.c < curr.blue.c) nextRed.c--;
							else nextBlue.c--;
							break;
					}
				}

				if(visited[nextRed.r][nextRed.c][nextBlue.r][nextBlue.c]) continue;

				visited[nextRed.r][nextRed.c][nextBlue.r][nextBlue.c] = true;
				que.offer(new Pos(nextRed, nextBlue, curr.time + 1));
			}
		}

		return -1;
	}

	public static Ball moveBall(Ball curr, int d, boolean isRed){
		Ball result = new Ball(curr.r, curr.c);

		while(board[result.r + dr[d]][result.c + dc[d]] != -1){
			result.r += dr[d];
			result.c += dc[d];

			if(board[result.r][result.c] == 1){
				if(isRed) redOut = true;
				else blueOut = true;
				break;
			}
		}
		return result;
	}
}

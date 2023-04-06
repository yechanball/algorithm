package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_1261_알고스팟 {
	static class Room{
		int r, c, cnt;

		public Room(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}
	
	static int N, M;
	static int[][] maze;
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		maze = new int[N+1][M+1];
		for (int i = 1; i <= N; i++) {
			String str = in.readLine();
			for (int j = 1; j <= M; j++) {
				maze[i][j] = str.charAt(j-1) - '0';
			}
		}
		
		visited = new boolean[N+1][M+1];
		int minCnt = dijkstra(new Room(1, 1, 0));
		
		System.out.print(minCnt);
	}

	public static int dijkstra(Room start) {
		int[] dr = {0,1,0,-1}; // 우하좌상
		int[] dc = {1,0,-1,0};
		
		Deque<Room> que = new ArrayDeque<>();
		que.add(start);
		visited[start.r][start.c] = true;
		
		while(!que.isEmpty()) {
			Room curr = que.poll();
			
			if(curr.r == N && curr.c == M) return curr.cnt;
			
			for (int i = 0; i < 4; i++) {
				int nr = curr.r + dr[i];
				int nc = curr.c + dc[i];

				if(nr < 1 || nr > N || nc < 1 || nc > M || visited[nr][nc]) continue;
				
				if(maze[nr][nc] == 0) que.addFirst(new Room(nr, nc, curr.cnt));
				else que.addLast(new Room(nr, nc, curr.cnt+1));
				
				visited[nr][nc] = true;
			}
		}
		
		return 0;
	}
}

package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1261_알고스팟 {
	static class Room implements Comparable<Room>{
		int r, c, cnt;

		public Room(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Room r) {
			return cnt - r.cnt;
		}	
	}
	
	static int N, M;
	static int[][] maze, cnt;
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		maze = new int[N+1][M+1];
		cnt = new int[N+1][M+1];
		for (int i = 1; i <= N; i++) {
			String str = in.readLine();
			for (int j = 1; j <= M; j++) {
				maze[i][j] = str.charAt(j-1) - '0';
				cnt[i][j] = Integer.MAX_VALUE;
			}
		}
		
		visited = new boolean[N+1][M+1];
		dijkstra(new Room(1, 1, 0));
		
		System.out.print(cnt[N][M]);
	}

	public static void dijkstra(Room start) {
		int[] dr = {0,1,0,-1}; // 우하좌상
		int[] dc = {1,0,-1,0};
		
		PriorityQueue<Room> pq = new PriorityQueue<>();
		pq.add(start);
		cnt[start.r][start.c] = 0;
		visited[start.r][start.c] = true;
		
		while(!pq.isEmpty()) {
			Room curr = pq.poll();
			
			if(curr.r == N && curr.c == M) return;
			
			for (int i = 0; i < 4; i++) {
				int nr = curr.r + dr[i];
				int nc = curr.c + dc[i];

				if(nr < 1 || nr > N || nc < 1 || nc > M || visited[nr][nc]) continue;
				
				int nextCnt = curr.cnt + maze[nr][nc];
				
				if(nextCnt < cnt[nr][nc]) {
					pq.add(new Room(nr, nc, nextCnt));
					cnt[nr][nc] = nextCnt;
					visited[nr][nc] = true;					
				}
			}
		}
	}
}

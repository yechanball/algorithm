package algorithm.swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Solution_4193_수영대회결승전 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(in.readLine());
			int[][] map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
						
			st = new StringTokenizer(in.readLine(), " ");
			int startR = Integer.parseInt(st.nextToken());
			int startC = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(in.readLine(), " ");
			int endR = Integer.parseInt(st.nextToken());
			int endC = Integer.parseInt(st.nextToken());
						
			int[][] visited = new int[N][N];
			for (int i = 0; i < N; i++) {
				Arrays.fill(visited[i], -1);
			}
			
			Deque<Integer> q = new ArrayDeque<Integer>();
			q.offer(startR);
			q.offer(startC);
			visited[startR][startC] = 0;
			
			while(!q.isEmpty()) {
				int row = q.poll();
				int col = q.poll();
				int time = visited[row][col];
	
				for (int i = 0; i < 4; i++) {
					int nr = row + dr[i];
					int nc = col + dc[i];
					
					if(nr < 0 || nr >= N || nc < 0 || nc >= N || map[nr][nc] == 1) continue;

					if(map[nr][nc] == 0 && (visited[nr][nc] == -1 || visited[nr][nc] > time+1)) {
						q.offer(nr);
						q.offer(nc);
						visited[nr][nc] = time + 1;
					}
					
					if(map[nr][nc] == 2) {
						if(time % 3 == 0 && (visited[nr][nc] == -1 || visited[nr][nc] > time+1)) {
							q.offer(nr);
							q.offer(nc);
							visited[nr][nc] = time + 3;
						}else if(time % 3 == 1 && (visited[nr][nc] == -1 || visited[nr][nc] > time+2)) {
							q.offer(nr);
							q.offer(nc);
							visited[nr][nc] = time + 2;
						}else if(time % 3 == 2 && (visited[nr][nc] == -1 || visited[nr][nc] > time+2)) {
							q.offer(nr);
							q.offer(nc);
							visited[nr][nc] = time + 1;
						}
					}
				}
			}
			
			sb.append("#").append(tc).append(" ").append(visited[endR][endC]).append("\n");
		}
		
		out.write(sb.toString());
		out.flush();
		out.close();
	}
}

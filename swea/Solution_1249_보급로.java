package algorithm.swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class Solution_1249_보급로 {
	static int N, minTime = Integer.MAX_VALUE;
	static int[][] map;
	static int[][] visited;
	static int[] dr = new int[] {-1, 1, 0, 0};
	static int[] dc = new int[] {0, 0, -1, 1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(in.readLine());
			map = new int[N][N];
			visited = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				String input = in.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = input.charAt(j) - '0';
				}
			}
			
			minTime = Integer.MAX_VALUE;
			bfs(0, 0, 0);
			sb.append("#").append(tc).append(" ").append(minTime).append("\n");
		}
		out.write(sb.toString());
		out.flush();
		out.close();
	}
	
	public static void bfs(int row, int col, int t) {
		Deque<int[]> q = new ArrayDeque<int[]>();
		q.offer(new int[] {row, col, t});
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int r = curr[0], c = curr[1], time = curr[2], nr, nc;
			
			if(r == N-1 && c == N-1) { // 도착한 경우 최소시간 확인
				minTime = (time < minTime) ? time : minTime;
				continue;
			}
			
			if(visited[r][c] != 0) {
				visited[r][c] = (time < visited[r][c]) ? time : visited[r][c];
			}else {
				visited[r][c] = time;				
			}
			
			if(time > minTime) { // 현재 누적 시간이 최소시간보다 긴 경우 종료
				continue;
			}
			
			for (int i = 0; i < 4; i++) { // 인접 탐색
				nr = r + dr[i];
				nc = c + dc[i];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= N) {
					continue;
				}
				q.offer(new int[] {nr, nc, time+map[nr][nc]});
			}
		}
	}
}

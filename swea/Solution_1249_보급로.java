package algorithm.swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class Solution_1249_보급로 {
	static int N;
	static int[][] map;
	static int[][] time;
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
			time = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				String input = in.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = input.charAt(j) - '0';
					time[i][j] = Integer.MAX_VALUE;
				}
			}

			bfs(0, 0); // 너비 우선 탐색
			
			sb.append("#").append(tc).append(" ").append(time[N-1][N-1]).append("\n");
		}
		out.write(sb.toString());
		out.flush();
		out.close();
	}
	
	public static void bfs(int row, int col) {
		Deque<int[]> q = new ArrayDeque<int[]>();
		q.offer(new int[] {row, col});
		time[row][col] = 0; // 출발지 시간 초기화
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int r = curr[0], c = curr[1], nr, nc;
			
			for (int i = 0; i < 4; i++) { // 인접 탐색
				nr = r + dr[i];
				nc = c + dc[i];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= N) { // 지도를 벗어나는 경우
					continue;
				}
				
				if(time[nr][nc] > time[r][c] + map[nr][nc]) { // 다음 장소에 갈 수 있는 시간이 현재 위치를 거치는 것이 더 빠른 경우
					time[nr][nc] = time[r][c] + map[nr][nc]; // 최소 시간 갱신
					q.offer(new int[] {nr, nc});
				}
			}
		}
	}
}

package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_1600_말이되고픈원숭이 {
	static int K, W, H, minAns = Integer.MAX_VALUE;
	static int[][] map;
	static boolean[][][] visited;
	static int[] hDr = new int[] {-2, -2, -1, -1, 1, 1, 2, 2};
	static int[] hDc = new int[] {-1, 1, -2, 2, -2, 2, -1, 1};
	static int[] dr = new int[] {-1, 1, 0, 0};
	static int[] dc = new int[] {0, 0, -1, 1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		K = Integer.parseInt(in.readLine());
		st = new StringTokenizer(in.readLine(), " ");
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		map = new int[H][W];
		visited = new boolean[H][W][K+1];
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		bfs(0, 0);
		
		out.write((minAns == Integer.MAX_VALUE) ? "-1" : Integer.toString(minAns));
		out.flush();
		out.close();
	}
	
	public static void bfs(int r, int c) {
		Deque<int[]> q = new ArrayDeque<int[]>();
		q.offer(new int[] {r, c, K, 0});
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int cr = curr[0], cc = curr[1], ck = curr[2], cn = curr[3], nr, nc;
			
			if(cr == H-1 && cc == W-1) { // 도착한 경우 최소 동작수 체크
				minAns = (cn < minAns) ? cn : minAns;
				continue;
			}
			
			if(visited[cr][cc][ck]) {
				continue;
			}
			visited[cr][cc][ck] = true;
			
			for (int i = 0; i < 4; i++) { // 인접 탐색
				nr = cr + dr[i];
				nc = cc + dc[i];
				
				if(nr < 0 || nr >= H || nc < 0 || nc >= W) {
					continue;
				}
				
				if(map[nr][nc] == 1) {
					continue;
				}
				
				q.offer(new int[] {nr, nc, ck, cn + 1});
			}			
			
			if(ck != 0) { // 나이트 점프를 할 수 있는 경우
				for (int i = 0; i < 8; i++) {
					nr = cr + hDr[i];
					nc = cc + hDc[i];
					
					if(nr < 0 || nr >= H || nc < 0 || nc >= W) {
						continue;
					}
					
					if(map[nr][nc] == 1) {
						continue;
					}
					
					q.offer(new int[] {nr, nc, ck-1, cn + 1});
				}
			}
		}
	}
}

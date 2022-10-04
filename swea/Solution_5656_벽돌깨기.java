package algorithm.swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Solution_5656_벽돌깨기 {
	static int N, W, H;
	static int minRemain;
	static int[] dr = new int[] {-1, 1, 0, 0};
	static int[] dc = new int[] {0, 0, -1, 1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(in.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			
			int[][] map = new int[H][W];
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			minRemain = Integer.MAX_VALUE;
			perm(map, 0);
			
			sb.append(minRemain).append("\n");
		}
		
		out.write(sb.toString());
		out.flush();
		out.close();
	}

	private static void perm(int[][] map, int cnt) {
		if(cnt == N) {
			int nowRemain = 0;
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if(map[i][j] != 0) {
						nowRemain++;
					}
				}
			}
			minRemain = (nowRemain < minRemain) ? nowRemain : minRemain;
			return;
		}
		
		for (int i = 0; i < W; i++) {
			int[][] newMap = destroy(map, i);
			
			for (int j = 0; j < W; j++) {
				Deque<Integer> q = new ArrayDeque<Integer>();
				
				for (int k = H-1; k >= 0; k--) {
					if(newMap[k][j] > 0) {
						q.offer(newMap[k][j]);
						newMap[k][j] = 0;
					}
				}
				
				int target = H-1;
				while(!q.isEmpty()) {
					newMap[target][j] = q.poll();
					target--;
				}
			}
			perm(newMap, cnt+1);
		}
	}

	private static int[][] destroy(int[][] map, int pos) {
		int row = 0, col = 0, cnt = 0;
		
		for (int i = 0; i < H; i++) {
			if(map[i][pos] != 0) {
				cnt = map[i][pos];
				row = i;
				col = pos;
				break;
			}
		}
		
		if(cnt == 0) {
			return map;			
		} else {
			int[][] newMap = new int[H][W];
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					newMap[i][j] = map[i][j];					
				}
			}
			
			Deque<int[]> q = new ArrayDeque<int[]>();
			if(cnt > 1) {
				q.offer(new int[] {row, col, cnt});				
			}
			newMap[row][col] = 0;
			
			while(!q.isEmpty()) {
				int[] curr = q.poll();
		
				for (int i = 0; i < 4; i++) { 
					int nr = curr[0];
					int nc = curr[1];
					for (int j = 1; j < curr[2]; j++) {
						nr += dr[i];
						nc += dc[i];
						
						if(nr >= 0 && nr < H && nc >= 0 && nc < W && newMap[nr][nc] != 0) {
							if(newMap[nr][nc] > 1) {
								q.offer(new int[] {nr, nc, newMap[nr][nc]});															
							}
							newMap[nr][nc] = 0;
						}
					}
				}
			}			
			
			return newMap;
		}
	}
}

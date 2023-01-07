package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_4963_섬의개수 {
	static int[][] map;
	static int w, h;
	static boolean[][] visited;
	static int[] dr = {-1,-1,0,1,1,1,0,-1};
	static int[] dc = {0,1,1,1,0,-1,-1,-1};	
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			if(w == 0) break;
			
			map = new int[h][w];
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			sb.append(countIsland() + "\n");
		}
		
		out.write(sb.toString());
		out.flush();
		out.close();
	}

	private static int countIsland() {
		visited = new boolean[h][w];
		int cnt = 0;
		
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				if(map[i][j] == 1 && !visited[i][j]) {
					bfs(i, j);
					cnt++;
				}
			}
		}
		
		return cnt;
	}

	private static void bfs(int sRow, int sCol) {
		Queue<Integer> que = new ArrayDeque<Integer>();
		que.offer(sRow);
		que.offer(sCol);
		visited[sRow][sCol] = true;
		
		while(!que.isEmpty()) {
			int row = que.poll();
			int col = que.poll();
			
			for (int i = 0; i < 8; i++) {
				int nr = row + dr[i];
				int nc = col + dc[i];
				
				if(nr < 0 || nr >= h || nc < 0 || nc >= w || visited[nr][nc] || map[nr][nc] == 0) {
					continue;
				}
				
				que.offer(nr);
				que.offer(nc);
				visited[nr][nc] = true;
			}
		}
	}
}

package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main_14502_연구소 {
	static int N, M, totalBlock;
	static int maxSafe, tmpSafe;
	static int[][] map, newMap;
	static int[] permArr;
	static boolean[] permCheck;
	static List<int[]> virus = new ArrayList<int[]>();
	static int[] dr = new int[] {-1, 1, 0, 0};
	static int[] dc = new int[] {0, 0, -1, 1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		totalBlock = N * M;
		map = new int[N][M];
		newMap = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) {
					virus.add(new int[] {i, j});
				}
			}
		}
		
		permArr = new int[3];
		permCheck = new boolean[totalBlock];
		maxSafe = Integer.MIN_VALUE;
		perm(0);
		
		out.write(Integer.toString(maxSafe));
		out.flush();
		out.close();
	}
	
	private static void perm(int cnt) {
		if(cnt == 3) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					newMap[i][j] = map[i][j];
				}
			}
			
			for (int i = 0; i < 3; i++) {
				int row = permArr[i] / M;
				int col = permArr[i] % M;
				
				newMap[row][col] = 1;
			}
			
			tmpSafe = 0;
			bfs();	
			maxSafe = (tmpSafe > maxSafe) ? tmpSafe : maxSafe;
			
			return;
		}
		
		for (int i = 0; i < totalBlock; i++) {
			if(!permCheck[i] && map[i/M][i%M] == 0) {
				permCheck[i] = true;
				permArr[cnt] = i;
				perm(cnt+1);
				permCheck[i] = false;
			}
		}
	}
	
	private static void bfs() {
		boolean[][] visited = new boolean[N][M];
		
		Deque<int[]> q = new ArrayDeque<int[]>();
		for(int[] pos : virus) {
			q.offer(pos);
			visited[pos[0]][pos[1]] = true;
		}
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
	
			for (int i = 0; i < 4; i++) { 
				int nr = curr[0] + dr[i];
				int nc = curr[1] + dc[i];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc] || newMap[nr][nc] != 0) {
					continue;
				}
				
				q.offer(new int[] {nr, nc});
				visited[nr][nc] = true;
				newMap[nr][nc] = 2;
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(newMap[i][j] == 0) {
					tmpSafe++;
				}
			}
		}
	}
}
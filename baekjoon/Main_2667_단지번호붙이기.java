package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class Main_2667_단지번호붙이기 {
	static int N; // 공간의 크기
	static int[][] map; // 공간
	static boolean[][] visited; // 방문 체크
	static int cnt = 0, cntDetail = 0;;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		N = Integer.parseInt(in.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			String input = in.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = input.charAt(j) - '0';
			}
		}
		
		List<Integer> result = new ArrayList<>();
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == 1 && !visited[i][j]) {
					cntDetail = 0;
					bfs(i, j);
					result.add(cntDetail);
					cnt++;
				}
			}
		}
		Collections.sort(result);	
		sb.append(cnt).append("\n");
		for(int num : result) {
			sb.append(num).append("\n");			
		}
		out.write(sb.toString());
		out.flush();
		out.close();
	}
	
	public static void bfs(int r, int c) {
		int[] dr = {-1,0,0,1}; // 상좌우하
		int[] dc = {0,-1,1,0};
		
		Deque<int[]> q = new ArrayDeque<int[]>();
		q.offer(new int[] {r, c});
		map[r][c] = -1;
		visited[r][c] = true;
		cntDetail++;
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int nr = curr[0]+dr[i];
				int nc = curr[1]+dc[i];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= N || map[nr][nc] == 0 || visited[nr][nc])
					continue;
				
				q.offer(new int[] {nr, nc});
				visited[nr][nc] = true;
				cntDetail++;
			}
		}
	}
}

package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_17070_파이프옮기기1 {
	static int N, answer = 0;
	static int[][] house;
	// 방향 : 가로(0), 대각선(1), 세로(2)
	static int[] dr = new int[] {0, 1, 1}; // 우(0,1), 우하(0,1,2), 하(1,2)
	static int[] dc = new int[] {1, 1, 0};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(in.readLine());
		house = new int[N+1][N+1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 1; j <= N; j++) {
				house[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(1, 2, 0);
		
		out.write(Integer.toString(answer));
		out.flush();
		out.close();
	}
	
	static void dfs(int r, int c, int preDirect) {
		if(r == N && c == N) {
			answer++;
			return;
		}
		
		int nr, nc;
		switch (preDirect) { // 이전 방향에 따라 다음 진로 결정
		case 0:
			nr = r + dr[0];
			nc = c + dc[0];
			
			if(nr <= N && nc <= N && house[nr][nc] == 0) {
				dfs(nr, nc, 0);
			}
			break;
		case 1:
			nr = r + dr[0];
			nc = c + dc[0];
			
			if(nr <= N && nc <= N && house[nr][nc] == 0) {
				dfs(nr, nc, 0);
			}
			
			nr = r + dr[2];
			nc = c + dc[2];
			
			if(nr <= N && nc <= N && house[nr][nc] == 0) {
				dfs(nr, nc, 2);
			}
			break;
		case 2:
			nr = r + dr[2];
			nc = c + dc[2];
			
			if(nr <= N && nc <= N && house[nr][nc] == 0) {
				dfs(nr, nc, 2);
			}
			break;
		}
		// 대각선은 공통 체크
		nr = r + dr[1];
		nc = c + dc[1];
		
		if(nr <= N && nc <= N && house[nr][nc] == 0 && house[r+1][c] == 0 && house[r][c+1] == 0) {
			dfs(nr, nc, 1);
		}
	}
}

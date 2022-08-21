package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_1012_유기농배추 {
	static int N, M, K; // N: 세로, M: 가로, K: 배추의 개수
	static int[][] field; // 배추밭 배열
	static boolean[][] visited; // 배추밭 방문 배열
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(in.readLine(), " ");
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			field = new int[N][M];
			int row, col;
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				col = Integer.parseInt(st.nextToken());
				row = Integer.parseInt(st.nextToken());
				field[row][col] = 1;		
			}
			
			visited = new boolean[N][M];
			int wormCnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(field[i][j] == 1 && !visited[i][j]) { // 해당 위치에 배추가 있고 방문하지 않았다면 탐색 시작
						searchCabbage(i, j);
						wormCnt++;
					}
				}
			}
			
			sb.append(wormCnt).append("\n");
		}
		out.write(sb.toString());
		out.flush();
		out.close();
	}
	
	public static void searchCabbage(int row, int col) { // 배추 탐색
		if(row < 0 || row >= N || col < 0 || col >= M) return; // 범위를 벗어난 경우 종료
		else if(field[row][col] == 0 || visited[row][col]) return; // 배추가 없거나 이미 방문한 배추인 경우 종료
		else {
			visited[row][col] = true; // 방문 체크
			searchCabbage(row-1, col);  // 상
			searchCabbage(row+1, col);  // 하
			searchCabbage(row, col-1);  // 좌
			searchCabbage(row, col+1);  // 우	
		}
	}
}
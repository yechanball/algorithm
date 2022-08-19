package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main_1987_알파벳 {
	static int R, C; // 행, 열 크기
	static int maxMove = 0; // 이동할 수 있는 최대 칸 수
	static char[][] board; // 보드
	// 탐색방향 => 상, 좌, 하, 우
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, -1, 0, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		board = new char[R][C]; // 보드
		for (int i = 0; i < R; i++) {
			String input = in.readLine();
			for (int j = 0; j < C; j++) {
				board[i][j] = input.charAt(j);
			}
		}
		
		findMove(0, 0, 0, 0); // 최장 경로 찾기, (row, col, depth)
		
		out.write(Integer.toString(maxMove));
		out.flush();
		out.close();
	}
	
	public static void findMove(int row, int col, int depth, int flag) {
		// 범위를 벗어난 경우
		if(row < 0 || row >= R || col < 0 || col >= C) 
			return;
		int idx = (int)(board[row][col]-'A');
		//  이미 지나간 알파벳인 경우 -> 최댓값 비교
		if((flag & 1<<idx) != 0) {
			maxMove = (depth > maxMove) ? depth : maxMove;
			return;
		}
		
		for (int d = 0; d < 4; d++) { // 현재 위치와 인접한 노드 검사
			findMove(row + dr[d], col + dc[d], depth+1, flag | 1<<idx); // 재귀 호출
		}
	}
}

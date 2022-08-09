package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_9663_NQueen {
	static int N;
	static int[][] board;
	static boolean[] col;
	static int cnt = 0;
	// 대각선 방향   좌상, 우상
	static int[] dr = {-1, -1};
	static int[] dc = {-1, 1};
	
	// 대각선 검사
	public static boolean check(int row, int col, int direction) {
		int nr = row + dr[direction];
		int nc = col + dc[direction];
		if(nr < 0 || nr >= N || nc < 0 || nc >= N ) return true; // 범위 벗어난 경우 이동 경로에 퀸이 없었기에 true로 종료
		else if(board[nr][nc] == 1) return false; // 대각선에 퀸이 있다면 false
		else return check(nr, nc, direction); // 대각선 따라 체크하기
	}

	// 체스판에 퀸 놓기
	public static void nQueen(int row) {
		if(row == N) { // 모든 행을 다 채운 경우 종료
			cnt++; // 방법의 수 1 추가
			return;
		}else{
			for (int i = 0; i < N; i++) {
				if(!col[i]) { // 놓지 않은 열 확인
					// 좌상/우상 대각선 체크
					if(check(row, i, 0) && check(row, i, 1) ) { // 대각선에 아무것도 없으면 퀸 놓기
						board[row][i] = 1;
						col[i] = true;
						nQueen(row+1); // 재귀 호출
						board[row][i] = 0; // 순열을 위한 값 초기화
						col[i] = false;
					}
				}
			}			
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		board = new int[N][N];
		col = new boolean[N];
		nQueen(0); // 퀸 놓기 메서드 호출
		System.out.print(cnt);
	}
}

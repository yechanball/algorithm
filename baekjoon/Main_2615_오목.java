package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2615_오목 {
	static int N = 19;
	static int[][] board;
	static int cnt;
	// 탐색 방향 =>  우상,우,우하,하 (좌하,좌,좌상,상은 중복되서 제외)
	static int[] dr = {-1, 0, 1, 1};
	static int[] dc = {1, 1, 1, 0};
	
	// 방향 탐색
	public static void check(int key, int row, int col, int direction) {
		int nr = row + dr[direction];
		int nc = col + dc[direction];
		if(nr < 0 || nr >= N || nc < 0 || nc >= N || board[nr][nc] != key) return; // 범위 벗어난 경우, 경로에 다른 돌이 있는 경우 -> 재귀 종료
		else {
			cnt++;
			check(key, nr, nc, direction); // 진행방향에 맞추어 다음 경로 확인하기 -> 재귀 호출
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		board = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken()); // 검은 돌: 1, 흰 돌: 2, 비어있는곳: 0
			}
		}
		// 탐색 시작
		int pr, pc;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(board[i][j] != 0) {
					for (int k = 0; k < 4; k++) {
						cnt = 1; // 카운트 초기화
						pr = i - dr[k];
						pc = j - dc[k];
						if(pr < 0 || pr >= N || pc < 0 || pc >= N || board[pr][pc] != board[i][j]) // 범위 벗어난 경우, 반대편 경로에 같은 돌이 있는 경우
							check(board[i][j], i, j, k); // 진행방향에 맞추어 다음 경로 확인하기 -> 재귀 호출
						else if(board[pr][pc] == board[i][j]) continue; // 반대편 경로에 같은 돌이 있는 경우 -> 해당 방향 탐색 종료
						if(cnt == 5) { // 돌이 5개 있으면 출력하고 종료
							System.out.println(board[i][j]);
							System.out.print((i+1)+" "+(j+1));
							return;
						}
					}					
				}
			}
		}
		System.out.print(0); // 끝까지 탐색했는데 없다면 0출력
	}
}

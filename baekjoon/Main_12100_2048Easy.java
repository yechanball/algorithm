package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_12100_2048Easy {
	static int N; // 보드 크기
	static int maxBlock = 0; // 최대 블록
	static int[][] board; // 보드
	static int[] order = new int[10];
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(in.readLine());
		board = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		play(0); // 게임 실행
		
		System.out.print(maxBlock);
	}

	private static void play(int cnt) {
		if(cnt == 5) { // 5번 실행한 경우 최댓값 확인
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(board[i][j] > maxBlock) {
						maxBlock = board[i][j];
					}
				}
			}		
			return;
		}
		
		int[][] tmp = new int[N][N]; // 복구를 위한 보드 복사본
		for (int i = 0; i < N; i++) {
			tmp[i] = Arrays.copyOf(board[i], N);
		}
		
		for (int i = 0; i < 4; i++) { // 4가지 방향 체크
			move(i); // 이동
			
			order[cnt] = i; 
			
			play(cnt+1); // 다음 회차 실행
			
			for (int j = 0; j < N; j++) { // 보드 복구
				board[j] = Arrays.copyOf(tmp[j], N);
			}
		}
		
	}

	private static void move(int mode) {
		int[] arr = new int[N];
		int idx = 0;
		boolean isCombine = false;
		
		if(mode == 0) { // 상
			for (int c = 0; c < N; c++) {
				idx = 0;
				isCombine = false;
				for (int r = 0; r < N; r++) {
					if(board[r][c] == 0) {
						continue;
					}else if(idx > 0 && !isCombine && arr[idx-1] == board[r][c]) {
						arr[idx-1] *= 2;
						isCombine = true;
					}else {
						arr[idx++] = board[r][c];
						isCombine = false;
					}
				}
				
				for (int i = 0; i < idx; i++) {
					board[i][c] = arr[i];
				}
				for (int i = idx; i < N; i++) {
					board[i][c] = 0;
				}
			}
		}else if(mode == 1) { // 하
			for (int c = 0; c < N; c++) {
				idx = 0;
				isCombine = false;
				for (int r = N-1; r >= 0; r--) {
					if(board[r][c] == 0) {
						continue;
					}else if(idx > 0 && !isCombine && arr[idx-1] == board[r][c]) {
						arr[idx-1] *= 2;
						isCombine = true;
					}else {
						arr[idx++] = board[r][c];
						isCombine = false;
					}
				}
				
				for (int i = 0; i < idx; i++) {
					board[N-1-i][c] = arr[i];
				}
				for (int i = idx; i < N; i++) {
					board[N-1-i][c] = 0;
				}
			}
		}else if(mode == 2) { // 좌
			for (int r = 0; r < N; r++) {
				idx = 0;
				isCombine = false;
				for (int c = 0; c < N; c++) {
					if(board[r][c] == 0) {
						continue;
					}else if(idx > 0 && !isCombine && arr[idx-1] == board[r][c]) {
						arr[idx-1] *= 2;
						isCombine = true;
					}else {
						arr[idx++] = board[r][c];
						isCombine = false;
					}
				}
				
				for (int i = 0; i < idx; i++) {
					board[r][i] = arr[i];
				}
				for (int i = idx; i < N; i++) {
					board[r][i] = 0;
				}
			}
		}else { // 우
			for (int r = 0; r < N; r++) {
				idx = 0;
				isCombine = false;
				for (int c = N-1; c >= 0; c--) {
					if(board[r][c] == 0) {
						continue;
					}else if(idx > 0 && !isCombine && arr[idx-1] == board[r][c]) {
						arr[idx-1] *= 2;
						isCombine = true;
					}else {
						arr[idx++] = board[r][c];
						isCombine = false;
					}
				}
				
				for (int i = 0; i < idx; i++) {
					board[r][N-1-i] = arr[i];
				}
				for (int i = idx; i < N; i++) {
					board[r][N-1-i] = 0;
				}
			}	
		}
	}
}

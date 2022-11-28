package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1018_체스판다시칠하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		boolean[][] board = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			String str = in.readLine();
			for (int j = 0; j < M; j++) {
				if(str.charAt(j) == 'B') board[i][j] = true;
			}
		}
		
		int minCnt = Integer.MAX_VALUE;
		for (int startRow = 0; startRow <= N-8; startRow++) {
			for (int startCol = 0; startCol <= M-8; startCol++) {
				int cntBW = 0, cntWB = 0; // cntBW:검흰 | cntWB:흰검
				for (int r = 0; r < 8; r++) {
					for (int c = 0; c < 8; c++) {
						if(r%2 == 0) { // 홀수행
							if(c%2 == 0) { // 홀수열
								if(board[startRow+r][startCol+c]) cntWB++; // 검은색
								else cntBW++; // 흰색
							}else { // 짝수열
								if(board[startRow+r][startCol+c]) cntBW++; // 검은색
								else cntWB++; // 흰색						
							}
						}else { // 짝수행
							if(c%2 == 0) { // 홀수열
								if(board[startRow+r][startCol+c]) cntBW++; // 검은색
								else cntWB++; // 흰색						
							}else { // 짝수열
								if(board[startRow+r][startCol+c]) cntWB++; // 검은색
								else cntBW++; // 흰색
							}
						}
					}				
				}
				int tmpCnt = Math.min(cntBW, cntWB);
				minCnt = Math.min(minCnt, tmpCnt);				
			}
		}
		System.out.print(minCnt);
	}
}

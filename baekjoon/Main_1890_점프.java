package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1890_점프 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		long[][] board = new long[N][N];
		board[0][0] = 1;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				int dist = Integer.parseInt(st.nextToken());
				if(board[i][j] > 0 && dist > 0) {
					if(i+dist < N) board[i+dist][j] += board[i][j];
					if(j+dist < N) board[i][j+dist] += board[i][j];
				}
			}
		}
		System.out.print(board[N-1][N-1]);
	}
}

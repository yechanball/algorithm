package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11049_행렬곱셈순서 {
	static class Matrix {
		int r;
		int c;
		
		public Matrix(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	
	static Matrix[] matrixs;
	static long[][] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(in.readLine());
		matrixs = new Matrix[N];
		dp = new long[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			matrixs[i] = new Matrix(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			
			for (int j = 0; j < N; j++) {
				if(i == j) dp[i][j] = 0;
				else dp[i][j] = Integer.MAX_VALUE;
			}
		}
		
		for (int size = 1; size < N; size++) {
			for (int start = 0; start < N; start++) {
				int end = start + size;
				if(end >= N) break;
				for (int k = start; k < end; k++) {
					dp[start][end] = Math.min(dp[start][k] + dp[k+1][end] + matrixs[start].r * matrixs[k].c * matrixs[end].c, dp[start][end]);
				}
			}
		}

		System.out.print(dp[0][N-1]);		
	}
}

package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_7677_Fibonacci {
	static int M = 2; // 행렬의 크기
	static long C = 10000; // 나눠야할 수
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		while(true) {
			long N = Long.parseLong(in.readLine()); // N번째 피보나치 수
			if(N == -1) break;
			if(N == 0) sb.append("0").append("\n");
			else {
				long[][] A = new long[][] {{1, 1}, {1, 0}}; // 피보나치 수를 구하기 위한 행렬
				long[][] result = squared(A, N-1); // N번째 피보나치 수는 N-1 제곱하였을 때 [0, 0] 값
				
				sb.append(result[0][0]).append("\n");			
			}
		}
		
		out.write(sb.toString());
		out.flush();
		out.close();
	}
	
	public static long[][] squared(long[][] A, long B) { // 분할정복 거듭제곱
		if(B == 1 || B == 0) return remain(A);
		long[][] half = squared(A, B/2);
		return (B%2 == 0) ? remain(multiple(half, half)) : remain(multiple(multiple(half, half), A));
	}
	
	public static long[][] multiple(long[][] m1, long[][] m2){ // 행렬 곱
		long[][] result = new long[M][M];
		
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < M; j++) {
				for (int k = 0; k < M; k++) {
					result[i][j] += m1[i][k] * m2[k][j];					
				}
			}
		}
		
		return result;
	}
	
	public static long[][] remain(long[][] m){ // 나머지 연산
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < M; j++) {
				m[i][j] %= C;
			}
		}
		
		return m;
	}
}
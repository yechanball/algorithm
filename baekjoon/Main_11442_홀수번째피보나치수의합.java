package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_11442_홀수번째피보나치수의합 {
	static int M = 2; // 행렬의 크기
	static long C = 1_000_000_007; // 나눠야할 수
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		long N = Long.parseLong(in.readLine()); // N번째 피보나치 수
		long[][] A = new long[][] {{1, 1}, {1, 0}}; // 피보나치 수를 구하기 위한 행렬
		long oddSumN; // 0번 항부터 2N-1번째 항까지 홀수번째 항 합은 2N번째 피보나치 수와 같음

		if(N%2 == 0) { // N이 짝수인 경우 -> N번째 항이 합과 동일
			oddSumN = squared(A, N-1)[0][0]; // N번째 피보나치 수			
		}else { // N이 홀수인 경우 -> N+1번째 항이 합과 동일
			oddSumN = squared(A, N)[0][0]; // N번째 피보나치 수						
		}
		System.out.print(oddSumN);
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
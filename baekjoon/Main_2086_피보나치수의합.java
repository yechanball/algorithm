package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2086_피보나치수의합 {
	static int M = 2; // 행렬의 크기
	static long C = 1_000_000_000; // 나눠야할 수
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		long a = Long.parseLong(st.nextToken()); // a번째 피보나치 수	
		long b = Long.parseLong(st.nextToken()); // b번째 피보나치 수
		
		long[][] A = new long[][] {{1, 1}, {1, 0}}; // 피보나치 수를 구하기 위한 행렬
		long sumA = squared(A, a)[0][0]; // a-1번째 항까지 합은 a+1번째 피보나치 수에서 1를 뺀 값
		long sumB = squared(A, b+1)[0][0]; // b번째 항까지 합은 b+2번째 피보나치 수에서 1를 뺀 값
		
		long answer = sumB - sumA;
		if(answer < 0) answer += C; // 정답이 음수인 경우는 나누기 이전 형태로 복구
		System.out.print(answer); // a번째부터 b번째 항까지 합은 b번째 항까지 합에서 a-1번째 항까지 합을 뺀다.
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
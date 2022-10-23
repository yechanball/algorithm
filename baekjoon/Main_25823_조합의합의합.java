package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_25823_조합의합의합 {
	static long P = 1_000_000_007; // 나눠야 할 수
	static long[] fact = new long[400_001]; // 계승 값 배열
	static long[] inverse = new long[400_001]; // 역원 값 배열
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(in.readLine());
		
		// 계승 값 계산
		fact[0] = 1;
		for (int i = 1; i <= 400_000; i++) {
			fact[i] = i * fact[i-1] % P;
		}
		
		// 역원 값 계산 :  (N!)^(-1) mod P = (N!)^(P-2)
		inverse[400_000] = pow(fact[400_000], P-2);
		for (int i = 399_999; i >= 0; i--) {
			inverse[i] = inverse[i+1] * (i+1) % P;
		}
		
		long answer = 0;
		
		for (int n = 3; n <= M; n++) {
			// sigma(k=0~n) (nCk)^2 = 2nCn
			// 2nCn = 2n! * n^(-1) * n^(-1)
			answer += fact[2*n] * (inverse[n] * inverse[n] % P) % P;
			answer %= P;
		}
		
		System.out.print(answer);
	}

	private static long pow(long A, long X) { // A^X 거듭제곱 계산 -> 분할정복
		if(X == 0) return 1;
		long half = pow(A, X/2) % P;
		return (X%2 == 0) ? half*half%P : (half*half%P)*A%P;
	}
}

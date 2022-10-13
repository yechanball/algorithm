package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16134_조합Combination {
	static int N, R;
	static long P = 1_000_000_007; // 나눠야 할 수
	static long[] fact = new long[1_000_001]; // 계승 값 배열
	static long[] inverse = new long[1_000_001]; // 역원 값 배열	
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		// 계승 값 채우기
		fact[0] = 1;
		for (int i = 1; i <= 1_000_000; i++) {
			fact[i] = i * fact[i-1] % P;
		}
		
		// 역원 값 채우기 (N!)^(-1) mod P = (N!)^(P-2)
		inverse[1_000_000] = pow(fact[1_000_000], P-2);
		for (int i = 999_999; i >= 0; i--) {
			inverse[i] = inverse[i+1] * (i+1) % P;
		}
		
		// nCr = n! * r^(-1) * (n-r)^(-1)
		long answer = fact[N] * (inverse[R] * inverse[N-R] % P) % P; 
		
		System.out.print(answer);
	}

	private static long pow(long A, long X) { // A^X 거듭제곱 계산 -> 분할정복
		if(X == 0) return 1;
		long half = pow(A, X/2) % P;
		return (X%2 == 0) ? half*half%P : (half*half%P)*A%P;
	}
}

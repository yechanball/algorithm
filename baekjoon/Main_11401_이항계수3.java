package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11401_이항계수3 {
	static long P = 1_000_000_007; // 나눠야 할 수
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		long[] fact = new long[N+1]; // 계승 값 배열
		long[] inverse = new long[N+1]; // 역원 값 배열
		
		// 계승 값 채우기
		fact[0] = 1;
		for (int i = 1; i <= N; i++) {
			fact[i] = i * fact[i-1] % P;
		}
		
		// 역원 값 채우기 (N!)^(-1) mod P = (N!)^(P-2)
		inverse[N] = pow(fact[N], P-2);
		for (int i = N-1; i >= 0; i--) {
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

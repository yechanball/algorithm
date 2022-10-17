package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_13977_이항계수와쿼리 {
	static final long P = 1_000_000_007; // 나눠야 할 수
	static final int size = 4_000_001; // 최대 크기
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		long[] fact = new long[size]; // 계승 값 배열
		fact[0] = 1; // 계승 값 채우기
		for (int i = 1; i < size; i++) {
			fact[i] = i * fact[i-1] % P;
		}	
		
		int M = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= M; tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			sb.append(fact[N] * pow(fact[K]*fact[N-K]%P, P-2) % P).append("\n"); // nCr = n! * r^(-1) * (n-r)^(-1)
		}
		out.write(sb.toString());
		out.flush();
		out.close();
	}

	private static long pow(long A, long X) { // A^X 거듭제곱 계산 -> 분할정복
		if(X == 1) return A % P;
		return (X%2 == 0) ? pow(A*A%P, X/2) : pow(A, X-1)*A%P;
	}
}

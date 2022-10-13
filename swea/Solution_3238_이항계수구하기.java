package algorithm.swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_3238_이항계수구하기 {
	static long P; // 나눠야할 수
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(in.readLine(), " ");
			long N = Long.parseLong(st.nextToken());
			long R = Long.parseLong(st.nextToken());
			P = Long.parseLong(st.nextToken());
			long D = N - R;
			
			long factN, factR = 1, factD = 1;
			
			long tmp = 1;
			for (long i = 1; i <= N; i++) {
				tmp = tmp * i % P;
				if(i == R) factR = tmp;
				if(i == D) factD = tmp;
			}
			factN = tmp;
			
			// 역원 값 찾기 (R!)^(-1) mod P = (R!)^(P-2)
			long inverseR = pow(factR, P-2);
			long inverseD = pow(factD, P-2);
			
			// nCr = n! * r^(-1) * (n-r)^(-1)
			long answer = factN * (inverseR * inverseD % P) % P; 
			
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		out.write(sb.toString());
		out.flush();
		out.close();
	}

	private static long pow(long A, long X) { // A^X 거듭제곱 계산 -> 분할정복
		if(X == 0) return 1;
		long half = pow(A, X/2) % P;
		return (X%2 == 0) ? half*half%P : (half*half%P)*A%P;
	}
}

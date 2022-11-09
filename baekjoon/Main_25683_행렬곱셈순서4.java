package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_25683_행렬곱셈순서4 {
	static class Matrix {
		long r;
		long c;
		
		public Matrix(long r, long c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(in.readLine());
		Matrix[] matrixs = new Matrix[N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			matrixs[i] = new Matrix(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
		}
		
		long cnt = 0;
		long start = matrixs[N-1].c;
		for (int i = N-2; i >= 0; i--) {
			cnt += (start * matrixs[i].c * matrixs[i].r);
		}
		
		System.out.print(cnt);
	}
}
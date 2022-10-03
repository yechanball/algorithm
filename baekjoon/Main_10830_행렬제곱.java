package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_10830_행렬제곱 {
	static int N; // 행렬의 크기
	static long C = 1000; // 나눠야할 수
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		
		long[][] input = new long[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < N; j++) {
				input[i][j] = Long.parseLong(st.nextToken());
			}
		}
		
		long[][] result = squared(input, B);
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(result[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		out.write(sb.toString());
		out.flush();
		out.close();
	}
	
	public static long[][] squared(long[][] A, long B) { // 분할정복 거듭제곱
		if(B == 1) return remain(A);
		long[][] half = squared(A, B/2);
		return (B%2 == 0) ? remain(multiple(half, half)) : remain(multiple(multiple(half, half), A));
	}
	
	public static long[][] multiple(long[][] m1, long[][] m2){
		long[][] result = new long[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					result[i][j] += m1[i][k] * m2[k][j];					
				}
			}
		}
		
		return result;
	}
	
	public static long[][] remain(long[][] m){ // 나머지 연산
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				m[i][j] %= C;
			}
		}
		
		return m;
	}
}
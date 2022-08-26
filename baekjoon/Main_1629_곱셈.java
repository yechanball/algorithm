package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_1629_곱셈 {
	static long C; // 나눠야할 수
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		C = Long.parseLong(st.nextToken());
		
		out.write(Long.toString(squared(A, B)));
		out.flush();
		out.close();
	}
	
	public static long squared(long A, long B) { // 분할정복 거듭제곱
		if(B == 1) return A%C;
		long half = squared(A, B/2);
		return (B%2 == 0) ? half*half%C : (half*half%C)*A%C;
	}
}
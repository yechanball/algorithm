package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2217_로프 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine()), maxW = 0;
		int[] rope = new int[N];
		for (int i = 0; i < N; i++) {
			rope[i] = Integer.parseInt(in.readLine());
		}		
		Arrays.sort(rope);
		for (int i = N-1; i >= 0; i--) {
			maxW = Math.max(maxW, rope[i] * (N-i));
		}
		System.out.print(maxW);
	}
}

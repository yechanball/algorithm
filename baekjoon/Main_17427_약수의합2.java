package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_17427_약수의합2 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		long gN = 0;
		for (int i = 1; i <= N; i++) {
			gN += N/i*i;
		}
		System.out.print(gN);
	}
}
package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_3049_다각형의대각선 {
	static int combination(int N, int K) {
		if(N < K) return 0;
		else if(N == K || K == 0) return 1;
		else return combination(N-1, K)+combination(N-1, K-1);
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		System.out.print(combination(N, 4));
	}
}

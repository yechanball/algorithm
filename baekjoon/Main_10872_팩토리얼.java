package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_10872_팩토리얼 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		long N = Long.parseLong(in.readLine());
		long ans = 1;
		for (long i = 1; i <= N; i++) {
			ans *= i;
		}
		System.out.print(ans);
	}
}

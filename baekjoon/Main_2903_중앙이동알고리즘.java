package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2903_중앙이동알고리즘 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine()), cnt = 2;
		for (int i = 0; i < N; i++) {
			cnt += cnt - 1;
		}
		System.out.println(cnt*cnt);
	}
}

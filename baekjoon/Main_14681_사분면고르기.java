package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main_14681_사분면고르기 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int x = Integer.parseInt(in.readLine()), y = Integer.parseInt(in.readLine());
		System.out.print((x > 0) ? (y > 0) ? 1 : 4 : (y > 0) ? 2 : 3);
	}
}

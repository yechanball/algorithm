package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2292_벌집 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine()), range = 1, cnt = 1;
		while(N > range) {
			range += 6*cnt++;
		}
		System.out.print(cnt);
	}
}
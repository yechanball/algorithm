package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2012_등수매기기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		long[] ranking = new long[N+1];
		for (int i = 1; i <= N; i++) {
			ranking[i] = Long.parseLong(in.readLine());
		}
		Arrays.sort(ranking);
		long complain = 0;
		for (int i = 1; i <= N; i++) {
			if(ranking[i] == i) continue;
			complain += Math.abs(ranking[i] - i);
		}
		System.out.print(complain);
	}
}

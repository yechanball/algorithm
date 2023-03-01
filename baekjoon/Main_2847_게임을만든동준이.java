package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2847_게임을만든동준이 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[] score = new int[N];
		for (int i = 0; i < N; i++) {
			score[i] = Integer.parseInt(in.readLine());
		}
		int pre = score[N-1]+1, cnt = 0;
		for (int i = N-1; i >= 0; i--) {
			if(pre <= score[i]) {
				cnt += (score[i] - pre + 1);
				score[i] = pre - 1;
			}
			pre = score[i];
		}
		System.out.print(cnt);
	}
}

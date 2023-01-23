package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1475_방번호 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String N = in.readLine();
		int[] needs = new int[10];
		for (int i = 0, len = N.length(); i < len; i++) {
			needs[N.charAt(i) - '0']++;
		}
		needs[6] = (needs[6]+needs[9])%2 == 1 ? (needs[6] + needs[9]) / 2 + 1 : (needs[6] + needs[9]) / 2;
		int max = 0;
		for (int i = 0; i < 9; i++) {
			max = needs[i] > max ? needs[i] : max;
		}
		System.out.print(max);
	}
}

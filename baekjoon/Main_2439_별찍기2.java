package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2439_별찍기2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(in.readLine());
		String star = "";
		String blank = "";
		for (int i = 1; i <= N; i++) {
			blank += " ";
		}
		for (int i = 1; i <= N; i++) {
			star += "*";
			blank = blank.substring(0, N-i);
			sb.append(blank).append(star).append("\n");
		}
		System.out.print(sb.toString());
	}
}
package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2438_별찍기1 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(in.readLine());
		String star = "";
		for (int i = 1; i <= N; i++) {
			star += "*";
			sb.append(star).append("\n");
		}
		System.out.print(sb.toString());
	}
}
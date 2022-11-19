package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_11720_숫자의합 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine()), result = 0;
		String input = in.readLine();
		for (int i = 0; i < N; i++)
			result += (input.charAt(i) - '0');
		System.out.print(result);
	}
}
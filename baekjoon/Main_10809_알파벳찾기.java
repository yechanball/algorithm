package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_10809_알파벳찾기 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String S = in.readLine();
		for (int c = 97; c <= 122; c++) {
			System.out.print(S.indexOf(c) + " ");
		}
	}
}

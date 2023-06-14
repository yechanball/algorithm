package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_9086_문자열 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		for (int t = 0; t < T; t++) {
			String str = in.readLine();
			System.out.print(str.charAt(0));
			System.out.println(str.charAt(str.length()-1));
		}
	}
}

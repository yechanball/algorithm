package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2577_숫자의개수 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String num = Integer.toString(Integer.parseInt(in.readLine()) * Integer.parseInt(in.readLine()) * Integer.parseInt(in.readLine()));
		int len = num.length();
		for (int i = 0; i <= 9; i++) {
			System.out.println(len - num.replace(Integer.toString(i), "").length());
		}
	}
}

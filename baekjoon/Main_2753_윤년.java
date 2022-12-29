package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2753_윤년 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int year = Integer.parseInt(in.readLine());
		System.out.print((year % 4 == 0 && (year % 100 != 0 || year % 400 == 0) ? 1 : 0));
	}
}

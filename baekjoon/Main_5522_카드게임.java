package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_5522_카드게임 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int total = 0;
		for (int i = 0; i < 5; i++) {
			total += Integer.parseInt(in.readLine());
		}
		System.out.print(total);
	}
}

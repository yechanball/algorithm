package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_5597_과제안내신분 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		boolean[] student = new boolean[31];
		for (int i = 0; i < 28; i++) {
			student[Integer.parseInt(in.readLine())] = true;			
		}
		for (int i = 1; i <= 30; i++) {
			if(student[i]) continue;
			System.out.println(i);
		}
	}
}

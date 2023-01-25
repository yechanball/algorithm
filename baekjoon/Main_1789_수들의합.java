package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1789_수들의합 {
	public static void main(String[] args) throws NullPointerException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		long S = Long.parseLong(in.readLine());
		long bound = 2, cnt = 1;
		while(S > bound) bound += (++cnt+1);
		System.out.print(cnt);
	}
}

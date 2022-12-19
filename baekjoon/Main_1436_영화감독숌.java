package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1436_영화감독숌 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine()), num = 666;
		while(true) {
			if(Integer.toString(num).contains("666")) {
				if(--N == 0) break;
			}
			num++;
		}
		System.out.print(num);
	}
}

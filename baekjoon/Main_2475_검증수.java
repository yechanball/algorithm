package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2475_검증수 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = 0;
		for (int i = 0; i < 5; i++) {
			int k = Integer.parseInt(st.nextToken());
			n += k*k;
		}
		System.out.print(n%10);
	}
}

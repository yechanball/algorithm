package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_9095_123더하기 {
	public static int sum(int N) {
		if(N < 0) return 0;
		else if(N == 0) return 1;
		else return sum(N-1) + sum(N-2) +sum(N-3);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(in.readLine());
			sb.append(sum(N)).append("\n");
		}
		System.out.print(sb);
	}
}

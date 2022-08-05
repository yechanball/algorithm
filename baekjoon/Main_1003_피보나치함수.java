package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1003_피보나치함수 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		int[] zeroCnt = new int[41];
		int[] oneCnt = new int[41];
		zeroCnt[0]++;
		oneCnt[1]++;
		for (int i = 2; i <= 40; i++) {
			zeroCnt[i] = zeroCnt[i-1] + zeroCnt[i-2];
			oneCnt[i] = oneCnt[i-1] + oneCnt[i-2];
		}
		
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(in.readLine());
			sb.append(zeroCnt[N]).append(" ").append(oneCnt[N]).append("\n");
		}
		System.out.print(sb);
	}
}

package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10871_X보다작은수 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int num;
		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < N; i++) {
			num = Integer.parseInt(st.nextToken());
			if(num < X) sb.append(num).append(" ");
		}
		System.out.print(sb);
	}
}

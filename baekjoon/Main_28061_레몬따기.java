package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_28061_레몬따기 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine()), max = 0;

		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++){
			int a = Integer.parseInt(st.nextToken());
			max = Math.max(max, a - (N - i));
		}
		System.out.print(max);
	}
}

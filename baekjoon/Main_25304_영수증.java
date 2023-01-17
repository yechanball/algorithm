package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_25304_영수증 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int X = Integer.parseInt(in.readLine());
		int N = Integer.parseInt(in.readLine());
		int sum = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			sum += Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken());
		}
		System.out.print(sum == X ? "Yes" : "No");
	}
}

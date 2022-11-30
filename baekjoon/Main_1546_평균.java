package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1546_평균 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine()), sum = 0, max = 0;
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < N; i++) {
			int M = Integer.parseInt(st.nextToken());
			sum += M;
			max = (M > max) ? M : max;
		}
		System.out.print(((double)sum/(double)N) / (double)max * 100);
	}
}

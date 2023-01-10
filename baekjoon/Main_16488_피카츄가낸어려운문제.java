package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16488_피카츄가낸어려운문제 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		long N = Long.parseLong(st.nextToken()), K = Long.parseLong(st.nextToken());
		System.out.print(N*N*K);
	}
}

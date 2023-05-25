package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15964_이상한기호 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		System.out.print((A+B)*(A-B));
	}
}

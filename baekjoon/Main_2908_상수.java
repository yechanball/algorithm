package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2908_상수 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int A = Integer.parseInt(st.nextToken()), B = Integer.parseInt(st.nextToken());
		System.out.print(Math.max(A%10*100 + A%100/10*10 + A/100, B%10*100 + B%100/10*10 + B/100));
	}
}

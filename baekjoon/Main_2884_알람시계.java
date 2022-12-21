package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2884_알람시계 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int H = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
		System.out.print(((M < 45) ? ((H == 0) ? 23 : H-1) : H) + " " + ((M < 45) ? M+15 : M-45));
	}
}

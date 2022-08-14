package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_9461_파도반수열 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		// 파도반 수열 P(N) 생성
		long[] arr = new long[101];
		arr[1] = 1;
		arr[2] = 1;
		for (int i = 3; i <= 100; i++) {
			arr[i] = arr[i-2] + arr[i-3]; // P(N) = P(N-2) + P(N-3)
		}
		// 테스트 케이스 입력
		for (int tc = 1; tc <= T; tc++) {
			sb.append(arr[Integer.parseInt(in.readLine())]).append("\n");
		}
		// 출력
		out.write(sb.toString());
		out.flush();
		out.close();
	}
}

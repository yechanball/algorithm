package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_10422_괄호 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		long[] answer = new long[5001]; // 1 <= 문자열의 길이 <= 5000
		answer[0] = 1;
		answer[2] = 1;
		for (int i = 2; i <= 2500; i++) { // L이 4부터 5000까지 짝수만 고려 -> 문자열 길이에 따른 문자열 개수 배열 생성
			int len = i * 2; // 길이가 len일때
			int subLen1 = i * 2 - 2; // subLen1 + subLen2 = len - 2
			int subLen2 = 0;
			while(subLen1 >= 0) {
				answer[len] += (answer[subLen1] * answer[subLen2]);
				answer[len] %= 1_000_000_007; // 개수를 1,000,000,007로 나눈 나머지로 저장
				subLen1 -= 2;
				subLen2 += 2;
			}
		}
		
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int L = Integer.parseInt(in.readLine());
			sb.append(answer[L]).append("\n"); // 생성 가능한 괄호 문자열 개수 출력
		}
		out.write(sb.toString());
		out.flush();
		out.close();
	}
}

package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_1312_소수 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		for (int i = 1; i <= N; i++) { // 나눈 나머지를 10씩 하여 소수 자리수 아래로 탐색
			A = A % B * 10;
		}
		int result = A/B; // N번째 자리에서 몫이 소수자리 임으로 몫 구하기
		
		out.write(Integer.toString(result));
		out.flush();
		out.close();
	}
}

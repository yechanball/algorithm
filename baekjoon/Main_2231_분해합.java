package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2231_분해합 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = in.readLine();
		int N = Integer.parseInt(str);
		int M = 0, sum;
		int start = N-(6*9); // 각 자리수(최대 6자리)를 더하기 전인 M값 유추
		if(start <= 1) start = 1; // 만약 작은 수라서 1이하가 되면 1로 지정
		for (int i = start; i <= N; i++) {
			sum = i + i/100000 + i%100000/10000 + i%10000/1000 + i%1000/100 + i%100/10 + i%10;
			if(sum == N) {
				M = i;
				break;
			}
		}
		System.out.print(M);
	}
}

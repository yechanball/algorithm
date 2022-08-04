package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_10989_수정렬하기3 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(in.readLine());
		int[] countNum = new int[10001];
		for (int i = 0; i < N; i++) {
			countNum[Integer.parseInt(in.readLine())]++;
		}
		int idx = 1, cnt = 0;
		while(cnt < N && idx < 10001) {
			if(countNum[idx] != 0) {
				sb.append(idx).append("\n");
				countNum[idx]--;
				cnt++;
			}else {
				idx++;
			}
		}
		System.out.print(sb);
	}
}
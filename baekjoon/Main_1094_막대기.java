package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1094_막대기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int X = Integer.parseInt(in.readLine()); // X : X<=64인 자연수
		int cnt = 0;
		// 주어진 X를 2진수로 변환했을때 1의 개수가 필요한 막대기의 개수와 동일 
		while(X > 0) {
			if(X%2 == 1) cnt++; // 나머지가 1인 경우 카운트
			X /= 2; // 2로 나누기
		}

		System.out.print(cnt);
	}
}

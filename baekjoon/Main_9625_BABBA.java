package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_9625_BABBA {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int K = Integer.parseInt(in.readLine());
		int A = 1, B = 0; // 초기 A, B의 개수
		int newA, newB;
		
		for (int i = 0; i < K; i++) { // K번 연산 실행
			newA = B; // B의 개수만큼 A 생성
			newB = A+B; // A의 개수와 B의 개수만큼 B 생성
			A = newA; // 값 교체
			B = newB;
		}
		
		out.write(Integer.toString(A));
		out.append(" ");
		out.append(Integer.toString(B));
		out.flush();
		out.close();
	}
}

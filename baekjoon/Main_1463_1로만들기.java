package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1463_1로만들기 {
	static int makeOne(int[] memo, int N) {
		if( N == 1) return 0; // 1일때는 0 반환
		else if( memo[N-1] != 0) return memo[N-1]; // 이미 계산된 값이 있으면 값 반환
		else { // 계산된 값이 없으면 가장 적은 최소 횟수 구하기
			memo[N-1] = Math.min( Math.min( (N%3==0)? makeOne(memo, N/3)+1 : Integer.MAX_VALUE , (N%2==0)? makeOne(memo, N/2)+1 : Integer.MAX_VALUE), makeOne(memo, N-1)+1);
			return memo[N-1];	
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[] memo = new int[N];
		System.out.println(makeOne(memo, N));
	}
}

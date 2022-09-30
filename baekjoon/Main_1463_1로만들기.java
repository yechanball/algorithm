package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_1463_1로만들기 {
	static int[] memo = new int[1000001];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(in.readLine());
		out.write(Integer.toString(makeOne(N)));
		out.flush();
		out.close();
	}
	
	static int makeOne(int N) {
		if(N == 1) return 0; // 1일때는 0 반환
		else if(memo[N-1] != 0) return memo[N-1]; // 이미 계산된 값이 있으면 값 반환
		else { // 계산된 값이 없으면 가장 적은 최소 횟수 구하기
			memo[N-1] = Math.min( Math.min( (N%3==0) ? makeOne(N/3)+1 : Integer.MAX_VALUE , (N%2==0)? makeOne(N/2)+1 : Integer.MAX_VALUE), makeOne(N-1)+1);
			return memo[N-1];	
		}
	}
}

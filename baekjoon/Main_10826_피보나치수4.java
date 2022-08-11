package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main_10826_피보나치수4 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));		
		int N = Integer.parseInt(in.readLine());
		BigInteger[] fibo = new BigInteger[N+1]; // 범위가 long이 넘어감으로 BigInteger 사용
		if(N == 0) System.out.print(0);
		else {
			fibo[0] = BigInteger.ZERO;
			fibo[1] = BigInteger.ONE;		
			for (int i = 2; i <= N; i++) {
				fibo[i] = fibo[i-1].add(fibo[i-2]); // i번째 수는 i-1번째와 i-2번째 숫자의 합
			}
			System.out.print(fibo[N]); // N번째 숫자 출력하기			
		}
	}
}
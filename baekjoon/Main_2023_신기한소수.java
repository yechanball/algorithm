package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2023_신기한소수 {
	public static boolean isPrime(int num, int N) {
		for (int i = 2; i <= (int)Math.sqrt(num); i++) {
			if(num%i == 0) return false;
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(in.readLine());
		int limit = (int)Math.pow((double)10, (double)N);
		int start = limit/10;
		int div = 0, nowNum;
		boolean prime = true;
		for (int i = start; i < limit; i++) {
			div = start;
			prime = true;
			for (int j = 1; j <= N; j++) {
				nowNum = i/div;
				if(!isPrime(nowNum, j) || nowNum == 1) {
					prime = false;
					break;
				}
				div = div/10;
			}
			if(prime) sb.append(i).append("\n");
		}
		System.out.print(sb);
	}
}

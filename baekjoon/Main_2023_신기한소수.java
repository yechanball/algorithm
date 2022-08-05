package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2023_신기한소수 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(in.readLine());
		int limitprime = (int)Math.pow((double)10, (double)N);
		int[] prime = new int[limitprime];
		int cnt = 0;
		prime[0] = 1;
		prime[1] = 1;
		for(int i = 1; i < limitprime; i++) { // 소수 체크하기(합성수면 1, 소수는 0)
			if(prime[i] == 0) {
				cnt = 2;
				while(i*cnt < limitprime) {
					prime[i*cnt] = 1;
					cnt++;
				}
			}
		}
		int start = limitprime/10;
		int div = 0;
		boolean isPrime = true;
		for (int i = start; i < limitprime; i++) {
			div = start;
			isPrime = true;
			for (int j = 0; j < N; j++) {
				if(prime[i/div] == 1) {
					isPrime = false;
					break;
				}
				div = div/10;
			}
			if(isPrime) sb.append(i).append("\n");
		}
		System.out.print(sb);
	}
}

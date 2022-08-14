package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2581_소수 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(in.readLine());
		int N = Integer.parseInt(in.readLine());	
		boolean[] prime = new boolean[N+1];
		int cnt, minPrime = 0, totalPrime = 0;
		boolean checkMin = false;
		
		Arrays.fill(prime, true); // true는 소수, false는 소수가 아닌 수
		prime[0] = false;
		prime[1] = false;
		for(int i = 2; i <= N; i++) {
			if(prime[i]) { // 해당 수가 소수이면
				cnt = 2;
				while(i*cnt <= N) { // 해당 수의 배수 제거하기
					prime[i*cnt] = false;
					cnt++;
				}
			}
		}
		
		for (int num = M; num <= N; num++) {
			if(prime[num]) {
				if(!checkMin) {
					checkMin = true;
					minPrime = num; // 소수 최솟값 고르지 않았다면 최솟값 고르기
				}
				totalPrime += num; // 소수 누적 합하기
			}
		}
		
		if(totalPrime == 0) System.out.print(-1); // 합이 0이면 소수가 없으므로 -1 출력하기
		else System.out.print(totalPrime+"\n"+minPrime);
	}
}

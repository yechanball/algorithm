package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1676_팩토리얼0의개수 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int num;
		int twoCnt = 0;
		int fiveCnt = 0;
		
		for (int i = 1; i <= N; i++) {
			num = i;
			if(num % 2 == 0) {
				while(num % 2 == 0) {
					num /= 2;
					twoCnt++;
				}
			}
			if(num % 5 == 0) {
				while(num % 5 == 0) {
					num /= 5;
					fiveCnt++;
				}				
			}
		}
		System.out.print(Math.min(twoCnt, fiveCnt));
	}
}

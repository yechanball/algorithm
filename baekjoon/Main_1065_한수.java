package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1065_한수 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine()), cnt = 99;
		
		if(N < 100) cnt = N;
		else {
			for(int i = 100; i <= N; i++){
				int num1 = i % 10;
				int num2 = (i % 100) / 10;
				int num3 = i / 100;
				
				if((num3 - num2) == (num2 - num1)) cnt++;
			}
		}
		
		System.out.println(cnt);
	}
}

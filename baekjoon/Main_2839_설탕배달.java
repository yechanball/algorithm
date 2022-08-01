package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2839_설탕배달 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int three = 0, five = 0;
		int min = Integer.MAX_VALUE;
		int num = 0;
		
		while(five*5 <= N) {
			if( (N - (five*5))%3 == 0 ) {
				three = (N - (five*5))/3;
				num = five + three;
				if(num < min) {
					min = num;
				}
			}
			five++;
		}
		
		if(min == Integer.MAX_VALUE)
			System.out.println("-1");
		else
			System.out.println(min);
	}
}

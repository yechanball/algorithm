package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2562_최댓값 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = 9;
		int max = Integer.MIN_VALUE;
		int maxIdx = 0;
		int num = 0;
		int idx = 1;
		
		while(idx <= n) {
			num = Integer.parseInt(in.readLine());
			if(num > max) {
				max = num;
				maxIdx = idx;
			}
			idx++;
		}
		
		System.out.println(max);
		System.out.println(maxIdx);		
	}
}

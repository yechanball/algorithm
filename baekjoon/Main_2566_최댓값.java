package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2566_최댓값 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int max = -1, row = 0, col = 0;
		for (int i = 1; i <= 9; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 1; j <= 9; j++) {
				int num = Integer.parseInt(st.nextToken());
				
				if(num > max) {
					max = num;
					row = i;
					col = j;
				}
			}
		}
		System.out.println(max + "\n" + row + " " + col);
	}
}

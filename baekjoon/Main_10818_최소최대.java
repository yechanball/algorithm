package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10818_최소최대 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		String str = in.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		int num = 0;
		
		for (int i = 0; i < N; i++) {
			num = Integer.parseInt(st.nextToken());
			if(num > max) {
				max = num;
			}if(num < min) {
				min = num;
			}
		}
		
		System.out.println(min+" "+max);
	}
}

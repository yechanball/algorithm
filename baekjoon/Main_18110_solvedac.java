package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_18110_solvedac {
	public static void main(String[] args)  throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(in.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(in.readLine());
		}
		
		Arrays.sort(arr);
		
		int sum = 0;
		int except = (int) Math.round((double)n/100*15);
		for (int i = except; i < n-except; i++) {
			sum += arr[i];
		}
		
		int avg = (int) Math.round((double)sum/(n-except*2));
		System.out.print(avg);
	}
}

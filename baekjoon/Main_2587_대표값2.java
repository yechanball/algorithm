package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2587_대표값2 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int[] arr = new int[5];
		int sum = 0;
		for (int i = 0; i < 5; i++) {
			arr[i] = Integer.parseInt(in.readLine());
			sum += arr[i];
		}
		
		Arrays.sort(arr);
		System.out.println(sum/5 + "\n" + arr[2]);
	}
}

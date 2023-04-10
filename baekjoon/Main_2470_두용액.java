package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2470_두용액 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		int left = 0, right = N-1;
		int ansL = 0, ansR = 0;
		int diff = Integer.MAX_VALUE;
		
		while(left < right) {
			int sum = arr[left] + arr[right];
			int tmpDiff = Math.abs(sum);
			
			if(tmpDiff < diff) {
				ansL = arr[left];
				ansR = arr[right];
				diff = tmpDiff;
			}
			
			if(sum == 0) break;				
			
			if(sum < 0)left++;
			else right--;
		}
		
		System.out.print(ansL + " " + ansR);
	}
}

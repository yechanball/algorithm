package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2473_세용액 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		long[] arr = new long[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		Arrays.sort(arr);
		
		int ans1 = 0, ans2 = 1, ans3 = N-1;
		long minSum = Long.MAX_VALUE;
		for (int i = 0; i < N-2; i++) {
			int fix = i, left = i+1, right = N-1;
			while(left < right) {
				long tmpSum = arr[fix] + arr[left] + arr[right];
				if(Math.abs(tmpSum) < Math.abs(minSum)) {
					minSum = tmpSum;
					ans1 = fix;
					ans2 = left;
					ans3 = right;
				}
				if(tmpSum == 0) break;
				
				if(tmpSum < 0) left++;
				else right--;
			}
			
		}
		System.out.print(arr[ans1] + " " + arr[ans2] + " " + arr[ans3]);
	}
}
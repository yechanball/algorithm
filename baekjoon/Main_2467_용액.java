package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2467_용액 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int left = 0, right = N-1, ans1 = left, ans2 = right, minSum = Integer.MAX_VALUE;
		while(left < right) {
			int tmpSum = arr[left] + arr[right];
			if(Math.abs(tmpSum) < Math.abs(minSum)) {
				minSum = tmpSum;
				ans1 = left;
				ans2 = right;
			}
			if(tmpSum == 0) break;
			
			if(tmpSum < 0) left++;
			else right--;
		}
		System.out.print(arr[ans1] + " " + arr[ans2]);
	}
}

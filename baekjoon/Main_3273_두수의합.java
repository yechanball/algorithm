package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_3273_두수의합 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		
		int[] a = new int[n];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(a);
		
		int x = Integer.parseInt(in.readLine());
		int left = 0, right = n-1, sum = a[left] + a[right], cnt = 0;
		while(left < right) {
			if(sum < x) {
				sum -= a[left++];
				sum += a[left];
			}else if(sum > x) {
				sum -= a[right--];
				sum += a[right];
			}else {
				cnt++;
				sum -= a[left++];
				sum += a[left];
			}
		}
		
		System.out.println(cnt);
	}
}

package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2805_나무자르기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] tree = new int[N];
		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < N; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(tree);
		
		long min = 0;
		long max = tree[N-1];
		long mid = 0;
		long sum = 0;
		
		while(min < max) {
			sum = 0;
			mid = (min+max)/2;
			
			for (int i = N-1; i >= 0; i--) {
				if(tree[i]>mid) {
					sum += (tree[i]-mid);
				}else {
					break;
				}
			}
			if(min == mid) {
				break;
			}else if(M <= sum) {
				min = mid;
			}else {
				max = mid;
			}
		}
		System.out.print(mid);
	}
}

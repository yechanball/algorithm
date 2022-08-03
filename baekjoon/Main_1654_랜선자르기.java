package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1654_랜선자르기 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[] line = new int[K];
		long sum;
		long min = 0;
		long mid = 0;
		long max = (long)Integer.MAX_VALUE + 1;
		
		for(int i = 0; i < K; i++) {
			line[i] = Integer.parseInt(in.readLine());
		}
		
		while(min < max) {
			mid = (min + max)/2;
			sum = 0;
			for(int num : line) {
				sum += (num/mid);
			}
			if(min == mid) {
				break;
			}else if(sum >= N) {
				min = mid;
			}else {
				max = mid;
			}
		}
		
		System.out.println(mid);
	}
}
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
		long left = 1;
		long mid = 0;
		long right = -1;
		
		for(int i = 0; i < K; i++) {
			line[i] = Integer.parseInt(in.readLine());
			if(line[i] > right) {
				right = line[i];
			}
		}
		
		right++;
		
		while(left < right) {
			mid = (left + right)/2;
			
			sum = 0;
			for(int num : line) {
				sum += (num/mid);
			}
			System.out.println("left: "+left+", right: "+right+", mid: "+mid+", sum: "+sum);
			if(sum >= N) {
				left = mid+1;
			}else {
				right = mid;
			}
		}
		
		System.out.println((int)mid);
	}
}
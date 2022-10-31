package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1644_소수의연속합 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		
		boolean[] isComposite = new boolean[N+1];
		int[] arr = new int[N];
		int size = 0;
		isComposite[1] = true;
		for(int i = 1; i <= N; i++) {
			if(!isComposite[i]) { // 소수 체크
				arr[size++] = i;
				int cnt = 2;
				while(i*cnt <= N) { // 소수의 배수 제거
					isComposite[i*cnt] = true;
					cnt++;
				}
			}
		}

		int left = 0, right = 0; // 투 포인터
		int count = 0, sum = arr[0];
		while(right < size) {
			if(sum == N) {
				count++;
				sum -= arr[left++];
			}else if(sum < N) {
				sum += arr[++right];
			}else {
				sum -= arr[left++];
			}
			
			if(left > right) {
				right = left;
			}	
		}
		
		System.out.print(count);
	}
}
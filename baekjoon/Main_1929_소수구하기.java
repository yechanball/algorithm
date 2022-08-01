package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1929_소수구하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[] num = new int[N+1];
		int cnt = 0;
		
		num[1] = 1;
		for(int i = 1; i <= N; i++) {
			if(num[i] == 0) {
				cnt = 2;
				while(i*cnt <= N) {
					num[i*cnt] = 1;
					cnt++;
				}
			}
		}
		
		for(int i = M; i <= N; i++) {
			if(num[i] == 0) {
				System.out.println(i);
			}
		}
	}
}

package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2003_수들의합2 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] A = new int[N+1];
		st = new StringTokenizer(in.readLine());
		for (int i = 1; i <= N; i++) {
			A[i] = A[i-1] + Integer.parseInt(st.nextToken());
		}
		
		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < i; j++) {
				if(A[i] - A[j] == M) cnt++;
			}
		}
		
		System.out.println(cnt);
	}
}

package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_10942_팰린드롬 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(in.readLine());
		int[] arr = new int[N+1];
		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		boolean[][] isPalindrome = new boolean[N+1][N+1];
		for (int i = 1; i <= N; i++) {
			isPalindrome[i][i] = true;
			int left = i - 1;
			int right = i + 1;
			while(left > 0 && right <= N) {
				if(arr[left] == arr[right]) {
					isPalindrome[left--][right++] = true;
				}else {
					break;
				}
			}
			
			left = i;
			right = i+1;
			while(left > 0 && right <= N) {
				if(arr[left] == arr[right]) {
					isPalindrome[left--][right++] = true;
				}else {
					break;
				}
			}
		}
		
		int M = Integer.parseInt(in.readLine());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int S = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			sb.append((isPalindrome[S][E]) ? 1 : 0).append("\n");
		}
		
		out.write(sb.toString());
		out.flush();
		out.close();
	}
}

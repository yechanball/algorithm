package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1932_정수삼각형 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[][] arr = new int[N][N];
		
		arr[0][0] = Integer.parseInt(in.readLine());
		for (int i = 1; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			arr[i][0] = arr[i-1][0] + Integer.parseInt(st.nextToken());
			for (int j = 1; j < i; j++) {
				arr[i][j] = Math.max(arr[i-1][j-1], arr[i-1][j]) + Integer.parseInt(st.nextToken());
			}
			arr[i][i] = arr[i-1][i-1] + Integer.parseInt(st.nextToken());
		}
		
		int max = 0;
		for (int i = 0; i < N; i++) {
			max = Math.max(max, arr[N-1][i]);
		}
		System.out.print(max);
	}
}

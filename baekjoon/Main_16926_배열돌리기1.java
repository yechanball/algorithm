package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16926_배열돌리기1 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int preTmp, nowTmp;
		for (int r = 0; r < R; r++) {
			for (int i = 0; i < Math.min(N, M)/2; i++) {
				// 왼쪽 열 이동
				nowTmp = arr[N-i-1][i]; // 좌하 모서리
				for (int j = N-i-1; j > i; j--) {
					arr[j][i] = arr[j-1][i];
				}
				preTmp = nowTmp;
				// 하단 행 이동
				nowTmp = arr[N-i-1][M-i-1]; // 우하 모서리
				for (int j = M-i-1; j > i+1; j--) {
					arr[N-i-1][j] = arr[N-i-1][j-1]; 
				}
				arr[N-i-1][i+1] = preTmp;
				preTmp = nowTmp;
				// 오른쪽 열 이동
				nowTmp = arr[i][M-i-1]; // 우상 모서리
				for (int j = i; j < N-i-1; j++) {
					arr[j][M-i-1] = arr[j+1][M-i-1];
				}
				arr[N-i-2][M-i-1] = preTmp;
				preTmp = nowTmp;
				// 상단 행 이동
				for (int j = i; j < M-i-1; j++) {
					arr[i][j] = arr[i][j+1]; 
				}
				arr[i][M-i-2] = preTmp;	
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
}

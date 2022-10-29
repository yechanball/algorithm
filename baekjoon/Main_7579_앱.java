package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_7579_앱 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); // 앱의 개수
		int M = Integer.parseInt(st.nextToken()); // 필요한 메모리 크기
		int C = 0; // 비용 총합
		
		int[] m = new int[N+1]; // 사용중인 메모리 크기
		int[] c = new int[N+1]; // 비활성화 비용
		
		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			m[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			c[i] = Integer.parseInt(st.nextToken());
			C += c[i];
		}
		
		int[][] dp = new int[N+1][C+1]; // dp 배열
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j <= C; j++) {
				if(c[i] > j) dp[i][j] = dp[i-1][j];
				else dp[i][j] = Math.max(m[i] + dp[i-1][j-c[i]], dp[i-1][j]);
			}
		}

		for (int i = 0; i <= C ; i++) {
			if(dp[N][i] >= M) {
				System.out.print(i); // 최소 비용 출력
				break;
			}
		}
	}
}

package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1915_가장큰정사각형 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			String str = in.readLine();
			for (int j = 0; j < m; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}
		
		int maxSize = 0;
		for (int i = 0; i < n; i++) {
			if(arr[i][0] == 1) {
				maxSize = 1;
				break;
			}
		}
		if(maxSize == 0) {
			for (int i = 0; i < m; i++) {
				if(arr[0][i] == 1) {
					maxSize = 1;
					break;
				}
			}			
		}
		
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				if(arr[i][j] > 0 && arr[i-1][j] > 0 && arr[i][j-1] > 0 && arr[i-1][j-1] > 0) {
					arr[i][j] = Math.min(Math.min(arr[i-1][j] , arr[i][j-1]), arr[i-1][j-1]) + 1;
					
					if(arr[i][j] > maxSize) maxSize = arr[i][j];
				}
			}
		}
		
		System.out.print(maxSize*maxSize);
	}
}

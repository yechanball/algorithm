package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_27445_GoraniCommand {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		for (int i = 0; i < N-1; i++) {
			map[i][0] = Integer.parseInt(in.readLine());
		}
		
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < M; i++) {
			map[N-1][i] = Integer.parseInt(st.nextToken());
		}
		
		int row = 0, col = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				boolean isFind = true;
				
				for (int r = 0; r < N; r++) {
					if(map[r][0] == Math.abs(i-r) + j) continue;
					isFind = false;
					break;
				}
				if(isFind) {
					for (int c = 1; c < M; c++) {
						if(map[N-1][c] == Math.abs(N-1-i) + Math.abs(j-c)) continue;
						isFind = false;
						break;
					}					
				}	
				if(isFind) {
					row = i+1;
					col = j+1;
					break;
				}
			}
		}
		
		System.out.print(row + " " + col);
	}
}

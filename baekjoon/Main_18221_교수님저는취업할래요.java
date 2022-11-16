package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_18221_교수님저는취업할래요 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(in.readLine());
		int[][] map = new int[N][N];
		int[] seongGyu = new int[2];
		int[] gyoSooNim = new int[2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) {
					seongGyu[0] = i;
					seongGyu[1] = j;					
				}else if(map[i][j] == 5) {
					gyoSooNim[0] = i;
					gyoSooNim[1] = j;
				}
			}
		}
		
		boolean canRun = false;
		if(((seongGyu[0] - gyoSooNim[0])*(seongGyu[0] - gyoSooNim[0]) + (seongGyu[1] - gyoSooNim[1])*(seongGyu[1] - gyoSooNim[1])) >= 25) {
			int rowS = Math.min(seongGyu[0], gyoSooNim[0]), rowE = Math.max(seongGyu[0], gyoSooNim[0]);
			int colS = Math.min(seongGyu[1], gyoSooNim[1]), colE = Math.max(seongGyu[1], gyoSooNim[1]);
			int studentCnt = 0;
			for (int i = rowS; i <= rowE; i++) {
				for (int j = colS; j <= colE; j++) {
					if(map[i][j] == 1) {
						if(++studentCnt >= 3) {
							canRun = true;
							break;
						}
					}
				}
			}			
		}		
		
		System.out.print((canRun) ? 1 : 0);
	}
}
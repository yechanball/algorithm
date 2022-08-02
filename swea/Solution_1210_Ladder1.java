package algorithm.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1210_Ladder1 {
	static int[][] ladder = new int[100][100];
	static int startIdx;
	
	static void findStart(int row, int col) {
		if(row == 0) {
			startIdx = col;
			return;
		}else {
			int left = col - 1;
			int right = col + 1;
			if( left >= 0 && ladder[row][left] == 1 ) {
				ladder[row][col] = 0;
				findStart(row, left);
			}else if( right < 100 && ladder[row][right] == 1 ) {
				ladder[row][col] = 0;
				findStart(row, right);
			}else {
				ladder[row][col] = 0;
				findStart(row-1, col);
			}
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int testcase, goalIdx = -1;
		StringTokenizer st;
		
		for (int tc = 0; tc < 10; tc++) {
			testcase = Integer.parseInt(in.readLine());
			sb.append("#").append(testcase).append(" ");
			// input data 배열에 저장
			for (int i = 0; i < 99; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				for (int j = 0; j < 100; j++) {
					ladder[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			st = new StringTokenizer(in.readLine(), " ");
			for (int i = 0; i < 100; i++) {
				ladder[99][i] = Integer.parseInt(st.nextToken());
				if(ladder[99][i] == 2) goalIdx = i;
			}
			findStart(99, goalIdx);
			sb.append(startIdx).append("\n");
		}
		System.out.println(sb);
	}
}

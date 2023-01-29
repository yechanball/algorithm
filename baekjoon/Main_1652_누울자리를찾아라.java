package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1652_누울자리를찾아라 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine()), hor = 0, ver = 0;
		boolean[][] room = new boolean[N+1][N+1];
		
		for (int i = 0; i < N; i++) {
			String input = in.readLine() + "X";
			for (int j = 0; j < N; j++) {
				if(input.charAt(j) == '.') room[i][j] = true;
			}
		}
		
		for (int i = 0; i < N; i++) {
			int hCnt = 0, vCnt = 0;
			for (int j = 0; j <= N; j++) {
				if(room[i][j]) hCnt++;
				else {
					if(hCnt >= 2) {
						hor++;
					}
					hCnt = 0;
				}
				if(room[j][i]) vCnt++;
				else {
					if(vCnt >= 2) {
						ver++;
					}
					vCnt = 0;
				}
			}
		}
		
		System.out.print(hor + " " + ver);
	}
}

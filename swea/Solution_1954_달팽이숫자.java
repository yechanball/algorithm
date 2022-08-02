package algorithm.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_1954_달팽이숫자 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		for (int testcase = 1; testcase <= T; testcase++) {
			sb.append("#").append(testcase).append("\n");
			int N = Integer.parseInt(in.readLine());
			int[][] snail = new int[N][N];
			// 탐색 우선 순위 우 하 좌 상
			int[] dr = {0, 1, 0, -1};
			int[] dc = {1, 0, -1, 0};
			
			// 기준 좌표
			int row = 0;
			int col = 0;
			
			// 현재 진행 중인 배열 좌표
			int nr;
			int nc;
			
			// 자리에 들어갈 숫자
			int num = 1;
			int preD = 0;
			
			while(num <= N*N) {
				snail[row][col] = num;
				// 이전에 진행 방향이 있었다면 우선 탐색
				nr = row+dr[preD];
				nc = col+dc[preD];
				if(nr >= 0 && nr < N && nc >= 0 && nc < N && snail[nr][nc] == 0) {
					row = nr;
					col = nc;
					num++;
					continue;
				}else { // 이전 진행 방향이 없다면 우 하 좌 상 순으로 탐색
					for (int i = 0; i < 4; i++) {
						nr = row + dr[i];
						nc = col + dc[i];
						if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
						else if(snail[nr][nc] == 0) {
							row = nr;
							col = nc;
							preD = i;
							break;
						}
					}
					num++;					
				}
				
			}
			
			for (int i = 0; i < snail.length; i++) {
				for (int j = 0; j < snail.length; j++) {
					sb.append(snail[i][j]).append(" ");
				}
				sb.append("\n");
			}
		}
		System.out.print(sb);
	}
}

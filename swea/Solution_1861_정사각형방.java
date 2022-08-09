package algorithm.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1861_정사각형방 {
	static int[][] room;
	static int[] dr = {-1, 1, 0, 0}; // 상하좌우 방향
	static int[] dc = {0, 0, -1, 1};
	static int N, roomNum, cnt, maxCnt, nr, nc;
	
	public static void search(int row, int col) {
		for (int i = 0; i < 4; i++) {
			nr = row + dr[i];
			nc = col + dc[i];
			if(nr < 0 || nr >= N || nc < 0 || nc >= N ) continue; // 범위 벗어난 경우
			else if(room[nr][nc] - room[row][col] == 1) { // 다음 방이 현재 방보다 1 크면 이동
				cnt++;
				search(nr, nc);
			}
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			N = Integer.parseInt(in.readLine());
			room = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				for (int j = 0; j < N; j++) {
					room[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			roomNum = 0;
			maxCnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					cnt = 1;
					search(i, j); // 이동 칸수 구하기
					if(cnt > maxCnt) { // 최대 이동 칸수 갱신
						roomNum = room[i][j];
						maxCnt = cnt;
					}else if(cnt == maxCnt) { // 최대 이동 칸수 같을때 작은 방번호 선택
						roomNum = (room[i][j] < roomNum)? room[i][j] : roomNum;
					}
				}
			}
			sb.append(roomNum).append(" ").append(maxCnt).append("\n");
		}
		System.out.print(sb);
	}
}

package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_17144_미세먼지안녕 {	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int R = Integer.parseInt(st.nextToken()); // 행
		int C = Integer.parseInt(st.nextToken()); // 열
		int T = Integer.parseInt(st.nextToken()); // 시간
		int[][] room = new int[R][C]; // 방
		int[] airCleaner = new int[2]; // 공기청정기 위치
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			room[i][0] = Integer.parseInt(st.nextToken());
			if(room[i][0] == -1 && airCleaner[0] == 0) { // 공기청정기인 경우 위치 저장
				airCleaner[0] = i;
				airCleaner[1] = i+1;				
			}
			for (int j = 1; j < C; j++) {
				room[i][j] = Integer.parseInt(st.nextToken());				
			}
		}
		
		// 먼지 이동
		int[] dr = {-1,1,0,0}; // 상,하,좌,우
		int[] dc = {0,0,-1,1};
		Deque<int[]> q = new ArrayDeque<int[]>(); // 확산된 먼지 {행, 열, 먼지 양}
		
		for (int time = 0; time < T; time++) { // T초 동안 이동
			// 먼지가 있는 지점 탐색
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if(room[i][j] >= 5) { // 확산될 먼지가 있다면(5이상)
						int nr, nc; // 인접 위치 좌표
						int spreadDust = room[i][j]/5; // 확산되는 먼지 양
						for (int k = 0; k < 4; k++) {
							nr = i + dr[k];
							nc = j + dc[k];
							
							if(nr < 0 || nr >= R || nc < 0 || nc >= C || room[nr][nc] == -1)
								continue; // 범위를 벗어나거나 공기청정기가 있는 경우 패쓰!
							
							q.offer(new int[] {nr, nc, spreadDust}); // 확산되는 먼지 큐에 저장
							room[i][j] -= spreadDust; // 확산되는 먼지만큼 원래 먼지 줄이기
						}
					}
				}
			}
			
			// 먼지 확산시키기
			while(!q.isEmpty()) {
				int[] dust = q.poll();
				room[dust[0]][dust[1]] += dust[2];
			}
			
			// 공기청정기 작동시키기
			// 윗 공기청정기 반시계방향
			int airRow = airCleaner[0];
			for (int i = airRow-1; i > 0; i--) room[i][0] = room[i-1][0]; // 좌측 열 아래로
			for (int i = 0; i < C-1; i++) room[0][i] = room[0][i+1]; // 상단 행 왼쪽으로
			for (int i = 0; i < airRow; i++) room[i][C-1] = room[i+1][C-1]; // 우측 열 위로
			for (int i = C-1; i > 1; i--) room[airRow][i] = room[airRow][i-1]; // 하단 행 오른쪽으로
			room[airRow][1] = 0;
			
			// 아랫 공기청정기 시계방향
			airRow = airCleaner[1];
			for (int i = airRow+1; i < R-1; i++) room[i][0] = room[i+1][0]; // 좌측 열 위로
			for (int i = 0; i < C-1; i++) room[R-1][i] = room[R-1][i+1]; // 하단 행 왼쪽으로
			for (int i = R-1; i > airRow; i--) room[i][C-1] = room[i-1][C-1]; // 우측 열 아래로
			for (int i = C-1; i > 1; i--) room[airRow][i] = room[airRow][i-1]; // 상단 행 오른쪽으로
			room[airRow][1] = 0;
		}
		
		// 방 안의 먼지량 확인
		int totalDust = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(room[i][j] == -1) continue;
				totalDust += room[i][j];
			}
		}
		
		// 출력
		out.write(Integer.toString(totalDust));
		out.flush();
		out.close();
	}
}

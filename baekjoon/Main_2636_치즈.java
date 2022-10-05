package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_2636_치즈 {
	static int R, C; // 행, 열 크기
	static int time = 0; // 소요 시간
	static int remain = 0; // 남은 치즈 조각
	static int lastRemain = 0; // 직전 남은 치즈 조각
	static Deque<int[]> air = new ArrayDeque<int[]>();
	static Deque<int[]> sideCheese = new ArrayDeque<int[]>(); // 테두리 치즈
	static int[][] board; // 주어진 판
	static boolean[][] visited; // 방문 배열
	static int[] dr = new int[] {-1, 1, 0, 0};
	static int[] dc = new int[] {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
	
		board = new int[R][C];
		visited = new boolean[R][C];
		
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < C; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if(board[i][j] == 1) { // 남은 치즈 조각 카운트
					remain++;
				}
			}
		}
		
		air.add(new int[] {0, 0});
		board[0][0] = 2;
		visited[0][0] = true;
		bfs();
		
		out.write(Integer.toString(time));
		out.append("\n");
		out.append(Integer.toString(lastRemain));
		out.flush();
		out.close();
	}
	
	private static void bfs() {	
		while(!air.isEmpty()) { // 공기 범위 확장
			int[] curr = air.poll();
	
			for (int i = 0; i < 4; i++) { 
				int nr = curr[0] + dr[i];
				int nc = curr[1] + dc[i];
				
				if(nr < 0 || nr >= R || nc < 0 || nc >= C || visited[nr][nc]) {
					continue;
				}
				
				if(board[nr][nc] == 0) { // 확인한 공기 영역은 체크
					air.offer(new int[] {nr, nc});
					board[nr][nc] = 2;
					visited[nr][nc] = true;
				}
				
				if(board[nr][nc] == 1) { // 공기와 맞닿아있는 치즈 조각 추가
					sideCheese.offer(new int[] {nr, nc});
				}
			}
		}
		
		lastRemain = remain; // 치즈 조각 삭제 전 마지막 남은 개수 저장
		while(!sideCheese.isEmpty()) { // 테두리 치즈 조각 삭제
			int[] curr = sideCheese.poll();
			if(board[curr[0]][curr[1]] != 0) {
				board[curr[0]][curr[1]] = 0;
				remain--;				
				air.offer(curr);
			}
		}
		time++;

		if(remain == 0) { // 남은 치즈 조각이 없는 경우 종료
			return;
		}else {
			if(!air.isEmpty()) {
				int[] next = air.peekFirst();			
				board[next[0]][next[1]] = 2;
				visited[next[0]][next[1]] = true;				
			}
			bfs(); // 재귀 호출
		}
	}
}

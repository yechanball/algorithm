package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_2638_치즈 {
	static class Pos {
		int r;
		int c;
		
		public Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	static int N, M; // 행, 열 크기
	static int time = 0; // 소요 시간
	static int remain = 0; // 남은 치즈 조각
	static Deque<Pos> air = new ArrayDeque<Pos>();
	static Deque<Pos> sideCheese = new ArrayDeque<Pos>(); // 테두리 치즈
	static int[][] board; // 주어진 판
	static int[][] visited; // 방문 배열
	static int[] dr = new int[] {-1, 1, 0, 0};
	static int[] dc = new int[] {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
	
		board = new int[N][M];
		visited = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if(board[i][j] == 1) remain++;
			}
		}
		
		air.add(new Pos(0, 0));
		board[0][0] = 2;
		visited[0][0]++;
		bfs();
		
		out.write(Integer.toString(time));
		out.flush();
		out.close();
	}
	
	public static void bfs() {	
		while(!air.isEmpty()) { // 공기 범위 확장
			Pos curr = air.poll();
	
			for (int i = 0; i < 4; i++) { 
				int nr = curr.r + dr[i];
				int nc = curr.c + dc[i];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
				
				if(board[nr][nc] == 0 && visited[nr][nc] == 0) { // 확인한 공기 영역은 체크
					air.offer(new Pos(nr, nc));
					board[nr][nc] = 2;
					visited[nr][nc]++;
				}
				
				if(board[nr][nc] == 1) { // 공기와 맞닿아있는 치즈 확인
					visited[nr][nc]++;
					if(visited[nr][nc] >= 2) sideCheese.offer(new Pos(nr, nc)); // 공기와 2면 이상 접촉되어 있는 경우 추가
				}
			}
		}
		
		while(!sideCheese.isEmpty()) { // 공기와 맞닿아있는 치즈 제거
			Pos curr = sideCheese.poll();
			if(board[curr.r][curr.c] != 0) {
				board[curr.r][curr.c] = 0;				
				remain--;				
				air.offer(curr);
			}
		}
		time++;
		
		if(remain == 0) { // 남은 치즈 조각이 없는 경우 종료
			return;
		}else {
			if(!air.isEmpty()) {
				Pos next = air.peekFirst();			
				board[next.r][next.c] = 2;
				visited[next.r][next.c]++;				
			}
			bfs();
		}
	}
}
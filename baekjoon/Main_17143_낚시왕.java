package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

class Shark {
	int r; // 행
	int c; // 열
	int s; // 속도
	int d; // 방향
	int z; // 크기
	
	public Shark(int r, int c, int s, int d, int z) {
		this.r = r;
		this.c = c;
		this.s = s;
		this.d = d;
		this.z = z;
	}
}
public class Main_17143_낚시왕 {
	static int R, C, M; // R:행, C:열, M:상어의 수
	static int sharkSum = 0; // 잡은 상어의 크기 합
	static Shark[][] board; // 주어진 격자판
	static int[] dr = new int[] {0, -1, 1, 0, 0}; // 1:상, 2:하, 3:우, 4:좌
	static int[] dc = new int[] {0, 0, 0, 1, -1};
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		board = new Shark[R+1][C+1];
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int row = Integer.parseInt(st.nextToken());
			int col = Integer.parseInt(st.nextToken());
			int speed = Integer.parseInt(st.nextToken());
			int direction = Integer.parseInt(st.nextToken());
			int size = Integer.parseInt(st.nextToken());
			board[row][col] = new Shark(row, col, speed, direction, size);
		}

		goFish(1);
		
		out.write(Integer.toString(sharkSum));
		out.flush();
		out.close();
	}

	private static void goFish(int cnt) {
		if(cnt == C+1) { // 낚시왕이 끝까지 이동한 경우
			return; // 종료
		}

		for (int i = 1; i <= R; i++) { // 낚시왕이 있는 열에서 가장 가까운 상어 잡기
			if(board[i][cnt] != null) {
				sharkSum += board[i][cnt].z;
				board[i][cnt] = null;
				break;
			}
		}
		
		moveShark(); // 상어 이동
		
		goFish(cnt+1); // 재귀 호출
	}
	
	private static void moveShark() { 
		Deque<Shark> q = new ArrayDeque<Shark>();
		
		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				if(board[i][j] != null) { // 상어가 있는 경우
					q.offer(board[i][j]);
					board[i][j] = null; // 격자판에서 상어 지우기					
				}
			}
		}
		
		while(!q.isEmpty()) {
			Shark shark = q.poll();
			int row = shark.r;
			int col = shark.c;
			int speed = shark.s;
			int direction = shark.d;
			
			// 각 방향에 맞추어 왕복인 경우 스피드 줄이기
			if(direction == 1 && direction == 2) {
				speed %= (R-1)*2;				
			}
			if(direction == 3 && direction == 4) {
				speed %= (C-1)*2;				
			}
			
			// 끝에 있는 경우 방향 고려하기
			if(direction == 1 && row == R) {
				direction = 2;
			}
			if(direction == 2 && row == 1) {
				direction = 1;
			}
			if(direction == 3 && col == 1) {
				direction = 4;
			}
			if(direction == 4 && col == C) {
				direction = 3;
			}
			
			// 상어 이동
			for (int j = 0; j < speed ; j++) {
				int nr = row + dr[direction];
				int nc = col + dc[direction];
				
				if(nr <= 0 || nr > R || nc <= 0 || nc > C) { // 격자판 넘는 경우 방향 바꾸기
					if(direction >= 3) {
						direction = (direction == 3) ? 4 : 3;
					}else {
						direction = (direction == 1) ? 2 : 1;						
					}
				}
				
				row += dr[direction];
				col += dc[direction];
			}
			
			shark.r = row;
			shark.c = col;
			shark.d = direction;
			
			if(board[row][col] == null) { // 비어있는 칸인 경우
				board[row][col] = shark;
			}else { // 이미 상어가 존재하는 경우
				if(shark.z > board[row][col].z) { // 새로운 상어가 기존 상어보다 큰 경우 -> 갱신
					board[row][col] = shark;
				}
			}
		}
	}
}

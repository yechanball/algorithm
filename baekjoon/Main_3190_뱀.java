package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_3190_뱀 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(in.readLine()); // 보드 크기
		int K = Integer.parseInt(in.readLine()); // 사과 개수
		int[][] board = new int[N+1][N+1]; // 보드, 0: 빈칸, 1: 사과, 2: 뱀
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			board[r][c] = 1;
		}
		
		int[] dr = {0,1,0,-1}; // 우하좌상
		int[] dc = {1,0,-1,0};
		
		Deque<int[]> snake = new ArrayDeque<int[]>();
		snake.offer(new int[] {1, 1});
		board[1][1] = 2;
		int size = 1; // 뱀 사이즈
		int direct = 0; // 초기 방향 오른쪽
		int time = 0; // 게임 시간
		boolean isFinish = false; // 종료 확인
		
		int L = Integer.parseInt(in.readLine());
		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int X = Integer.parseInt(st.nextToken());
			char C = st.nextToken().charAt(0);
						
			while(time < X) { // X만큼 이동
				int[] head = snake.peek(); // 뱀 머리 이동
				int nr = head[0] + dr[direct];
				int nc = head[1] + dc[direct];
				
				if(nr <= 0 || nr > N || nc <= 0 || nc > N || board[nr][nc] == 2) { // 벽 또는 자기 몸과 충돌하는 경우
					isFinish = true;
					time++;
					break;
				}
				
				if(board[nr][nc] == 1) { // 사과가 있는 경우
					board[nr][nc] = 0;
					size++;
				}else {
					int[] tail = snake.pollLast(); // 뱀 꼬리 삭제
					board[tail[0]][tail[1]] = 0;
				}
				snake.offerFirst(new int[] {nr, nc}); // 뱀 머리 추가
				board[nr][nc] = 2;
				time++;
			}
			
			if(isFinish) break; // 충돌한 경우 종료
			
			if(C == 'L') { // 왼쪽으로 회전하는 경우
				if (--direct < 0) direct = 3;
			}else { // 오른쪽으로 회전하는 경우
				if (++direct > 3) direct = 0;
			}
		}

		while(!isFinish) { // 아직 끝나지 않았다면 끝날때까지 이동
			int[] head = snake.peek(); // 뱀 머리 이동
			int nr = head[0] + dr[direct];
			int nc = head[1] + dc[direct];
			
			if(nr <= 0 || nr > N || nc <= 0 || nc > N || board[nr][nc] == 2) { // 벽 또는 자기 몸과 충돌하는 경우
				isFinish = true;
				time++;
				break;
			}
			
			if(board[nr][nc] == 1) { // 사과가 있는 경우
				board[nr][nc] = 0;
				size++;
			}else {
				int[] tail = snake.pollLast(); // 뱀 꼬리 삭제
				board[tail[0]][tail[1]] = 0;
			}
			snake.offerFirst(new int[] {nr, nc}); // 뱀 머리 추가
			board[nr][nc] = 2;
			time++;
		}
		
		System.out.print(time);
	}
}

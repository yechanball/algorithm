package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_14503_로봇청소기 {
	static int N, M; // N: 세로 크기, M: 가로 크기
	static int cleanCnt = 0; // 청소할 수 있는 칸의 수	
	static int[][] room; // 주어진 방 조건
	static boolean[][] visited; // 로봇청소기 방문 기록
	static int[] robot; // 로봇의 위치 0: row, 1: col, 2: 방향
	static int[] dr = {-1, 0, 1, 0}; // 북, 동, 남, 서
	static int[] dc = {0, 1, 0, -1}; // 북, 동, 남, 서	
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		room = new int[N][M];
		visited = new boolean[N][M];
		
		st = new StringTokenizer(in.readLine(), " ");
		robot = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())}; // 로봇의 시작 위치 입력
		for (int i = 0; i < N; i++) { // 방 정보 입력
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < M; j++) {
				room[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		cleanRoom(); // 방 청소 시작
		
		out.write(Integer.toString(cleanCnt));
		out.flush();
		out.close();
	}

	private static void cleanRoom() {
		int nr, nc, nextD, backD;
		int r = robot[0];
		int c = robot[1];
		int d = robot[2];
		
		if(!visited[r][c]) { // 1번 작동 진행 -> 방문하지 않은 곳이면 청소하기
			cleanCnt++; // 현재 위치 청소
			visited[r][c] = true; // 방문 체크
		}
		
		// 2-1, 2-2번 작동 진행 -> 반시계방향으로 청소/이동 공간 찾기
		nextD = (d-1 < 0) ? 3 : (d-1); // 로봇이 바라보고 있는 방향의 왼쪽 방향
		for(int i = 0; i < 4; i++) {
			nr = r + dr[nextD];
			nc = c + dc[nextD];
			if(room[nr][nc] == 0 && !visited[nr][nc]) { // 청소하지 않은 빈공간이 있는 경우
				robot[0] = nr;
				robot[1] = nc;
				robot[2] = nextD;
				cleanRoom(); // 재귀 호출
				return;
			}
			nextD = (nextD-1 < 0) ? 3 : (nextD-1); // 왼쪽으로 바라본 로봇의 왼쪽 방향
		}			

		
		// 2-3번 작동 진행 -> 후진하기
		backD = (d+2 > 3) ? (d-2) : (d+2); // 로봇이 바라보고 있는 방향의 반대 방향(뒤 방향)
		nr = r + dr[backD];
		nc = c + dc[backD];
		
		if(room[nr][nc] == 0) { // 후진할 수 있는 공간이 있다면
			robot[0] = nr;
			robot[1] = nc;
			cleanRoom(); // 재귀 호출
			return;
		}
		
		// 2-4번 작동 진행 -> 위 작동이 전부 불가한 경우 작동 종료
		return;
	}
}

package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_17086_아기상어2 {
	static int N, M;
	static int[][] space; // 상어 배열
	static int[][] distance; // 안전 거리 배열
	// 탐색 방향 => 상,우상,우,우하,하,좌하,좌,좌상
	static int[] dr = {-1,-1,0,1,1,1,0,-1};
	static int[] dc = {0,1,1,1,0,-1,-1,-1};
	
	// 방향 탐색
	public static void check(int row, int col, int direction, int cnt) {
		int nr = row + dr[direction];
		int nc = col + dc[direction];
		if(nr < 0 || nr >= N || nc < 0 || nc >= M || space[nr][nc] == 1) return; // 범위 벗어난 경우, 경로에 다른 상어가 있는 경우 -> 재귀 종료
		else {
			if(distance[nr][nc] == 0 || distance[nr][nc] > cnt) {
				distance[nr][nc] = cnt; // 거리가 없거나 기존 거리가 새로운 거리보다 큰 경우 갱신 				
			}
			check(nr, nc, direction, cnt+1); // 진행방향에 맞추어 다음 경로 확인하기 -> 재귀 호출
		}
	}
	
	public static void printArr() {
		System.out.println("-------------------");
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(distance[i][j]+" ");
			}
			System.out.println();
		}		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		space = new int[N][M];
		distance = new int[N][M];		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < M; j++) {
				space[i][j] = Integer.parseInt(st.nextToken()); // 아기 상어: 1, 비어있는곳: 0
			}
		}
		// 탐색 시작
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(space[i][j] == 1) { // 아기 상어가 있는 경우
					for (int d = 0; d < 8; d++) { // 아기 상어 기준 팔방탐색
						check(i, j, d, 1); // 진행방향에 맞추어 다음 경로 확인하기 -> 재귀 호출
					}
					printArr();
				}
			}
		}
		int max = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(distance[i][j] > max) max = distance[i][j]; // 최대 안전 거리 갱신
			}
		}
		out.write(Integer.toString(max));
		out.flush();
		out.close();
	}
}

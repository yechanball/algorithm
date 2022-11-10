package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main_1941_소문난칠공주 {
	static final int N = 5, size = 25; // 5x5 배열 크기
	static int sevenCnt = 0; // 경우의 수
	static char[][] map = new char[N][N]; // 5x5 배열
	static boolean[] select = new boolean[size]; // 조합으로 선택한 목록
	static int[] dr = {-1, 1, 0, 0}; // 상하좌우
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 0; i < N; i++) {
			String input = in.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = input.charAt(j);
			}
		}
		
		combi(0, 0, 0); // 조합 생성
		
		System.out.print(sevenCnt);
	}
	
	public static int changePos(int r, int c) { // 2차원 좌표를 1차원 좌표로 변환
		return r * N + c;
	}
	
	public static char posValue(int pos) { // 좌표에 해당하는 값 반환
		return map[pos/N][pos%N];
	}
	
	public static void combi(int cnt, int start, int yCnt) { // 조합 생성
		if(yCnt > 3) return; // Y가 3개 초과하여 선택한 경우 -> 종료
		
		if(cnt == 7) { // 7명을 전부 고른 경우
			if(bfs(start-1)) { // 7명이 모두 이웃한지 확인
				sevenCnt++;
			}
			return;
		}
		
		for (int i = start; i < size; i++) {
			select[i] = true;
			if(posValue(i) == 'Y') {
				combi(cnt+1, i+1, yCnt+1);
			}else {
				combi(cnt+1, i+1, yCnt);				
			}
			select[i] = false;
		}
	}
	
	private static boolean bfs(int start) { // 너비 우선 탐색
		int cnt = 0;
		
		Deque<Integer> q = new ArrayDeque<Integer>();
		q.offer(start);
		
		boolean[] visited = new boolean[size];
		visited[start] = true;
		cnt++;
		
		while (!q.isEmpty()) {
			int now = q.poll();

			for (int i = 0; i < 4; i++) {
				int nr = now/N + dr[i];
				int nc = now%N + dc[i];
				int next = changePos(nr, nc);
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= N) // 배열을 벗어난 경우
					continue;
				
				if(select[next] && !visited[next]) { // 조합으로 선택하고 방문하지 않은 경우 -> 탐색
					q.offer(next);
					cnt++;
					visited[next] = true;
				}
			}
			
			if(cnt == 7) { // 7명이 전부 탐색되었다면 종료
				return true;				
			}
		}
		
		return false;
	}
}

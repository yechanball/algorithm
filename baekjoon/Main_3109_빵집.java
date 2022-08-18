package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_3109_빵집 {
	static int R, C; // 행, 열 크기
	static boolean[][] visited; // 방문 확인 배열
	static boolean isPipeline; // 파이프라인 완성되었는지 확인
	static int maxPipeline = 0; // 파이프라인의 최대 개수
	// 탐색 방향 0:좌상, 1:좌, 2:좌하
	static int[] dr = {-1, 0, 1};
	static int[] dc = {-1, -1, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		char[][] map = new char[R][C]; // 근처 모습을 저장할 배열
		visited = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			String input = in.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = input.charAt(j);
				if(map[i][j] == 'x') visited[i][j] = true;
			}
		}
		
		for (int i = 0; i < R; i++) {
			isPipeline = false;
			setPipeline(i, C-1); // 파이프라인 찾기
		}
		
		out.write(Integer.toString(maxPipeline));
		out.flush();
		out.close();
	}
	
	public static void setPipeline(int row, int col) { // 파이프라인 수 찾기 메서드
		if(visited[row][col]) return; // 이미 방문한 곳이면 재귀 종료
		visited[row][col] = true; // 방문처리
		if(col == 0) { // 가스관에 도달한 경우 종료
			isPipeline = true;
			maxPipeline++;
			return;
		}
		for (int d = 0; d < 3; d++) { // 3가지 방향 탐색
			// 탐색 위치
			int nr = row + dr[d];
			int nc = col + dc[d];
			
			if(nr < 0 || nr >= R) continue; // 범위를 벗어난 경우
			setPipeline(nr, nc); // 다음 탐색 시작 -> 재귀 호출
			if(isPipeline) return; // (재귀 끝나고 돌아왔을때)이미 파이프라인을 완성한 경우 종료
		}
	}
}

package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_3109_빵집 {
	static int R, C; // 행, 열 크기
	static boolean[][] visited; // 방문 확인 배열
	static boolean[][] checkVisited; // 방문 확인된 배열
	static boolean isPipeline; // 파이프라인 완성되었는지 확인
	static int maxPipeline = Integer.MIN_VALUE; // 파이프라인의 최대 개수
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
		checkVisited = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			String input = in.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = input.charAt(j);
				if(map[i][j] == 'x') visited[i][j] = true;
			}
		}
		
		setPipeline(0); // 파이프라인 찾기
		
		out.write(Integer.toString(maxPipeline));
		out.flush();
		out.close();
	}
	
	public static void setPipeline(int pipeline) { // 파이프라인 수 찾기 메서드
		for (int i = 0; i < R; i++) {
			isPipeline = false;
			findLine(0, i, C-1); // 가스관까지 라인 탐색
			if(isPipeline) {
				copyVisit(checkVisited, visited); // 완성된 경로로 교체
				pipeline++;
			}
//			System.out.println("---"+i+"에서 출발! -> 개수: "+pipeline);
//			printVisit();
		}
		maxPipeline = (pipeline > maxPipeline) ? pipeline : maxPipeline; // 파이프라인 최댓값 비교
		return;
	}
	
	public static void findLine(int cnt, int row, int col) { // 선택된 빵집에서 가스관까지 연결하는 메서드
		if(isPipeline) { // 이미 파이프라인을 완성한 경우 종료
			return;
		}else if(cnt == C-1) {
			isPipeline = true;
			copyVisit(visited, checkVisited); // 완성된 경로 백업
			return;
		}else {
			for (int d = 0; d < 3; d++) { // 3가지 방향 탐색
				// 탐색 위치
				int nr = row + dr[d];
				int nc = col + dc[d];
				
				if(nr < 0 || nr >= R || nc < 0 || nc >= C || visited[nr][nc])
					continue; // 범위를 벗어나거나 이미 방문한 곳이면 재귀 종료
				else { // 방문 처리하고 다음 탐색 시작
					visited[nr][nc] = true;
					findLine(cnt+1, nr, nc);
					visited[nr][nc] = false;
				}
			}
		}
	}
	
	public static void copyVisit(boolean[][] origin, boolean[][] copy) { // 방문 배열 복사 메서드
		for (int i = 0; i < R; i++) {
			copy[i] = Arrays.copyOf(origin[i], C);
		}
	}
	
//	public static void printVisit() { // 방문 배열 출력 메서드
//		System.out.println("------------------");
//		for (int i = 0; i < R; i++) {
//			for (int j = 0; j < C; j++) {
//				int n = (visited[i][j]) ? 1 : 0;
//				System.out.print(n);
//			}
//			System.out.println();
//		}
//	}
}

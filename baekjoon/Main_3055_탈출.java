package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main_3055_탈출 {
	static char[][] map; // 지도
	static int[][] visited; // 물 확장 기록 배열
	static int[][] visitedD; // 고슴도치 방문 기록 배열
	static int R, C; // 행, 열 크기
	static int[] dochi; // 고슴도치의 위치 {r, c}
	static int[] cave; // 비버의 굴의 위치 {r, c}
	static List<int[]> water = new ArrayList<int[]>(); // 물이 차있는 위치 {r, c}
	static int fastTime; // 고슴도치가 빠르게 도착할 수 있는 시간
	static boolean canArrive = false; // 고슴도치가 비버의 굴에 도착할 수 있는지 여부
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			String input = in.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = input.charAt(j);
				if(map[i][j] == '.') {
					continue;
				}else if(map[i][j] == 'S') {
					dochi = new int[] {i, j};
				}else if(map[i][j] == 'D') {
					cave = new int[] {i, j};
				}else if(map[i][j] == '*'){
					water.add(new int[] {i, j});					
				}
			}
		}
		
		visited = new int[R][C];
		if(!water.isEmpty()) bfsWater(); // 물 확장 시작
		
		visitedD = new int[R][C];
		bfsDochi(); // 고슴도치 탐색 시작
		
		out.write((canArrive) ? Integer.toString(fastTime) : "KAKTUS");
		out.flush();
		out.close();
	}
	
	public static void bfsWater() {
		int[] dr = {-1,1,0,0}; // 상하좌우
		int[] dc = {0,0,-1,1};
		
		Deque<int[]> q = new ArrayDeque<int[]>();
		
		for (int i = 0, size = water.size(); i < size; i++) { // 초기에 물이 주어질때 큐에 우선적으로 넣기
			q.offer(new int[] {water.get(i)[0], water.get(i)[1], 1}); // (0, 1): 좌표, 2: 소요 시간
			visited[water.get(i)[0]][water.get(i)[1]] = 1;
		}
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			
			for (int i = 0; i < 4; i++) { // 매시간 물 인접 칸 확장
				int nr = curr[0]+dr[i];
				int nc = curr[1]+dc[i];
				
				if(nr < 0 || nr >= R || nc < 0 || nc >= C || map[nr][nc] == 'D' || map[nr][nc] == 'X' || visited[nr][nc] != 0)
					continue;
				
				q.offer(new int[] {nr, nc, curr[2]+1});
				visited[nr][nc] = curr[2]+1;
			}
		}
	}
	
	public static void bfsDochi() {
		int[] dr = {-1,1,0,0}; // 상하좌우
		int[] dc = {0,0,-1,1};
		
		Deque<int[]> q = new ArrayDeque<int[]>();
		q.offer(new int[] {dochi[0], dochi[1], 1});		
		visitedD[dochi[0]][dochi[1]] = 1;
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int currTime = curr[2];
				
			for (int i = 0; i < 4; i++) { // 고슴도치 인접 칸 탐색
				int nr = curr[0]+dr[i];
				int nc = curr[1]+dc[i];
				
				if(nr < 0 || nr >= R || nc < 0 || nc >= C )
					continue;
				
				if(map[nr][nc] == 'D') { // 다음이 비버의 굴이라면 저장하고 종료
					fastTime = currTime;
					canArrive = true;
					return;
				}
				
				if((visited[nr][nc] != 0 && visited[nr][nc] <= currTime+1) || map[nr][nc] == 'X' || visitedD[nr][nc] != 0)
					continue;
				
				q.offer(new int[] {nr, nc, currTime+1});
				visitedD[nr][nc] = currTime+1;
			}				
		}
	}
}

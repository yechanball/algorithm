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

public class Main_4179_불 {
	static char[][] maze; // 미로
	static int[][] visited; // 불 확장 기록 배열
	static int[][] visitedJ; // 지훈 방문 기록 배열
	static int R, C; // 행, 열 크기
	static int[] jihun; // 지훈의 위치 {r, c}
	static List<int[]> fire = new ArrayList<int[]>(); // 불이 있는 위치 {r, c}
	static int fastTime; // 지훈이가 빠르게 탈출할 수 있는 시간
	static boolean canEscape = false; // 지훈이 탈출할 수 있는지 여부
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		maze = new char[R][C];
		for (int i = 0; i < R; i++) {
			String input = in.readLine();
			for (int j = 0; j < C; j++) {
				maze[i][j] = input.charAt(j);
				if(maze[i][j] == 'J') {
					jihun = new int[] {i, j};
				}else if(maze[i][j] == 'F'){
					fire.add(new int[] {i, j});					
				}
			}
		}
		
		visited = new int[R][C];
		if(!fire.isEmpty()) bfsWater(); // 불 확장 시작
		
		visitedJ = new int[R][C];
		bfsJihun(); // 지훈 탐색 시작
		
		out.write((canEscape) ? Integer.toString(fastTime) : "IMPOSSIBLE");
		out.flush();
		out.close();
	}
	
	public static void bfsWater() {
		int[] dr = {-1,1,0,0}; // 상하좌우
		int[] dc = {0,0,-1,1};
		
		Deque<int[]> q = new ArrayDeque<int[]>();
		
		for (int i = 0, size = fire.size(); i < size; i++) { // 초기에 불이 주어질때 큐에 우선적으로 넣기
			q.offer(new int[] {fire.get(i)[0], fire.get(i)[1], 1}); // (0, 1): 좌표, 2: 소요 시간
			visited[fire.get(i)[0]][fire.get(i)[1]] = 1;
		}
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			
			for (int i = 0; i < 4; i++) { // 매시간 불 인접 칸 확장
				int nr = curr[0]+dr[i];
				int nc = curr[1]+dc[i];
				
				if(nr < 0 || nr >= R || nc < 0 || nc >= C || maze[nr][nc] == '#' || visited[nr][nc] != 0)
					continue;
				
				q.offer(new int[] {nr, nc, curr[2]+1});
				visited[nr][nc] = curr[2]+1;
			}
		}
	}
	
	public static void bfsJihun() {
		int[] dr = {-1,1,0,0}; // 상하좌우
		int[] dc = {0,0,-1,1};
		
		Deque<int[]> q = new ArrayDeque<int[]>();
		q.offer(new int[] {jihun[0], jihun[1], 1});		
		visitedJ[jihun[0]][jihun[1]] = 1;
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int currTime = curr[2];
				
			for (int i = 0; i < 4; i++) { // 지훈 인접 칸 탐색
				int nr = curr[0]+dr[i];
				int nc = curr[1]+dc[i];
				
				if(nr < 0 || nr >= R || nc < 0 || nc >= C ) { // 다음이 미로 밖이라면 탈출하고 종료
					fastTime = currTime;
					canEscape = true;
					return;
				}
				
				if((visited[nr][nc] != 0 && visited[nr][nc] <= currTime+1) || maze[nr][nc] == '#' || visitedJ[nr][nc] != 0)
					continue;
				
				q.offer(new int[] {nr, nc, currTime+1});
				visitedJ[nr][nc] = currTime+1;
			}				
		}
	}
}

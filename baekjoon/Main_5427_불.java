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

public class Main_5427_불 {
	static char[][] maze; // 미로
	static int[][] visited; // 불 확장 기록 배열
	static int[][] visitedS; // 상근 방문 기록 배열
	static int R, C; // 행, 열 크기
	static int[] sangguen; // 상근의 위치 {r, c}
	static List<int[]> fire; // 불이 있는 위치 {r, c}
	static int fastTime; // 상근이가 빠르게 탈출할 수 있는 시간
	static boolean canEscape; // 상근이 탈출할 수 있는지 여부
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(in.readLine(), " ");
			C = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			
			maze = new char[R][C];
			fire = new ArrayList<int[]>();
			for (int i = 0; i < R; i++) {
				String input = in.readLine();
				for (int j = 0; j < C; j++) {
					maze[i][j] = input.charAt(j);
					if(maze[i][j] == '@') {
						sangguen = new int[] {i, j};
					}else if(maze[i][j] == '*'){
						fire.add(new int[] {i, j});					
					}
				}
			}
			
			canEscape = false;
			visited = new int[R][C];
			if(!fire.isEmpty()) bfsFire(); // 불 확장 시작
			
			visitedS = new int[R][C];
			bfsSangguen(); // 상근 탐색 시작
			
			sb.append((canEscape) ? Integer.toString(fastTime) : "IMPOSSIBLE").append("\n");
		}
		out.write(sb.toString());		
		out.flush();
		out.close();
	}
	
	public static void bfsFire() {
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
	
	public static void bfsSangguen() {
		int[] dr = {-1,1,0,0}; // 상하좌우
		int[] dc = {0,0,-1,1};
		
		Deque<int[]> q = new ArrayDeque<int[]>();
		q.offer(new int[] {sangguen[0], sangguen[1], 1});		
		visitedS[sangguen[0]][sangguen[1]] = 1;
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int currTime = curr[2];
				
			for (int i = 0; i < 4; i++) { // 상근 인접 칸 탐색
				int nr = curr[0]+dr[i];
				int nc = curr[1]+dc[i];
				
				if(nr < 0 || nr >= R || nc < 0 || nc >= C ) { // 다음이 미로 밖이라면 탈출하고 종료
					fastTime = currTime;
					canEscape = true;
					return;
				}
				
				if((visited[nr][nc] != 0 && visited[nr][nc] <= currTime+1) || maze[nr][nc] == '#' || visitedS[nr][nc] != 0)
					continue;
				
				q.offer(new int[] {nr, nc, currTime+1});
				visitedS[nr][nc] = currTime+1;
			}				
		}
	}
}

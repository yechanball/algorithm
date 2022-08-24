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

public class Main_17086_아기상어2 {
	static int N, M; // 행, 열 크기
	static int[][] map; // 공간 배열
	static int[][] visited; // 안전 거리 배열
	static List<int[]> shark = new ArrayList<int[]>(); // 상어 위치 리스트
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new int[N][M];		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken()); // 아기 상어: 1, 비어있는곳: 0
				if(map[i][j] == 1) {
					shark.add(new int[] {i,j}); // 상어 위치는 리스트에 저장
				}
			}
		}
		
		bfs(); // 탐색 시작
		
		int max = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(visited[i][j] > max) max = visited[i][j]; // 최대 안전 거리 갱신
			}
		}
		out.write(Integer.toString(max-1));
		out.flush();
		out.close();
	}
	
	public static void bfs() {
		// 탐색 방향 => 상,우상,우,우하,하,좌하,좌,좌상
		int[] dr = {-1,-1,0,1,1,1,0,-1};
		int[] dc = {0,1,1,1,0,-1,-1,-1};
		
		Deque<int[]> q = new ArrayDeque<int[]>();
		
		for (int i = 0, size = shark.size(); i < size; i++) { // 초기에 상어가 주어질때 큐에 우선적으로 넣기
			q.offer(new int[] {shark.get(i)[0], shark.get(i)[1], 1}); // (0, 1): 좌표, 2: 소요 시간
			visited[shark.get(i)[0]][shark.get(i)[1]] = 1;
		}
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			
			for (int i = 0; i < 8; i++) { // 팔방 거리 확장
				int nr = curr[0]+dr[i];
				int nc = curr[1]+dc[i];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= M || map[nr][nc] == 1 || visited[nr][nc] != 0)
					continue;
				
				q.offer(new int[] {nr, nc, curr[2]+1});
				visited[nr][nc] = curr[2]+1;
			}
		}
	}
}

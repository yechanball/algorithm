package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main_16236_아기상어 {
	static int N; // 공간의 크기
	static int[][] map; // 공간
	static boolean[][] visited; // 방문 체크
	static int[] shark; // 아기 상어 위치
	static int sharkSize = 2; // 아기 상어 크기
	static int eatCnt = 0;
	static int maxEatTime = 0; // 아기 상어가 먹을 수 있는 최대 시간
	static boolean callMom = false; // Help mommy!!! 엄마 상어에게 도움 요청 여부
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(in.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] != 0) {
					if(map[i][j] == 9) {
						shark = new int[] {i, j};
					}
				}
			}
		}
		
		while(!callMom) {
			visited = new boolean[N][N];
			bfs(); // 아기 상어: "사냥 시작하지! 응-애"			
		}
		
		out.write(Integer.toString(maxEatTime));
		out.flush();
		out.close();
	}
	
	public static void bfs() {
		int[] dr = {-1,0,0,1}; // 상좌우하
		int[] dc = {0,-1,1,0};
		
		Deque<int[]> q = new ArrayDeque<int[]>();
		q.offer(new int[] {shark[0], shark[1], 0}); // (0, 1): 좌표, 2: 소요 시간
		map[shark[0]][shark[1]] = 0;
		visited[shark[0]][shark[1]] = true;
				
		List<int[]> eatList = new ArrayList<int[]>();
		int time = -1;
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int currTime = curr[2];
			
			if(currTime == time) {
				break;
			}
			
			for (int i = 0; i < 4; i++) { // 아기 상어 인접 칸 탐색
				int nr = curr[0]+dr[i];
				int nc = curr[1]+dc[i];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= N || map[nr][nc] > sharkSize || visited[nr][nc])
					continue;
				
				if(map[nr][nc] != 0 && map[nr][nc] < sharkSize) { // 아기 상어가 먹을 수 있는 물고기를 만나면
					eatList.add(new int[] {nr, nc}); // 먹을 수 있는 물고기 리스트 저장	
					time = (currTime+1);
				}
				
				q.offer(new int[] {nr, nc, currTime+1});
				visited[nr][nc] = true;
			}
		}
		if(!eatList.isEmpty()) {
			Collections.sort(eatList, new Comparator<int[]>() { // 가장 위 행, 행이 같다면 왼쪽이 우선순위
				@Override
				public int compare(int[] s1, int[] s2) {
					return (s1[0] == s2[0]) ? s1[1]-s2[1] : s1[0]-s2[0];
				}
			});
			int[] fish = eatList.get(0);
			map[fish[0]][fish[1]] = 9;
			shark[0] = fish[0];
			shark[1] = fish[1];
			maxEatTime += time;
			eatCnt++;
			if(eatCnt == sharkSize) {
				sharkSize++;
				eatCnt = 0;
			}
//			printMap(); // 맵 출력
			return;					
		}
		
		callMom = true; // 엄마 어딨어?!!!!
	}
	
//	public static void printMap() {
//		System.out.println("--------------------");
//		System.out.println("현재 누적 시간 : "+maxEatTime+", 상어 크기: "+ sharkSize);
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				System.out.print(map[i][j]+" ");
//			}
//			System.out.println("");
//		}
//	}
}

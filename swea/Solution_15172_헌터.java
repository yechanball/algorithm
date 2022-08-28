package algorithm.swea;

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

public class Solution_15172_헌터 {
	static int N; // 행, 열 크기
	static int[][] map; // 맵
	static boolean[][] visited; // 헌터 방문 기록 배열
	static List<int[]> list; // 고객과 몬스터의 위치 리스트
	static int monsterCnt; // 몬스터 수
	static boolean[] killMonster; // 몬스터 처지 여부
	static int fastTime; // 헌터가 빠르게 완료할 수 있는 시간
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			N = Integer.parseInt(in.readLine());
			map = new int[N][N];
			list = new ArrayList<int[]>();
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] == 0) continue; // 빈칸인 경우
					else{ // 몬스터이거나 고객인 경우
						list.add(new int[] {i, j});			
					}
				}
			}
			
			visited = new boolean[N][N];
			monsterCnt = list.size()/2;
			killMonster = new boolean[monsterCnt+1];
			fastTime = Integer.MAX_VALUE;
			
			bfs(); // 사냥 시작
			
			sb.append(Integer.toString(fastTime)).append("\n");
		}
		
		out.write(sb.toString());
		out.flush();
		out.close();
	}
	
	public static void bfs() {	
		Deque<int[]> q = new ArrayDeque<int[]>();
		q.offer(new int[] {0, 0, 0});
		int time = 0;
		
		while(!q.isEmpty()) {
			int[] curr = q.poll(); // 헌터의 현재 위치
			int r = curr[0];
			int c = curr[1];
			time = curr[2];

			for (int[] next : list) {
				int nr = next[0];
				int nc = next[1];
				
				if(visited[nr][nc] || (map[nr][nc] < 0 && !killMonster[Math.abs(map[nr][nc])])) // 방문했던 곳이거나 고객인데 몬스터를 잡지 않고 간 경우
					continue;
				
				if(map[nr][nc] > 0) killMonster[map[nr][nc]] = true; // 몬스터를 잡은 경우 체크

				q.offer(new int[] {nr, nc, time+calcDist(r, c, nr, nc)});
				visited[nr][nc] = true;
			}
		}		
		fastTime = (time < fastTime) ? time : fastTime;
	}
	
	public static int calcDist(int r1, int c1, int r2, int c2) { // 거리 계산 메서드
		return Math.abs(r1-r2)+Math.abs(c1-c2);
	}
}

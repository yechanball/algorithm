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

public class Main_7569_토마토 {
	static int H, N, M; // H:판, N: 행, M: 열
	static int[][][] storage; // 토마토 보관 창고, 판 행 열
	static List<int[]> tomato = new ArrayList<int[]>(); // 초기에 주어진 익은 토마토 정보를 저장할 리스트
	static int[][][] visited; // 토마토 방문 기록 -> -1: 방문할 수 없는 곳, 0: 방문하지 않은 곳, 1 ~ 숫자: 방문하는데 걸린 시간
	static int minTime = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		storage = new int[H][N][M]; // 토마토 창고 정보 입력
		for (int k = 0; k < H; k++) {
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				for (int j = 0; j < M; j++) {
					storage[k][i][j] = Integer.parseInt(st.nextToken());
					if(storage[k][i][j] == 1) {
						tomato.add(new int[] {k, i, j}); // 시작으로 익은 토마토가 주어진 경우
					}
				}
			}			
		}
		
		visited = new int[H][N][M];
		bfs(); // BFS 탐색

		boolean isWellDone = true;
		for (int k = 0; k < H; k++) {
			for (int i = 0; i < N; i++) { // 토마토가 전부 익었는지 확인
				for (int j = 0; j < M; j++) {
					if(storage[k][i][j] == 0) { // 토마토가 익지 않았다면 시간을 -1로 지정
						isWellDone = false;
						break;
					}
					if(visited[k][i][j] > minTime) {
						minTime = visited[k][i][j]-1;
					}
				}
			}			
		}
		
		if(!isWellDone) minTime = -1;
		out.write(Integer.toString(minTime));
		out.flush();
		out.close();
	}
	
	public static void bfs() {		
		int[] dh = {-1,1,0,0,0,0}; // 위, 아래, (왼쪽), (오른쪽), (앞), (뒤)
		int[] dr = {0,0,0,0,1,-1}; // (위), (아래), (왼쪽), (오른쪽), 앞, 뒤
		int[] dc = {0,0,-1,1,0,0}; // (위), (아래), 왼쪽, 오른쪽, (앞), (뒤)
		
		Deque<int[]> q = new ArrayDeque<int[]>();
		
		for (int i = 0, size = tomato.size(); i < size; i++) { // 초기에 익은 토마토가 주어질때 큐에 우선적으로 넣기
			q.offer(new int[] {tomato.get(i)[0], tomato.get(i)[1], tomato.get(i)[2], 1}); // (0, 1, 2): 좌표, 2: 소요 시간
			visited[tomato.get(i)[0]][tomato.get(i)[1]][tomato.get(i)[2]] = 1;
		}
		
		while(!q.isEmpty()) {;
			int[] now = q.poll();
			storage[now[0]][now[1]][now[2]] = 1;
			visited[now[0]][now[1]][now[2]] = now[3];
			
			for (int i = 0; i < 6; i++) { // 인접 노드 탐색				
				int nh = now[0]+dh[i];
				int nr = now[1]+dr[i];
				int nc = now[2]+dc[i];
				
				if(nh < 0 || nh >= H || nr < 0 || nr >= N || nc < 0 || nc >= M || storage[nh][nr][nc] == -1)
					continue;
				
				if(visited[nh][nr][nc] == 0) {
					q.offer(new int[] {nh, nr, nc, now[3]+1});
					visited[nh][nr][nc] = now[3]+1;
				}
			}
		}
	}
}

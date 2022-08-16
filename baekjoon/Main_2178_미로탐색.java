package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2178_미로탐색 {
	static int N, M, minMove = Integer.MAX_VALUE;
	static int[][] maze; // 미로 배열
	static int[][] visited; // 미로 방문 배열
	
	public static void bfs(int row, int col) {
		// 탐색방향:우,하,좌,상
		int[] dr = {0, 1, 0, -1};
		int[] dc = {1, 0, -1, 0};
		
		Queue<int[]> q = new ArrayDeque<int[]>();
		q.offer(new int[] {row, col});
		visited[row][col] = 1;
		
		while(!q.isEmpty()) {
			int[] curr = new int[2]; // 현재 위치
			curr = q.poll(); // 현재 위치
			
			if(curr[0] == N && curr[1] == M) break; // 현 위치가 도착지인 경우 종료
			
			for (int d = 0; d < 4; d++) {
				int[] next = new int[2]; // 다음 위치
				next[0] = curr[0] + dr[d];
				next[1] = curr[1] + dc[d];
				
				// 범위를 벗어나지 않고 갈 수 있는 길이며, 방문하지 않은 경우
				if(next[0] > 0 && next[0] <= N && next[1] > 0 && next[1] <= M && maze[next[0]][next[1]] == 1 && visited[next[0]][next[1]] == 0) {
					q.offer(next); // 이동할 수 있는 위치는 큐에 저장
					visited[next[0]][next[1]] = visited[curr[0]][curr[1]] + 1; // 다음 위치 이동거리 =  현 위치 이동거리 + 1
				}
			}
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		maze = new int[N+1][M+1];
		visited = new int[N+1][M+1];
		String input;
		for (int i = 1; i <= N; i++) { // 0: 이동X, 1: 이동가능
			input = in.readLine();
			for (int j = 0; j < M; j++) {
				maze[i][j+1] = input.charAt(j) - '0';
			}
		}
		bfs(1,1); // (1,1)에서 탐색 시작
		out.write(Integer.toString(visited[N][M])); // (N,M) 도착시 최단거리 출력
		out.flush();
		out.close();
	}
}

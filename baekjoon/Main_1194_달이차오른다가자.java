package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_1194_달이차오른다가자 {
	static int N, M;
	static int minMove = Integer.MAX_VALUE;
	static char[][] maze;
	static int[] dr = new int[] {-1, 1, 0, 0};
	static int[] dc = new int[] {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int startRow = 0, startCol = 0;
		maze = new char[N][M];
		for (int i = 0; i < N; i++) {
			String input = in.readLine();
			for (int j = 0; j < M; j++) {
				maze[i][j] = input.charAt(j);
				if(maze[i][j] == '0') {
					startRow = i;
					startCol = j;
				}
			}
		}
		
		bfs(startRow, startCol);
		
		if(minMove == Integer.MAX_VALUE) // 최소 이동 횟수가 초기값인 경우 -> 탈출 X
			out.write("-1");			
		else // 탈출한 경우
			out.write(Integer.toString(minMove));
		out.flush();
		out.close();
	}
	
	private static void bfs(int row, int col) {
		boolean[][][] visited = new boolean[N][M][64]; // 6개의 키가 있으므로 비트마스킹용 6자리 2진수 사용->  최대 63까지 체크 필요
		
		Deque<int[]> q = new ArrayDeque<int[]>();
		q.offer(new int[] {row, col, 0, 0}); // 행, 열, 이동횟수, 키(비트 마스킹)
		visited[row][col][0] = true;
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int r = curr[0];
			int c = curr[1];
			int cnt = curr[2];
			int key = curr[3];
	
			for (int i = 0; i < 4; i++) { 
				int nr = r + dr[i];
				int nc = c + dc[i];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc][key]) // 범위를 벗어나거나 같은 키로 방문한 적이 있는 경우
					continue;
				
				char nextV = maze[nr][nc]; // 다음 위치 값
				if(nextV == '#') { // 다음 위치에 벽이 있는 경우
					continue;
				}
				else if(nextV == '1') { // 다음 위치가 출구인 경우 -> 최소 이동 횟수 체크
					minMove = ((cnt+1) < minMove) ? (cnt+1) : minMove;
				}
				else if(nextV >= 'a' && nextV<= 'f') { // 다음 위치에 키가 있는 경우
					int keyNum = nextV - 'a'; // 키 번호, a부터 0번
					int newKey = key | (1 << keyNum); // 다음 위치 키와 현재 키 비트 마스킹
					
					if(!visited[nr][nc][newKey]) { // 새로운 키로 방문한 적이 없는 경우
						q.offer(new int[] {nr, nc, cnt+1, newKey});
						visited[nr][nc][newKey] = true;
					}
				}
				else if(nextV >= 'A' && nextV <= 'F') { // 다음 위치에 문이 있는 경우
					int doorNum = nextV - 'A'; // 문 번호, A부터 0번
					int hasKey = key & (1 << doorNum); // 다음 위치 문과 가지고 있는 키 마스킹 체크
					
					if(hasKey > 0) { // 문에 대응되는 키를 가지고 있는 경우 -> 이동 가능
						q.offer(new int[] {nr, nc, cnt+1, key});
						visited[nr][nc][key] = true;
					}
				}
				else { // 다음 위치가 빈 칸인 경우
					q.offer(new int[] {nr, nc, cnt+1, key});
					visited[nr][nc][key] = true;
				}
			}
		}
	}
}

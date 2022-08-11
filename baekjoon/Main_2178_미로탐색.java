package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_2178_미로탐색 {
	static int[][] maze; // 미로 배열
	static int N, M, minMove = Integer.MAX_VALUE;
	
	public static int find(int row, int col, int move, boolean[][] visited) {
		if(row < 0 || row >= N || col < 0 || col >= M || maze[row][col] == 0 || visited[row][col] == true) 
			return 99999; // 범위를 벗어난 경우 또는 갈 수 없는 길인 경우, 이미 방문한 경우 종료
		else if(row == N-1 && col == M-1)  // 도착위치 이동한 경우
			return 1;
		else{ // 이동할 수 있는 칸인 경우
			visited[row][col] = true; // 방문 처리
			return 1+Math.min(Math.min(find(row-1, col, move+1, visited),find(row+1, col, move+1, visited)), Math.min(find(row, col-1, move+1, visited),find(row, col+1, move+1, visited)));
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		maze = new int[N][M];
		String input;
		for (int i = 0; i < N; i++) {
			input = in.readLine();
			for (int j = 0; j < M; j++) {
				maze[i][j] = input.charAt(j) - '0';
			}
		}
		boolean[][] visited = new boolean[N][M]; // 미로 방문 배열 생성
		out.write(Integer.toString(find(0, 0, 1, visited)));
		out.flush();
		out.close();
	}
}

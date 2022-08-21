package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_2630_색종이만들기 {
	static int[][] paper;
	static int whitePaper = 0, bluePaper = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int N = Integer.parseInt(in.readLine()); // 종이의 크기 (가로/세로의 크기)
		paper = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < N; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		findPaper(N, 0, 0);
		sb.append(whitePaper).append("\n").append(bluePaper);
		out.write(sb.toString());
		out.flush();
		out.close();
	}
	
	public static void findPaper(int size, int row, int col) { // 재귀함수
		boolean isEqual = true;
		for (int i = row; i < row+size; i++) { // 전부 다 같은 원소인지 확인
			for (int j = col; j < col+size; j++) {
				if(paper[row][col] != paper[i][j]) {
					isEqual = false;
					break;
				}
			}
		}
		if(isEqual) { // 전부 같다면
			if(paper[row][col] == 0) whitePaper++; // 0이면 흰색 색종이
			else bluePaper++; // 1이면 파란색 색종이
		}
		else {
			findPaper(size/2, row, col); // 좌상단 배열
			findPaper(size/2, row, col+size/2); // 우상단 배열
			findPaper(size/2, row+size/2, col); // 좌하단 배열
			findPaper(size/2, row+size/2, col+size/2); // 우하단 배열
		}
	}
}

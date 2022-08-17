package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_1992_쿼드트리 {
	static StringBuilder sb = new StringBuilder();
	static int[][] media;
	
	public static void quadTree(int size, int row, int col) { // 쿼드트리 재귀함수
		boolean isEqual = true;
		for (int i = row; i < row+size; i++) { // 전부 다 같은 원소인지 확인
			for (int j = col; j < col+size; j++) {
				if(media[row][col] != media[i][j]) {
					isEqual = false;
					break;
				}
			}
		}
		if(isEqual) sb.append(media[row][col]); // 전부 같다면 같은 숫자 출력
		else {
			sb.append("(");
			quadTree(size/2, row, col); // 좌상단 배열
			quadTree(size/2, row, col+size/2); // 우상단 배열
			quadTree(size/2, row+size/2, col); // 좌하단 배열
			quadTree(size/2, row+size/2, col+size/2); // 우하단 배열
			sb.append(")");
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(in.readLine()); // 영상의 크기 (가로/세로의 크기)
		media = new int[N][N];
		for (int i = 0; i < N; i++) {
			String input = in.readLine();
			for (int j = 0; j < N; j++) {
				media[i][j] = input.charAt(j) - '0';
			}
		}
		quadTree(N, 0, 0);
		out.write(sb.toString());
		out.flush();
		out.close();
	}
}

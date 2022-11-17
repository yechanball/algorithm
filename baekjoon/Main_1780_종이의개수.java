package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1780_종이의개수 {
	static int[][] paper;
	static int minusPaper = 0, zeroPaper = 0, plusPaper = 0; // 각각 -1, 0, 1로 채워진 종이의 개수
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(in.readLine()); // 종이의 크기
		paper = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < N; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		findPaper(N, 0, 0);
		System.out.print(minusPaper + "\n" + zeroPaper + "\n" + plusPaper);
	}
	
	public static void findPaper(int size, int row, int col) {
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
			if(paper[row][col] == -1) minusPaper++; // -1로 채워진 종이인 경우
			else if(paper[row][col] == 0) zeroPaper++; // 0로 채워진 종이인 경우
			else plusPaper++; // 1로 채워진 종이인 경우
		}
		else {
			int partSize = size/3;
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					findPaper(partSize, row + partSize*i, col + partSize*j); // 부분배열					
				}
			}
		}
	}
}

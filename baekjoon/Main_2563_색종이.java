package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2563_색종이 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[][] paper = new int[100][100];
		int N = Integer.parseInt(in.readLine());
		int row, col, area = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			row = Integer.parseInt(st.nextToken());
			col = Integer.parseInt(st.nextToken());
			for (int j = row; j < row+10; j++) {
				for (int k = col; k < col+10; k++) {
					if(paper[j][k] == 0) { // 색종이가 없는 영역만 체크
						paper[j][k]=1;
						area++;
					}
				}
			}
		}
		System.out.print(area);
	}
}

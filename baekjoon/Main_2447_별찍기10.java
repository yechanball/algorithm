package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_2447_별찍기10 {
	static char[][] star;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(in.readLine());
		star = new char[N][N];
		printStar(N, 0, 0);
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(star[i][j]);
			}
			sb.append("\n");
		}
		
		out.write(sb.toString());
		out.flush();
		out.close();
	}

	private static void printStar(int n, int r, int c) {
		if(n == 3) {
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					star[r+i][c+j] = '*';
				}
			}
			star[r+1][c+1] = ' ';
			return;
		}
		
		int subN = n/3;
		printStar(subN, r, c);
		printStar(subN, r, c + subN);
		printStar(subN, r, c + subN*2);
		printStar(subN, r + subN, c);
		for (int i = r + subN, row = r + subN * 2; i < row; i++) {
			for (int j = c + subN, col = c + subN * 2; j < col; j++) {
				star[i][j] = ' ';
			}
		}
		printStar(subN, r + subN, c + subN*2);
		printStar(subN, r + subN*2, c);
		printStar(subN, r + subN*2, c + subN);
		printStar(subN, r + subN*2, c + subN*2);
	}
}

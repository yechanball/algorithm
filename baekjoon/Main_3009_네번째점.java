package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_3009_네번째점 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int[][] X = new int[2][2];
		int[][] Y = new int[2][2];
		
		for (int i = 0; i < 3; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int x = Integer.parseInt(st.nextToken());
			if(X[0][0] == 0 || X[0][0] == x) {
				X[0][0] = x;
				X[0][1]++;
			}else {
				X[1][0] = x;
				X[1][1]++;
			}
			
			int y = Integer.parseInt(st.nextToken());
			if(Y[0][0] == 0 || Y[0][0] == y) {
				Y[0][0] = y;
				Y[0][1]++;
			}else {
				Y[1][0] = y;
				Y[1][1]++;
			}
		}
		
		int posX = 0, posY = 0;
		for (int i = 0; i < 2; i++) {
			if(X[i][1] == 1) posX = X[i][0];
			if(Y[i][1] == 1) posY = Y[i][0];
		}
		
		System.out.print(posX + " " + posY);
	}
}

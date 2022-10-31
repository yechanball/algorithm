package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2166_다각형의면적 {
	static class Point {
		int x;
		int y;
		
		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(in.readLine());
		Point[] point = new Point[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			point[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		// 넓이 S = 1/2 * |Sum{i:1~N} (xi + xi+1)(yi - yi+1)|
		double S = 0;
		for (int i = 0; i < N-1; i++) {
			S += ((double)(point[i].x + point[i+1].x) * (point[i].y - point[i+1].y));
		}
		S += ((double)(point[N-1].x + point[0].x) * (point[N-1].y - point[0].y));
		S = Math.abs(S)/2.0;
		
		System.out.print(String.format("%.1f", S));
	}
}
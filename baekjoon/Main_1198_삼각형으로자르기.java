package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1198_삼각형으로자르기 {
	static class Point {
		int x;
		int y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int N;
	static double maxArea = 0;
	static Point[] points, triangle;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		
		points = new Point[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			points[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		triangle = new Point[3];
		combi(0, 0);
		
		System.out.print(maxArea);
	}
	
	public static void combi(int start, int cnt) {
		if(cnt == 3) {
			double area = ((double)Math.abs(triangle[0].x * (triangle[1].y - triangle[2].y) + triangle[1].x * (triangle[2].y - triangle[0].y) + triangle[2].x * (triangle[0].y - triangle[1].y))) / 2;
			
			if(area > maxArea) maxArea = area;
			return;
		}
		
		for (int i = start; i < N; i++) {
			triangle[cnt] = points[i];
			combi(i+1, cnt+1);
		}
	}
}

package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2987_사과나무 {
	static class Point {
		int x;
		int y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		Point[] triangle = new Point[3];
		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(in.readLine());
			triangle[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		int N = Integer.parseInt(in.readLine()), cnt = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			Point tree = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			
			int ccw1 = ccw(triangle[0], triangle[1], tree);
			int ccw2 = ccw(triangle[1], triangle[2], tree);
			int ccw3 = ccw(triangle[2], triangle[0], tree);
			
			if((ccw1 >= 0 && ccw2 >= 0 && ccw3 >= 0) || (ccw1 <= 0 && ccw2 <= 0 && ccw3 <= 0)) cnt++;
		}
		
		double area = ((double)Math.abs(triangle[0].x * (triangle[1].y - triangle[2].y) + triangle[1].x * (triangle[2].y - triangle[0].y) + triangle[2].x * (triangle[0].y - triangle[1].y))) / 2;
		System.out.printf("%.1f\n%d", area, cnt);
	}
	
	public static int ccw(Point p1, Point p2, Point p3) {
		return (p1.x * p2.y + p2.x * p3.y + p3.x * p1.y) - (p2.x * p1.y + p3.x * p2.y + p1.x * p3.y);
	}
}

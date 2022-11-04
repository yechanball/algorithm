package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11758_CCW {
	static class Point { // 점
		int x; // x좌표
		int y; // y좌표
		
		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		Point p1 = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		
		st = new StringTokenizer(in.readLine(), " ");
		Point p2 = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		
		st = new StringTokenizer(in.readLine(), " ");
		Point p3 = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

		int value = ccw(p1, p2, p3);
				
		if(value > 0) System.out.print(1);
		else if(value < 0) System.out.print(-1);
		else System.out.print(0);
	}
	
	static int ccw(Point p1, Point p2, Point p3) { // Counter-Clockwise, 양수: 반시계방향 / 음수: 시계방향
		return (p1.x * p2.y + p2.x * p3.y + p3.x * p1.y) - (p2.x * p1.y + p3.x * p2.y + p1.x * p3.y);
	}
}
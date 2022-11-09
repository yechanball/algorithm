package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17386_선분교차1 {
	static class Point { // 점
		long x; // x좌표
		long y; // y좌표
		
		public Point(long x, long y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		Point p1 = new Point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
		Point p2 = new Point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
		
		st = new StringTokenizer(in.readLine(), " ");
		Point p3 = new Point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
		Point p4 = new Point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));

		if(ccw(p1, p2, p3) * ccw(p1, p2, p4) < 0 && ccw(p3, p4, p1) * ccw(p3, p4, p2) < 0) {
			System.out.print("1");
		}else {
			System.out.print("0");			
		}
	}
	
	static int ccw(Point p1, Point p2, Point p3) { // Counter-Clockwise, 양수: 반시계방향 / 음수: 시계방향
		long result = (p1.x * p2.y + p2.x * p3.y + p3.x * p1.y) - (p2.x * p1.y + p3.x * p2.y + p1.x * p3.y);
		
		if(result > 0) return 1;
		else if(result < 0) return -1;
		else return 0;
	}
}
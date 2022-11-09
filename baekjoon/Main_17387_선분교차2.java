package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17387_선분교차2 {
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
		
		boolean isCross = false;
		int result1 = ccw(p1, p2, p3) * ccw(p1, p2, p4);
		int result2 = ccw(p3, p4, p1) * ccw(p3, p4, p2);
		
		if(result1 == 0 && result2 == 0) { // 두 선분이 한 직선 위에 있는 경우
			long pt1 = Math.min(p1.x, p2.x), pt2 = Math.max(p1.x, p2.x);
			if(p1.x == p2.x) {
				pt1 = Math.min(p1.y, p2.y);
				pt2 = Math.max(p1.y, p2.y);
			}
			
			long pt3 = Math.min(p3.x, p4.x), pt4 = Math.max(p3.x, p4.x);
			if(p3.x == p4.x) {
				pt3 = Math.min(p3.y, p4.y);
				pt4 = Math.max(p3.y, p4.y);				
			}
			
			if(pt1 <= pt4 && pt3 <= pt2) { 
				isCross = true;
			}
		}else if(result1 <= 0 && result2 <= 0) { // 두 선분이 반시계+시계방향이거나 세 점이 한 직선 위에 있는 경우
			isCross = true;
		}
		
		System.out.print((isCross) ? "1" : "0");
	}
	
	static int ccw(Point p1, Point p2, Point p3) { // Counter-Clockwise, 양수: 반시계방향 / 음수: 시계방향
		long result = (p1.x * p2.y + p2.x * p3.y + p3.x * p1.y) - (p2.x * p1.y + p3.x * p2.y + p1.x * p3.y);
		
		if(result > 0) return 1;
		else if(result < 0) return -1;
		else return 0;
	}
	
	static void swap(Point p1, Point p2) {
		long tmp;
		
		if(p1.x == p2.x && p1.y > p2.y) {
			tmp = p2.y;
			p2.y = p1.y;
			p1.y = tmp;
		}else if(p1.x > p2.x) {
			tmp = p2.x;
			p2.x = p1.x;
			p1.x = tmp;				
		}
	}
}
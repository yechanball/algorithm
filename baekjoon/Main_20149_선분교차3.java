package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_20149_선분교차3 {
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
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		Point p1 = new Point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
		Point p2 = new Point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
		
		st = new StringTokenizer(in.readLine(), " ");
		Point p3 = new Point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
		Point p4 = new Point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));		
		
		int ccw123 = ccw(p1, p2, p3);
		int ccw124 = ccw(p1, p2, p4);
		int ccw341 = ccw(p3, p4, p1);
		int ccw342 = ccw(p3, p4, p2);
		int result1 = ccw123 * ccw124;
		int result2 = ccw341 * ccw342;
		
		if((result1 <= 0 && result2 < 0) || (result1 < 0 && result2 <= 0)) { // 두 선분이 반시계+시계방향이거나 세 점이 한 직선 위에 있는 경우
			sb.append("1");
			
			double x, y, a, b, c, d;
			if(p2.x - p1.x == 0){ // 한 선분만 x축에 수직인 경우
				c = (double)(p4.y - p3.y) / (double)(p4.x - p3.x);
				
				x = p1.x;
				y = c * (x - p3.x) + p3.y;
            }else if(p4.x - p3.x == 0){ // 한 선분만 x축에 수직인 경우
            	a = (double)(p2.y - p1.y) / (double)(p2.x - p1.x);
				
				x = p3.x;
				y = a * (x - p1.x) + p1.y;
            }else { // 두 선분 모두 x축에 수직이지 않은 경우
            	// p1, p2를 지나는 직선 : y = ax + b
                // a = (p2.y - p1.y) / (p2.x - p1.x), b = p2.y - a * p2.x
                a = (double)(p2.y - p1.y) / (double)(p2.x - p1.x);
                b = (double)p2.y - (double)(a * p2.x);

                // p3, p4를 지나는 직선 : y = cx + d
                // c = (p4.y - p3.y) / (p4.x - p3.x), d = p4.y - c * p4.x
                c = (double)(p4.y - p3.y) / (double)(p4.x - p3.x);
                d = (double)p4.y - (double)(c * p4.x);

                x = (d - b)/(a - c);
                y = a * x + b;
            }
			sb.append("\n").append(x).append(" ").append(y);
		}else if(result1 == 0 && result2 == 0) { // 세 점 이상이 한 직선 위에 있는 경우
			if(ccw123 == 0 && ccw124 == 0 && ccw341 == 0 && ccw342 == 0) { // 두 선분이 한 직선 위에 있는 경우
				long pt1, pt2, pt3, pt4;
				if(p1.x == p2.x) {
					pt1 = Math.min(p1.y, p2.y);
					pt2 = Math.max(p1.y, p2.y);
					pt3 = Math.min(p3.y, p4.y);
					pt4 = Math.max(p3.y, p4.y);	
				}else {
					pt1 = Math.min(p1.x, p2.x);
					pt2 = Math.max(p1.x, p2.x);
					pt3 = Math.min(p3.x, p4.x);
					pt4 = Math.max(p3.x, p4.x);
				}

				if(pt1 < pt4 && pt3 < pt2) { // 두 선분이 겹치는 경우
					sb.append("1");
				}
				else if(pt2 == pt3 || pt1 == pt4) { // 겹치는 두 선분이 한쪽 끝에서 교차하는 경우
					sb.append("1");
					if((p1.x == p3.x && p1.y == p3.y) || (p1.x == p4.x && p1.y == p4.y)) {
						sb.append("\n").append(p1.x).append(" ").append(p1.y);
					}
					else if((p2.x == p3.x && p2.y == p3.y) || (p2.x == p4.x && p2.y == p4.y)) {
						sb.append("\n").append(p2.x).append(" ").append(p2.y);
					}
				}else {
					sb.append("0");									
				}
			}else {
				sb.append("1");
				if (p1.x == p3.x && p1.y == p3.y || p1.x == p4.x && p1.y == p4.y) {
					sb.append(p1.x).append(" ").append(p1.y);					
				}
				else if((p2.x == p3.x && p2.y == p3.y) || (p2.x == p4.x && p2.y == p4.y)) {
					sb.append("\n").append(p2.x).append(" ").append(p2.y);
				}
			}
		}else {
			sb.append("0");	
		}
		
		System.out.print(sb.toString());
	}
	
	static int ccw(Point p1, Point p2, Point p3) { // Counter-Clockwise, 양수: 반시계방향 / 음수: 시계방향
		long result = (p1.x * p2.y + p2.x * p3.y + p3.x * p1.y) - (p2.x * p1.y + p3.x * p2.y + p1.x * p3.y);
		
		if(result > 0) return 1;
		else if(result < 0) return -1;
		else return 0;
	}
}
package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_6487_두직선의교차여부 {
	static class Point {
		double x;
		double y;
		
		public Point(double x, double y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(in.readLine());
		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			Point p1 = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			Point p2 = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			Point p3 = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			Point p4 = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));		
			
			checkCross(p1, p2, p3, p4);
		}
		
		out.write(sb.toString());
		out.flush();
		out.close();
	}
	
	public static void checkCross(Point p1, Point p2, Point p3, Point p4) {
		double a1 = 0, b1 = 0, c1 = 0; // 1번 직선: y = a1 * x + b1 || y = c1 * x
		double a2 = 0, b2 = 0, c2 = 0; // 2번 직선: y = a2 * x + b2 || y = c2 * x
		
		// 1번 직선
		if(p1.x == p2.x){ // y축과 평행한 경우
			c1 = p1.x;
		}else {
			a1 = (p2.y - p1.y) / (p2.x - p1.x);
            b1 = p1.y - a1 * p1.x;
		}
		
		// 2번 직선
		if(p3.x == p4.x){ // y축과 평행한 경우
			c2 = p3.x;
		}else {
			a2 = (p4.y - p3.y) / (p4.x - p3.x);
            b2 = p3.y - a2 * p3.x;
		}
		
		// 교차 검증
		if (c1 != 0 || c2 != 0) { // 한 개 이상의 직선이 y축과 평행한 경우
            if (c1 == c2) { // 두 직선 일치
                sb.append("LINE\n");
            }
            else if (c1 != 0 && c2 != 0) { // 두 직선 평행
            	sb.append("NONE\n");
            }
            else { // 한 직선만 y축과 평행한 경우
                if (p1.x == p2.x) {
                	double y = a2 * c1 + b2;
                	sb.append("POINT " + String.format("%.2f", c1) + " " + String.format("%.2f", y) + "\n");
                }
                if (p3.x == p4.x) {
                	double y = a1 * c2 + b1;
                	sb.append("POINT " + String.format("%.2f", c2) + " " + String.format("%.2f", y) + "\n");
                }
            }
        }
		else if (a1 == a2) { // 두 직선의 기울기가 같은 경우
            if (b1 == b2) { // 두 직선 일치
            	sb.append("LINE\n");
            }
            else { // 두 직선 평행
            	sb.append("NONE\n");
            }
        }
		else { // 두 직선 교차
            double x = -1 * (b1 - b2) / (a1 - a2);
            double y = a1 * x + b1;
            
            sb.append("POINT " + String.format("%.2f", x) + " " + String.format("%.2f", y) + "\n");
        }
	}
}
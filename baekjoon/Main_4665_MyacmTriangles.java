package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_4665_MyacmTriangles {
	static class Point {
		char label;
		int x;
		int y;
		
		public Point(char label, int x, int y) {
			this.label = label;
			this.x = x;
			this.y = y;
		}
	}
	
	static int N;
	static String maxTri;
	static double maxArea;
	static Point[] monuments, triangle;
	static boolean[] isUsed;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		while(true) {
			N = Integer.parseInt(in.readLine());
			if(N == 0) break;
			
			monuments = new Point[N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine());
				monuments[i] = new Point(st.nextToken().charAt(0), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			
			triangle = new Point[3];
			isUsed = new boolean[N];
			maxArea = -1;
			combi("", 0, 0);
			
			sb.append(maxTri + "\n");
		}
		
		out.write(sb.toString());
		out.flush();
		out.close();
	}
	
	public static void combi(String tri, int start, int cnt) {
		if(cnt == 3) {
			checkField(tri);
			return;
		}
		
		for (int i = start; i < N; i++) {
			triangle[cnt] = monuments[i];
			isUsed[i] = true;
			combi(tri+monuments[i].label, i+1, cnt+1);
			isUsed[i] = false;
		}
	}
	
	public static void checkField(String tri) {
		boolean isPoss = true;
		
		for (int i = 0; i < N; i++) {
			if(isUsed[i]) continue;
			
			int ccw1 = ccw(triangle[0], triangle[1], monuments[i]);
			int ccw2 = ccw(triangle[1], triangle[2], monuments[i]);
			int ccw3 = ccw(triangle[2], triangle[0], monuments[i]);
			
			if((ccw1 >= 0 && ccw2 >= 0 && ccw3 >= 0) || (ccw1 <= 0 && ccw2 <= 0 && ccw3 <= 0)) {
				isPoss = false;
				break;
			}
		}
		
		if(isPoss) {
			double area = ((double)Math.abs(triangle[0].x * (triangle[1].y - triangle[2].y) + triangle[1].x * (triangle[2].y - triangle[0].y) + triangle[2].x * (triangle[0].y - triangle[1].y))) / 2;
			
			if(area > maxArea) {
				maxArea = area;
				maxTri = tri;
			}
		}
		
	}
	
	public static int ccw(Point p1, Point p2, Point p3) {
		return (p1.x * p2.y + p2.x * p3.y + p3.x * p1.y) - (p2.x * p1.y + p3.x * p2.y + p1.x * p3.y);
	}
}

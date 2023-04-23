package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_4181_ConvexHull {
	static class Point {
		long x;
		long y;
		
		public Point(long x, long y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(in.readLine());
		int cnt = 0;
		
		List<Point> pointList = new ArrayList<Point>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			long x = Long.parseLong(st.nextToken());
			long y = Long.parseLong(st.nextToken());
			
			if(st.nextToken().equals("Y")) {
				Point point = new Point(x, y);
				pointList.add(point);
				cnt++;
			}
		}
		sb.append(cnt);
		
		Collections.sort(pointList, new Comparator<Point>() {
			@Override
			public int compare(Point p1, Point p2) {
				return (p1.x == p2.x) ? Long.compare(p1.y, p2.y) : Long.compare(p1.x, p2.x);
			}
		});
		
		Point[] points = pointList.toArray(new Point[cnt]);
		Arrays.sort(points, 1, cnt, new Comparator<Point>() {
			@Override
			public int compare(Point p1, Point p2) {
				long ccwValue = ccw(points[0], p1, p2);
			    
			    if (ccwValue > 0) return -1;
			    else if (ccwValue < 0) return 1;
			    else if (p1.x != p2.x) return Long.compare(p1.x, p2.x);
			    else return Long.compare(p1.y, p2.y);
			}
		});
		
		Stack<Point> ans = new Stack<>();
		Stack<Point> rev = new Stack<>();
		
        for (int i = 0; i < cnt; i++) {
            while (ans.size() > 1 && (ccw(ans.get(ans.size() - 2), ans.peek(), points[i]) < 0)) { 
                rev.push(ans.peek());
                ans.pop();
            }
            ans.push(points[i]);
        }
        while(!rev.isEmpty()) ans.push(rev.pop());
 
		for (Point point : ans) sb.append("\n" + point.x + " " + point.y);

		out.write(sb.toString());
		out.flush();
		out.close();
	}
	
	static long ccw(Point p1, Point p2, Point p3) {
		return (p1.x * p2.y + p2.x * p3.y + p3.x * p1.y) - (p2.x * p1.y + p3.x * p2.y + p1.x * p3.y);
	}
}

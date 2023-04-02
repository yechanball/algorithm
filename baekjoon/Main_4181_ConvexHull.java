package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main_4181_ConvexHull {
	static class Point {
		int x;
		int y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static Point base = new Point(Integer.MAX_VALUE, Integer.MAX_VALUE);
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(in.readLine());
		int cnt = 0; // 볼록껍질을 이루는 점의 개수
		
		List<Point> pointList = new ArrayList<Point>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			String c = st.nextToken();
			
			if(c.equals("Y")) {
				Point point = new Point(x, y);
				pointList.add(point);
				cnt++;
				
				// x좌표가 가장 작은 점(x좌표가 같은 경우 y좌표가 가장 작은 점)을 기준점으로 선정
				if(x < base.x) base = point;
				else if(x == base.x && y < base.y) base = point;	
			}
		}
		sb.append(cnt + "\n");
		
		// 볼록껍질을 이루는 점을 기준점 기준으로 반시계 방향으로 정렬하기
		Collections.sort(pointList, new Comparator<Point>() {
			@Override
			public int compare(Point p1, Point p2) {
				long value = ccw(base, p1, p2);
				
				if(value > 0) return -1;
				else if(value < 0) return 1;
				else{
					long dist1 = dist(base, p1);
					long dist2 = dist(base, p2);
					
					return (dist1 > dist2) ? 1 : -1;
				}
			}
		});
		
		int half = 0;
		long maxDist = 0;
		for (int i = 0; i < cnt; i++) {
			Point point = pointList.get(i);
			long d = dist(base, point);
			if(d < maxDist) {
				half = i;
				break;
			}
			maxDist = d;
			sb.append(point.x + " " + point.y + "\n");
		}
		
		// 껍질 상단부분 재정렬
		pointList = pointList.subList(half, cnt);
		Collections.sort(pointList, new Comparator<Point>() {
			@Override
			public int compare(Point p1, Point p2) {
				long value = ccw(base, p1, p2);
				
				if(value > 0) return -1;
				else if(value < 0) return 1;
				else{
					long dist1 = dist(base, p1);
					long dist2 = dist(base, p2);
					
					return (dist1 < dist2) ? 1 : -1;
				}
			}
		});
		for (Point point : pointList) {
			sb.append(point.x + " " + point.y + "\n");
		}
		
		out.write(sb.toString());
		out.flush();
		out.close();
	}
	
	static long ccw(Point p1, Point p2, Point p3) { // Counter-Clockwise, 양수: 반시계방향 / 음수: 시계방향
		return (p1.x * p2.y + p2.x * p3.y + p3.x * p1.y) - (p2.x * p1.y + p3.x * p2.y + p1.x * p3.y);
	}
	
	static long dist(Point p1, Point p2) {
		return (p2.x - p1.x) * (p2.x - p1.x) + (p2.y - p1.y) * (p2.y - p1.y);
	}
}

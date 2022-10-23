package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_1708_볼록껍질 {
	static Point base = new Point(Long.MAX_VALUE, Long.MAX_VALUE); // 기준점
	
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
		StringTokenizer st;
		
		List<Point> pointList = new ArrayList<Point>(); // 주어진 모든 점 좌표 리스트
		int N = Integer.parseInt(in.readLine());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			pointList.add(new Point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken())));
		}
		
		/* 그라함 스캔 알고리즘 */
		// 가장 작은 y좌표를 가진 점을 기준점으로 찾기(y좌표가 같은 경우 x좌표가 더 작은 점으로 선택)
		for (int i = 0; i < N; i++) {
			if(pointList.get(i).y < base.y) {
				base = pointList.get(i);
			}
			else if(pointList.get(i).y == base.y && pointList.get(i).x < base.x) {
				base = pointList.get(i);	
			}
		}
		
		// 모든 점을 기준점 기준으로 반시계 방향으로 정렬하기
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
		
		// 반시계 방향으로 점 확인하기
		int cnt = 0; // 볼록껍질(CONVEX HULL)을 이루는 점의 개수
		
		Stack<Point> stack = new Stack<Point>(); // 스택
		stack.add(base);
		cnt++;
		
		for (int i = 1; i < N; i++) { // 기준점 제외 탐색
			while(cnt > 1 && ccw(stack.get(cnt - 2), stack.get(cnt - 1), pointList.get(i)) <= 0) {
				stack.pop();
				cnt--;
			}
			stack.add(pointList.get(i));
			cnt++;
		}

		System.out.print(cnt);
	}
	
	static long ccw(Point p1, Point p2, Point p3) { // Counter-Clockwise, 양수: 반시계방향 / 음수: 시계방향
		return (p1.x * p2.y + p2.x * p3.y + p3.x * p1.y) - (p2.x * p1.y + p3.x * p2.y + p1.x * p3.y);
	}
	
	static long dist(Point p1, Point p2) { // 두 점 사이 거리 반환
		return (p2.x - p1.x) * (p2.x - p1.x) + (p2.y - p1.y) * (p2.y - p1.y);
	}
}

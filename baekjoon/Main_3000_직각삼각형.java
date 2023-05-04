package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_3000_직각삼각형 {
	static class Point {
		int x, y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        
        Point[] points = new Point[N];
        for(int i = 0; i < N; i++) {
        	StringTokenizer st = new StringTokenizer(in.readLine());
            points[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        HashMap<Integer, Long> xCnt = new HashMap<>(), yCnt = new HashMap<>();
        for(int i = 0; i < N; i++) {
            xCnt.put(points[i].x, xCnt.containsKey(points[i].x) ? xCnt.get(points[i].x) + 1 : 1);
            yCnt.put(points[i].y, yCnt.containsKey(points[i].y) ? yCnt.get(points[i].y) + 1 : 1);
        }

        long answer = 0;
        for(int i = 0; i < N; i++) {
            answer += (xCnt.get(points[i].x) - 1) * (yCnt.get(points[i].y) - 1);
        }
        System.out.print(answer);
    }
}

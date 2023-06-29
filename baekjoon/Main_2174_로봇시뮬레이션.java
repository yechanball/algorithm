package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2174_로봇시뮬레이션 {
	static StringBuilder sb;
	
	static int A, B;
	static int[][] map;
	static Robot[] robots;
	static String[] cardinalPts = {"N", "E", "S", "W"};
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	
	static class Robot {
		int x, y, d;

		public Robot(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		sb = new StringBuilder();
		
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		map = new int[B+1][A+1];
		
		st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		robots = new Robot[N+1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(in.readLine());
			robots[i] = new Robot(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), transDirection(st.nextToken()));
			map[robots[i].y][robots[i].x] = i;
		}
		
		boolean isProblem = false;
		for (int op = 0; op < M; op++) {
			st = new StringTokenizer(in.readLine());
			
			if(isProblem) continue;
			
			if(!move(Integer.parseInt(st.nextToken()), st.nextToken(), Integer.parseInt(st.nextToken()))) {
				isProblem = true;
			}
		}
		
		if(!isProblem) sb.append("OK");
		
		System.out.println(sb.toString());
	}

	public static int transDirection(String cardinalPt) {
		for (int i = 0; i < 4; i++) {
			if(cardinalPts[i].equals(cardinalPt)) return i;
		}
		return -1;
	}
	
	public static boolean move(int num, String op, int cnt) {
		if("L".equals(op)) {
			int nextD = robots[num].d - cnt%4;
			if(nextD < 0) nextD += 4;
			robots[num].d = nextD;
		}
		else if("R".equals(op)) {
			int nextD = robots[num].d + cnt%4;
			if(nextD >= 4) nextD -= 4;
			robots[num].d = nextD;
		}
		else {
			int	nx = robots[num].x;
			int ny = robots[num].y;
			int nextD = robots[num].d;
			
			map[ny][nx] = 0;
			
			while(cnt > 0) {
				nx += dx[nextD];
				ny += dy[nextD];
				
				if(nx < 1 || nx > A || ny < 1 || ny > B) {
					sb.append("Robot "+num+" crashes into the wall");
					return false;
				}
				
				if(map[ny][nx] != 0) {
					sb.append("Robot " + num + " crashes into robot " + map[ny][nx]);
					return false;
				}
				
				cnt--;
			}
			
			robots[num].x = nx;
			robots[num].y = ny;
			map[ny][nx] = num;
		}
		
		return true;
	}
}

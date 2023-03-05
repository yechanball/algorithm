package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1358_하키 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		int R = H/2;
		
		int cnt = 0;
		for (int i = 0; i < P; i++) {
			st = new StringTokenizer(in.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			if(x >= X && x <= X+W && y >= Y && y <= Y+H) cnt++;
			else {
				int dist1 = (X-x)*(X-x) + (Y+R-y)*(Y+R-y);
				int dist2 = (X+W-x)*(X+W-x) + (Y+R-y)*(Y+R-y);
				if(dist1 <= R*R || dist2 <= R*R) cnt++;
			}
		}
		
		System.out.print(cnt);
	}
}

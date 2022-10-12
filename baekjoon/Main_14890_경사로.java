package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_14890_경사로 {
	static int N, X, road = 0, preTop, cnt;
	static int[][] map;
	static boolean isDown, canMake;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int r = 0; r < N; r++) { // 가로 확인
			preTop = map[r][0];
			cnt = 1;
			isDown = false;
			canMake = true;
			
			for (int c = 1; c < N; c++) {
				canMakeRoad(r, c);
				if(!canMake) break;
			}
			
			if(isDown && cnt < X) canMake = false;
			
			if(canMake) road++; // 만들 수 있는 경우 활주로 개수 증가 
		}
		
		for (int c = 0; c < N; c++) { // 세로 확인
			preTop = map[0][c];
			cnt = 1;
			isDown = false;
			canMake = true;
			
			for (int r = 1; r < N; r++) {
				canMakeRoad(r, c);
				if(!canMake) break;
			}
			
			if(isDown && cnt < X) canMake = false;
			
			if(canMake) road++; // 만들 수 있는 경우 활주로 개수 증가 
		}	
		
		System.out.print(road);	
	}
	
	public static void canMakeRoad(int r, int c) {
		if(map[r][c] == preTop) { // 높이가 같은 경우 
			cnt++;
		}
		else if(Math.abs(preTop - map[r][c]) > 1) { // 높이 차이가 1 초과인 경우 불가능
			canMake = false;				
		}
		else if(map[r][c] < preTop) { // 높이가 낮은 경우 
			if(isDown && cnt < X) canMake = false;
	
			preTop = map[r][c];
			cnt = 1;
			isDown = true;
		}
		else if(map[r][c] > preTop) { // 높이가 높아진 경우 
			if((isDown && cnt < X*2) || cnt < X) canMake = false;
			
			preTop = map[r][c];
			cnt = 1;
			isDown = false;
		}
	}
}
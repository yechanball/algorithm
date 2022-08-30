package algorithm.swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_1767_프로세서연결하기 {
	static int N;
	static int coreCnt, sideCoreCnt;
	static List<int[]> coreList;
	static int[] corePos; // 0: 연결 x, 1상 2하 3좌 4우 
	static int maxConnect;
	static int minLength;
	static int[] dr = {0,-1,1,0,0}; // x상하좌우
	static int[] dc = {0,0,0,-1,1}; // x상하좌우	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			N = Integer.parseInt(in.readLine());
			coreCnt = 0;
			sideCoreCnt = 0;
			coreList = new ArrayList<int[]>();
			corePos = new int[N];
			int[][] map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] == 1) {
						coreCnt++;
						if(i == 0 || i == N-1 || j == 0 || j == N-1) {
							sideCoreCnt++;
						}else {
							coreList.add(new int[] {i, j});							
						}
					}
				}
			}
			
			maxConnect = 0;
			minLength = Integer.MAX_VALUE;
			subSet(0, 0, 0, map);
			sb.append(minLength).append("\n");
		}
		out.write(sb.toString());
		out.flush();
		out.close();
	}
	
	public static void subSet(int cnt, int connect, int length, int[][] map) {	
		if(cnt == coreList.size()) {
			if(connect > maxConnect) {
				maxConnect = connect;
				minLength = length;
			}
			else if(connect == maxConnect) {
				if(length < minLength) {
					minLength = length;
				}
			}
			return;
		}
		
		int up = check(cnt, 1, map);
		if(up != 0) {
			corePos[cnt] = 1;
			subSet(cnt+1, connect+1, length+up, markMap(cnt, 1, map));
		}
		
		int down = check(cnt, 2, map);
		if(down != 0) {
			corePos[cnt] = 2;
			subSet(cnt+1, connect+1, length+down, markMap(cnt, 2, map));
		}
		
		int left = check(cnt, 3, map);
		if(left != 0) {
			corePos[cnt] = 3;
			subSet(cnt+1, connect+1, length+left, markMap(cnt, 3, map));
		}
		
		int right = check(cnt, 4, map);
		if(right != 0) {
			corePos[cnt] = 4;
			subSet(cnt+1, connect+1, length+right, markMap(cnt, 4, map));
		}
		
		subSet(cnt+1, connect, length, map);
	}
	
	public static int check(int cnt, int direct, int[][] map) {
		int dirR = dr[direct];
		int dirC = dc[direct];
		int nr = coreList.get(cnt)[0];
		int nc = coreList.get(cnt)[1];
		int len = 0;
		while(true) {
			nr += dirR;
			nc += dirC;
			
			if(nr < 0 || nr >= N || nc < 0 || nc >= N) return len;
			
			if(map[nr][nc] != 0) break;
			
			len++;
		}
		
		return 0;
	}
	
	public static int[][] markMap(int cnt, int direct, int[][] map) {
		int[][] newMap = new int[N][N];
		for (int i = 0; i < N; i++) {
			newMap[i] = Arrays.copyOf(map[i], N);
		}
		
		int dirR = dr[direct];
		int dirC = dc[direct];
		int nr = coreList.get(cnt)[0];
		int nc = coreList.get(cnt)[1];
		while(true) {
			nr += dirR;
			nc += dirC;
			
			if(nr < 0 || nr >= N || nc < 0 || nc >= N) break;
			
			newMap[nr][nc] = 9;
		}
		
		return newMap;
	}
}

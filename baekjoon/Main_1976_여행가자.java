package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_1976_여행가자 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int M = Integer.parseInt(in.readLine());
		
		boolean[][] link = new boolean[N+1][N+1];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int j = 1; j <= N; j++) {
				if(st.nextToken().equals("1")) link[i][j] = true;
			}
		}
		
		int[] plan = new int[M];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 0; i < M; i++) {
			plan[i] = Integer.parseInt(st.nextToken());
		}
		
		boolean[] canVisite = new boolean[N+1];
		canVisite = bfs(link, canVisite, N, plan[0]);
		
		boolean isPoss = true;
		for (int i = 0; i < M; i++) {
			if(canVisite[plan[i]]) continue;
			isPoss = false;
			break;
		}
		
		System.out.print(isPoss ? "YES" : "NO");
	}
	
	public static boolean[] bfs(boolean[][] link, boolean[] canVisite, int N, int start) {
		Deque<Integer> q = new ArrayDeque<Integer>();
		
		q.offer(start);
		canVisite[start] = true;
		
		while(!q.isEmpty()) {
			int curr = q.poll();
			
			for (int i = 1; i <= N; i++) {
				if(link[curr][i] && !canVisite[i]) {
					q.offer(i);
					canVisite[i] = true;
				}
			}
		}
		
		return canVisite;
	}
}

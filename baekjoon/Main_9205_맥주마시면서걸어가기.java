package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_9205_맥주마시면서걸어가기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(in.readLine());
			st = new StringTokenizer(in.readLine(), " ");
			int[] home = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
			int[][] shop = new int[N+1][2]; // shop[N] 페스티벌 장소
			for (int i = 0; i <= N; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				shop[i][0] = Integer.parseInt(st.nextToken());
				shop[i][1] = Integer.parseInt(st.nextToken());
			}
			
			boolean[] visited = new boolean[N+1]; 
			boolean canArrive = false; // 페스티벌 장소 도착 여부 확인
			
			Deque<int[]> q = new ArrayDeque<int[]>();
			q.offer(home);
			
			while(!q.isEmpty()) { // 너비 우선 탐색
				int[] now = q.poll();
				
				for (int i = 0; i <= N; i++) {
					if(visited[i]) continue;
					
					if(calDist(now, shop[i]) <= 1000) { // 두 거리 사이가 1000m 이하인 경우만 이동 가능
						q.offer(shop[i]);
						visited[i] = true;
						
						if(i == N) { // 다음 장소가 페스티벌 장소인 경우
							canArrive = true;
							break;
						}
					}
				}
				
				if(canArrive) break; // 페스티벌 장소를 찾은 경우 탐색 종료
			}
			
			if(canArrive) sb.append("happy").append("\n"); // 도착할 수 있는 경우
			else sb.append("sad").append("\n"); // 도착하지 못하는 경우
		}
		out.write(sb.toString());
		out.flush();
		out.close();
	}
	
	public static int calDist(int[] a, int[] b) { // 맨해튼 거리 계산
		return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
	}
}

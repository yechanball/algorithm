package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_4485_녹색옷입은애가젤다지 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N; // 동굴의 행과 열 크기
		int[][] cave; // 동굴
		int[][] distance; // 거리
		int testCase = 0; // 테스트케이스 번호
		int[] dr = {0,1,0,-1}; // 우, 하, 좌, 상
		int[] dc = {1,0,-1,0};
		
		while(true) {
			N = Integer.parseInt(in.readLine());
			if(N == 0) break; // N=0인 경우 종료		
			sb.append("Problem ").append(++testCase).append(": ");
			cave = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				for (int j = 0; j < N; j++) {
					cave[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			distance = new int[N][N];
			for (int i = 0; i < N; i++) { // 모든 정점까지 거리 무한대로 초기화
				Arrays.fill(distance[i], Integer.MAX_VALUE);
			}
			
			// 다익스트라
			PriorityQueue<int[]> pQ = new PriorityQueue<>(new Comparator<int[]>() { // 가중치 우선순위 큐 [행, 열, 가중치]
				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[2] - o2[2];
				}
			});
			pQ.offer(new int[] {0, 0, cave[0][0]}); // 출발지 우선순위 큐에 삽입
			distance[0][0] = cave[0][0]; // 출발지는 초기 금액값으로 설정
			
			while(!pQ.isEmpty()) {
				int[] curr = pQ.poll(); // 현재 정점
				int currR = curr[0];
				int currC = curr[1];
				int currWeight = curr[2];
				
				if(currR == N-1 && currC == N-1) break; // 도착지에 도달한 경우 종료

				for (int i = 0; i < 4; i++) { // 인접 정점 탐색
					int nr = currR + dr[i];
					int nc = currC + dc[i];
					
					if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue; // 범위를 벗어나는 경우 패쓰!
					
					if(currWeight + cave[nr][nc] < distance[nr][nc]) { // 현재 정점을 거쳐가는 것이 더 적으면 갱신
						distance[nr][nc] = currWeight + cave[nr][nc];
						pQ.offer(new int[] {nr, nc, distance[nr][nc]});
					}
				}
			}
			
			sb.append(distance[N-1][N-1]).append("\n"); // (N-1, N-1) 도달시 비용 출력
		}
		out.write(sb.toString());
		out.flush();
		out.close();
	}
}

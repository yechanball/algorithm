package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_17940_지하철 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 지하철역의 수
		int M = Integer.parseInt(st.nextToken()); // 도착지의 번호
				
		int[] company = new int[N]; // 각 지하철 회사 정보
		for (int i = 0; i < N; i++) {
			company[i] = Integer.parseInt(in.readLine());
		}
		
		int[][] edge = new int[N][N]; // 간선 정보
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				edge[i][j] = Integer.parseInt(st.nextToken()); 
			}
		}
		
		int start = 0; // 시작 정점				
		int[] distance = new int[N]; // 시작정점으로부터 각 정점까지 거리
		Arrays.fill(distance, Integer.MAX_VALUE); // 모든 정점까지 거리 무한대(integer max value)로 초기화
		int[] transCnt = new int[N]; // 각 정점까지 환승횟수
		Arrays.fill(transCnt, Integer.MAX_VALUE); // 모든 정점까지 환승횟수 무한대(integer max value)로 초기화
		
		PriorityQueue<int[]> pQ = new PriorityQueue<int[]>(new Comparator<int[]>() { // 가중치가 가장 작은 순서 우선순위 큐
			@Override
			public int compare(int[] v1, int[] v2) {
				return v1[1] - v2[1];
			}
		});
		pQ.add(new int[] {start, 0, 0});
		distance[start] = 0; // 시작 정점 거리는 0으로 초기화
		transCnt[start] = 0; // 시작 정점 환승횟수는 0으로 초기화
		
		while(!pQ.isEmpty()) {
			int[] curr = pQ.poll();
			int currV = curr[0];
			int currW = curr[1];
			int currCnt = curr[2];

			for (int nextV = 0; nextV < N; nextV++) {
				if(edge[currV][nextV] == 0 || currV == nextV) continue; // 다음 정점과 연결되어 있지 않거나 자기 자신인 경우
				
				if(company[currV] == company[nextV]) { // 다음 정점이 같은 회사인 경우
					if(currCnt > transCnt[nextV]) continue; // 환승횟수가 같거나 크면 생략
					
					if(currCnt == transCnt[nextV]) {
						if(currW + edge[currV][nextV] < distance[nextV]) { // 환승횟수가 적으면 적은 거리로 갱신
							distance[nextV] = currW + edge[currV][nextV];
							pQ.offer(new int[] {nextV, distance[nextV], transCnt[nextV]}); // 인접 정점 큐에 삽입
						}
					}else{ // 환승횟수가 적으면 무조건 갱신
						distance[nextV] = currW + edge[currV][nextV];
						transCnt[nextV] = currCnt;
						pQ.offer(new int[] {nextV, distance[nextV], transCnt[nextV]}); // 인접 정점 큐에 삽입						
					}
				}else { // 다음 정점이 다른 회사인 경우
					if(currCnt >= transCnt[nextV]) continue; // 환승횟수가 같거나 크면 생략
					
					if(currCnt + 1 == transCnt[nextV]) {
						if(currW + edge[currV][nextV] < distance[nextV]) { // 환승횟수가 같다면 적은 거리로 갱신
							distance[nextV] = currW + edge[currV][nextV];
							pQ.offer(new int[] {nextV, distance[nextV], transCnt[nextV]}); // 인접 정점 큐에 삽입	
						}
					}else { // 환승횟수가 적으면 무조건 갱신
						distance[nextV] = currW + edge[currV][nextV];
						transCnt[nextV] = currCnt + 1;
						pQ.offer(new int[] {nextV, distance[nextV], transCnt[nextV]}); // 인접 정점 큐에 삽입	
					}
				}	
			}	
		}
		
		System.out.print(transCnt[M] + " " + distance[M]);
	}
}

package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_5972_택배배송 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken()); // 헛간의 수
		int M = Integer.parseInt(st.nextToken()); // 길의 개수
		List<int[]>[] adjList = new ArrayList[N+1]; // 각 헛간에 인접한 헛간 정보를 담는 리스트 배열 생성
		for (int i = 1; i <= N; i++) {
			adjList[i] = new ArrayList<int[]>();
		}
		int[] cost = new int[N+1]; // 각 헛간까지 여물의 비용 정보를 담는 배열
		Arrays.fill(cost, Integer.MAX_VALUE); // 모든 헛간까지 드는 여물의 비용을 무한대로 초기화
		
		int A, B, C; // A 헛간, B 헛간, A-B 사이에 있는 소들의 수
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine()," ");
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			adjList[A].add(new int[] {B, C}); // 인접 헛간 리스트에 헛간 번호, 비용 순으로 저장
			adjList[B].add(new int[] {A, C});
		}
		
		// 다익스트라
		PriorityQueue<int[]> pQ = new PriorityQueue<>(new Comparator<int[]>() { // 적은 비용 우선순위 큐
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
		});
		pQ.offer(new int[] {1, 0});
		cost[1] = 0; // 시작 헛간 비용 0으로 초기화
		
		while(!pQ.isEmpty()) {
			int[] curr = pQ.poll();
			int currSpot = curr[0];
			int currCost = curr[1];
			
			if(currSpot == N) break; // 현재 헛간이 도착 헛간라면 탐색 종료
			
			for (int[] next : adjList[currSpot]) {
				int nextSpot = next[0];
				int nextCost = next[1];
				
				if(currCost + nextCost < cost[nextSpot]) { // 현재 헛간을 거쳐가는 것이 더 비용이 적은 경우 갱신
					cost[nextSpot] = currCost + nextCost;
					pQ.offer(new int[] {nextSpot, cost[nextSpot]});
				}
			}
		}
		
		System.out.print(cost[N]);
	}
}

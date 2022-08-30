package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_11779_최소비용구하기2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(in.readLine()); // 도시의 수
		int M = Integer.parseInt(in.readLine()); // 버스의 개수
		List<int[]>[] adjList = new ArrayList[N+1]; // 각 도시에 인접한 도시 정보를 담는 리스트 배열
		int[] preCity = new int[N+1]; // 바로 직전 도시 정보를 담는 배열
		int[] cost = new int[N+1]; // 각 도시까지 비용 정보를 담는 배열
		Arrays.fill(cost, Integer.MAX_VALUE); // 모든 도시까지 드는 비용을 무한대로 초기화
		
		int from, to, money; // 버스 출발 도시, 도착 도시, 비용
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine()," ");
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			money = Integer.parseInt(st.nextToken());
			if(adjList[from] == null) adjList[from] = new ArrayList<int[]>(); // 인접 도시 리스트가 생성되지 않은 경우 생성하기
			adjList[from].add(new int[] {to, money}); // 인접 도시 리스트에 도시 번호, 비용 순으로 저장
		}
		
		st = new StringTokenizer(in.readLine()," ");		
		int start = Integer.parseInt(st.nextToken()); // 시작 도시
		int goal = Integer.parseInt(st.nextToken()); // 도착 도시
		
		// 다익스트라
		PriorityQueue<int[]> pQ = new PriorityQueue<>(new Comparator<int[]>() { // 적은 비용 우선순위 큐, {도시번호, 비용, 누적 도시 탐색 카운트}
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
		});
		pQ.offer(new int[] {start, 0, 1});
		cost[start] = 0; // 시작도시 비용 0으로 초기화
		int cnt = 0;
		
		while(!pQ.isEmpty()) {
			int[] curr = pQ.poll();
			int currCity = curr[0];
			int currCost = curr[1];
			int currCnt = curr[2];
			
			if(currCity == goal) {
				cnt = currCnt;
				sb.append(cost[goal]).append("\n").append(cnt).append("\n"); // 최소 비용과 경로에 포함되어 있는 도시 개수 출력
				break; // 현재 도시가 도착 도시라면 탐색 종료
			}
			
			if(adjList[currCity] == null) continue; // 현재 도시의 인접 리스트가 생성되지 않은 경우
			
			for (int[] next : adjList[currCity]) {
				int nextCity = next[0];
				int nextCost = next[1];
				
				if(currCost + nextCost < cost[nextCity]) { // 현재 도시를 거쳐가는 것이 더 비용이 적은 경우 갱신
					cost[nextCity] = currCost + nextCost;
					preCity[nextCity] = currCity; // 다음 도시 인덱스에는 이전 도시 번호가 저장됨
					pQ.offer(new int[] {nextCity, cost[nextCity], currCnt+1});
				}
			}
		}
		
		int num = goal;
		Deque<Integer> route = new ArrayDeque<>();
		for (int i = 0; i < cnt; i++) { // 도시 경로 찾기
			route.push(num);
			num = preCity[num];
		}
		for (int i = 0; i < cnt; i++) { // 도시 경로 출력
			sb.append(route.pop()).append(" ");
		}
		out.write(sb.toString());
		out.flush();
		out.close();
	}
}

package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1238_파티 {
	static class Road {
		int to;
		int time;

		public Road(int to, int time){
			this.to = to;
			this.time = time;
		}
	}

	static ArrayList<Road>[] adjList;
	static int maxTime = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());

		adjList = new ArrayList[N+1];
		for (int i = 1; i <= N; i++){
			adjList[i] = new ArrayList<Road>();
		}

		for (int i = 0; i < M; i++){
			st = new StringTokenizer(in.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());

			adjList[from].add(new Road(to, time));
		}

		for (int i = 1; i <= N; i++){
			int time = dijkstra(N, i, X) + dijkstra(N, X, i);
			if(time > maxTime) maxTime = time;
		}

		System.out.print(maxTime);
	}

	public static int dijkstra(int N, int start, int goal) {
		int[] time = new int[N+1];
		Arrays.fill(time, Integer.MAX_VALUE);

		PriorityQueue<Road> pQ = new PriorityQueue<>(new Comparator<Road>() {
			@Override
			public int compare(Road o1, Road o2) {
				return o1.time - o2.time;
			}
		});
		pQ.offer(new Road(start, 0));
		time[start] = 0;

		while(!pQ.isEmpty()) {
			Road curr = pQ.poll();

			if(curr.to == goal) break;

			for (Road next : adjList[curr.to]) {
				if(curr.time + next.time < time[next.to]) {
					time[next.to] = curr.time + next.time;
					pQ.offer(new Road(next.to, time[next.to]));
				}
			}
		}

		return time[goal];
	}
}

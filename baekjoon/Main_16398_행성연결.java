package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_16398_행성연결 {
	static class Planet {
		int num;
		int cost;
		
		public Planet(int num, int cost) {
			this.num = num;
			this.cost = cost;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[][] C = new int[N+1][N+1];
		
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int j = 1; j <= N; j++) {
				C[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		boolean[] visited = new boolean[N+1];
		int[] minEdge = new int[N+1];
		Arrays.fill(minEdge, Integer.MAX_VALUE);
		minEdge[1] = 0;
		
		long costSum = 0;
		int cnt = 0;
		
		PriorityQueue<Planet> pq = new PriorityQueue<>((p1, p2) -> p1.cost - p2.cost);
		pq.offer(new Planet(1, minEdge[1]));
		
		while (true) {
			Planet planet = pq.poll();
			
			if (visited[planet.num]) continue;
			
			visited[planet.num] = true;
			costSum += planet.cost;
			if (++cnt == N) break;
			
			for (int i = 1; i <= N; i++) {
				if(visited[i] || C[planet.num][i] == 0) continue;
				
				if (minEdge[i] > C[planet.num][i]) {
					minEdge[i] = C[planet.num][i];
					pq.offer(new Planet(i, minEdge[i]));
				}
			}
		}
		System.out.print(costSum);
	}
}

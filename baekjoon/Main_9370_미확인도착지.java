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

public class Main_9370_미확인도착지 {
	static final int INF = 10_000_000;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(in.readLine());
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(in.readLine());
			
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(in.readLine());
			
			int s = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			
			int[] distance = new int[n+1];
			Arrays.fill(distance, INF);
			
			int[][] edge = new int[n+1][n+1];
			for (int i = 0; i <= n; i++) {
				Arrays.fill(edge[i], INF);
			}

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int dist = Integer.parseInt(st.nextToken());
				
				edge[from][to] = edge[to][from] = dist*2; 
			}
			edge[g][h]--;
			edge[h][g]--;
			
			int[] goalList = new int[t];
			for (int i = 0; i < t; i++) {
				goalList[i] = Integer.parseInt(in.readLine());
			}
			Arrays.sort(goalList);
			
			boolean[] visited = new boolean[n+1];
			PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() { 
				@Override
				public int compare(int[] v1, int[] v2) {
					return v1[1] - v2[1];
				}
			});
			pq.add(new int[] {s, 0});
			distance[s] = 0;
			
			while(!pq.isEmpty()) {
				int[] tmp = pq.poll();
				int curr = tmp[0];
				int dist = tmp[1];
				
				if(visited[curr]) continue;
				visited[curr] = true;
				
				for (int next = 1; next <= n; next++) {
					if(!visited[next] && dist + edge[curr][next] < distance[next]) {
						distance[next] = dist + edge[curr][next];
						pq.offer(new int[] {next, distance[next]});
					}
				}	
			}
			
			for (int num : goalList) {
				if(distance[num] % 2 == 1) out.write(num + " ");
			}
			out.write("\n");
		}
		out.flush();
		out.close();
	}
}

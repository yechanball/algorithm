package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_10216_CountCircleGroups {
	static class Area {
		int x, y, r;
		
		public Area(int x, int y, int r) {
			this.x = x;
			this.y = y;
			this.r = r;
		}
	}
	
	static ArrayList<Integer>[] adjList;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(in.readLine());
			
			Area[] areaList = new Area[N+1];
			for (int i = 1; i <= N; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				areaList[i] = new Area(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			
			adjList = new ArrayList[N+1];
			for (int i = 1; i <= N; i++) {
				adjList[i] = new ArrayList<Integer>();
			}
			
			for (int i = 1; i <= N; i++) {
				for (int j = i+1; j <= N; j++) {
					if(dist(areaList[i], areaList[j]) <= (areaList[i].r + areaList[j].r) * (areaList[i].r + areaList[j].r)) {
						adjList[i].add(j);
						adjList[j].add(i);				
					}
				}
			}
			
			int groupCnt = 0;
			visited = new boolean[N+1];
			for (int i = 1; i <= N; i++) {
				if(visited[i]) continue;
				
				bfs(i);
				groupCnt++;
			}
	
			sb.append(groupCnt + "\n");
		}
		out.write(sb.toString());
		out.flush();
		out.close();
	}
	
	public static int dist(Area a1, Area a2) {
		return (a2.x - a1.x) * (a2.x - a1.x) + (a2.y - a1.y) * (a2.y - a1.y);
	}
	
	public static void bfs(int start) {
		Deque<Integer> q = new ArrayDeque<Integer>();
		
		q.offer(start);
		visited[start] = true;
		
		while(!q.isEmpty()) {
			int curr = q.poll();
			
			for (int next : adjList[curr]) {
				if(!visited[next]) {
					q.offer(next);
					visited[next] = true;
				}
			}
		}
	}
}

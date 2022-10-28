package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1647_도시분할계획 {
	static int[] parents;
	static List<Edge> edgeList;
	
	static class Edge{
		int from;
		int to;
		int weight;
		
		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		parents = new int[N+1];
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}
		
		edgeList = new ArrayList<Edge>();
		int a, b, c;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			edgeList.add(new Edge(a, b, c));
		}
		
		Collections.sort(edgeList, new Comparator<Edge>() {
			@Override
			public int compare(Edge e1, Edge e2) {
				return e1.weight - e2.weight;
			}
		});
		
		long minSum = 0;
		int cnt = 0;
		for(Edge edge : edgeList) {
			if(union(edge.from, edge.to)) {
				minSum += edge.weight;
				cnt++;
				if(cnt == N-2) break;
			}
		}
		
		System.out.print(minSum);
	}
	
	public static int find(int node) {
		if(parents[node] == node) return node;
		return parents[node] = find(parents[node]);
	}
	
	public static boolean union(int node1, int node2) {
		int root1 = find(node1);
		int root2 = find(node2);
		
		if(root1 == root2) return false;
		
		parents[root2] = root1;
		return true;
	}
}
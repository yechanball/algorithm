package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1167_트리의지름 {
	static class Node {
		int to;
		int weight;
		
		public Node(int to, int weight) {
			super();
			this.to = to;
			this.weight = weight;
		}
	}
	
	static int N, farNode = 1, maxWeight = 0;
	static List<Node>[] adjNodes; 
	static boolean[] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(in.readLine());
		adjNodes = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int f = Integer.parseInt(st.nextToken());			
			adjNodes[f] = new ArrayList<Node>();
			while(true) {
				int t = Integer.parseInt(st.nextToken());
				if(t == -1) break;
				int w = Integer.parseInt(st.nextToken());
				adjNodes[f].add(new Node(t, w)); 
			}
		}
		
		visited = new boolean[N+1];
		dfs(1, 0);
		
		maxWeight = 0;
		visited = new boolean[N+1];
		dfs(farNode, 0);
		
		System.out.print(maxWeight);
	}
	
	public static void dfs(int curr, int weightSum) {
		if(visited[curr]) return;
		
		visited[curr] = true;
		
		if(weightSum > maxWeight) {
			maxWeight = weightSum;
			farNode = curr;
		}
		
		for(Node next : adjNodes[curr]) {
			dfs(next.to, weightSum + next.weight);
		}
	}
}

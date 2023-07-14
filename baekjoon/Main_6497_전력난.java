package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_6497_전력난 {
	static int[] parents;
	static int m, n;
	static Edge[] edgeList;
	
	static class Edge implements Comparable<Edge>{
		int x;
		int y;
		int z;
		
		public Edge(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}

		@Override
		public int compareTo(Edge e) {
			return this.z - e.z;
		}		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		while(true) {
			st = new StringTokenizer(in.readLine());
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			
			if(m == 0 && n == 0) break;
			
			make();
			edgeList = new Edge[n];
			
			long totalZ = 0;
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(in.readLine());
				edgeList[i] = new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
				totalZ += edgeList[i].z;
			}
			
			Arrays.sort(edgeList);
			
			long usedZ = 0;
			
			for (Edge edge : edgeList) {
				if(union(edge.x, edge.y)) {
					usedZ += edge.z;
				}
			}
			
			out.write((totalZ - usedZ) + "\n");
		}
		out.flush();
		out.close();
	}
	
	static void make() {
		parents = new int[m+1];
		for (int i = 1; i <= m; i++) {
			parents[i] = i;
		}
	}
	
	static int find(int a) {
		if(parents[a] == a) return a;
		
		return parents[a] = find(parents[a]);
	}
	
	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot == bRoot) return false;
		
		parents[bRoot] = aRoot;
		return true;
	}
}

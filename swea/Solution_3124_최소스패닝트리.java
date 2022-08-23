package algorithm.swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_3124_최소스패닝트리 {
	static class Edge implements Comparable<Edge>{ // 간선 정보
		int from; // 시작 정점
		int to; // 도착 정점
		int weight; // 가중치
		
		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge e) {
			return this.weight - e.weight;
		}		
	}
	
	static int[] parents;
	static int V, E;
	static Edge[] edgeList;
	
	static void make() { // 크기가 1인 서로소 집합 생성
		parents = new int[V+1];
		for (int i = 1; i <= V; i++) {
			parents[i] = i;
		}
	}
	
	static int find(int a) { // 대표 찾기
		if(parents[a] == a) return a;
		
		return parents[a] = find(parents[a]); // 대표를 부모로 반환
	}
	
	static boolean union(int a, int b) { // a, b 합치기
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot == bRoot) return false; // a와 b의 루트가 같으면 union 불가능
		
		parents[bRoot] = aRoot;
		return true;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(in.readLine(), " ");
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			make(); // 정점 배열 생성
			edgeList = new Edge[E];
			for (int i = 0; i < E; i++) { // 간선 정보 입력
				st = new StringTokenizer(in.readLine(), " ");
				edgeList[i] = new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			
			Arrays.sort(edgeList); // 가중치가 낮은 간선부터 오름차순으로 정렬
			
			long spWeightSum = 0;
			int spCnt = 0;
			
			for (Edge edge : edgeList) { // 가중치가 낮은 간선부터 정점 연결
				if(union(edge.from, edge.to)) {
					spWeightSum += edge.weight;
					spCnt++;
				}
			}
			sb.append(spWeightSum).append("\n");
		}
		out.write(sb.toString());
		out.flush();
		out.close();
	}
}

// 메모리 초과 -> 메모리 사용을 줄일 방법을 생각해보자.

package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_2887_행성터널 {
	static int V; // 정점 개수
	static int[] parents; // 각 정점의 부모 저장 배열
	static List<Integer> planet; // 행성 좌표 배열
	
	static class Edge implements Comparable<Edge> { // 간선 정보, 우선순위 큐를 위해 Comparable 사용
		int from; // 시작 정점
		int to; // 도착 정점
		int weight; // 가중치
		
		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge edge) {
			return this.weight < edge.weight ? -1 : 1;
		}			
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		V = Integer.parseInt(in.readLine()); // 정점 개수 입력
		
		planet = new ArrayList<Integer>(); // 정점 좌표 저장할 리스트 생성
		for (int i = 0; i < V; i++) { // 정점 좌표 정보 입력
			st = new StringTokenizer(in.readLine(), " ");
			planet.add(Integer.parseInt(st.nextToken())); // X좌표
			planet.add(Integer.parseInt(st.nextToken())); // Y좌표
			planet.add(Integer.parseInt(st.nextToken())); // Z좌표
		}
		
		make(); // 정점 배열 생성
		
		PriorityQueue<Edge> edgeList = new PriorityQueue<Edge>(); // 간선정보를 담을 작은 가중치 우선순위 큐 생성
		for (int i = 0; i < V; i++) { // 두 정점끼리 거리를 계산하여 간선 정보 생성 및 저장
			for (int j = i+1; j < V; j++) {
				edgeList.add(new Edge(i+1, j+1, calcDistance(i, j)));
			}
		}
		
		int edgeCnt = 0; // 간선 개수
		int spWeightSum = 0; // 모든 간선의 가중치 합
		while(!edgeList.isEmpty()) {  // 가중치가 낮은 간선부터 정점 연결
			Edge edge = edgeList.poll();
		
			if(union(edge.from, edge.to)) {
				spWeightSum += edge.weight;
				edgeCnt++;
				
				if(edgeCnt == V-1) break; // 모든 정점을 연결하면 종료
			}
		}
		
		System.out.print(spWeightSum);
	}
	
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
	
	static int calcDistance(int num1, int num2) { // 두 정점사이 거리 계산
		int idx1 = num1*3;
		int x1 = planet.get(idx1);
		int y1 = planet.get(idx1+1);
		int z1 = planet.get(idx1+2);
		
		int idx2 = num2*3;
		int x2 = planet.get(idx2);
		int y2 = planet.get(idx2+1);
		int z2 = planet.get(idx2+2);
		
		return Math.min(Math.min(Math.abs(x1-x2), Math.abs(y1-y2)), Math.abs(z1-z2));
	}
}

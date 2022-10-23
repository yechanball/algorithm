package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_2887_행성터널 {
	static int V; // 정점 개수
	static int[] parents; // 각 정점의 부모 저장 배열
	static List<Planet> planetList; // 행성 좌표 배열
	static PriorityQueue<Edge> edgeList = new PriorityQueue<Edge>(); // 간선 가중치 우선순위 큐
		
	static class Planet { // 행성 좌표 정보
		int no; // 행성 번호
		int x; // X좌표
		int y; // Y좌표
		int z; // Z좌표
		
		public Planet(int no, int x, int y, int z) {
			super();
			this.no = no;
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}
	
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
		
		planetList = new ArrayList<Planet>(); // 정점 좌표 저장할 리스트 생성
		for (int i = 0; i < V; i++) { // 정점 좌표 정보 입력
			st = new StringTokenizer(in.readLine(), " ");
			planetList.add(new Planet(i+1, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()))); 
		}
		
		make(); // 정점 배열 생성
		
		makeEdge(); // 행성 거리 계산하여 간선 정보 생성
		
		// 크루스칼 알고리즘
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
	
	private static void makeEdge() { // 두 정점 사이의 간선 정보 생성 및 저장
		// X 좌표 기준 정렬
		Collections.sort(planetList, new Comparator<Planet>() {
			@Override
			public int compare(Planet p1, Planet p2) {
				return p1.x - p2.x;
			}
		});
		for (int i = 0; i < V-1; i++) {
			edgeList.add(new Edge(planetList.get(i).no, planetList.get(i+1).no, planetList.get(i+1).x - planetList.get(i).x));
		}
		
		// Y 좌표 기준 정렬
		Collections.sort(planetList, new Comparator<Planet>() {
			@Override
			public int compare(Planet p1, Planet p2) {
				return p1.y - p2.y;
			}
		});	
		for (int i = 0; i < V-1; i++) {
			edgeList.add(new Edge(planetList.get(i).no, planetList.get(i+1).no, planetList.get(i+1).y - planetList.get(i).y));
		}
		
		// Z 좌표 기준 정렬
		Collections.sort(planetList, new Comparator<Planet>() {
			@Override
			public int compare(Planet p1, Planet p2) {
				return p1.z - p2.z;
			}
		});	
		for (int i = 0; i < V-1; i++) {
			edgeList.add(new Edge(planetList.get(i).no, planetList.get(i+1).no, planetList.get(i+1).z - planetList.get(i).z));
		}
	}
}

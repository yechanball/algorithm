package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1774_우주신과의교감 {
	static int V, E; // 정점 개수, 간선 개수
	static int[] parents; // 각 정점의 부모 저장 배열
	static List<double[]> godPos; // 좌표 배열
	static List<Edge> edgeList; // 간선 정보 배열
	
	static class Edge{ // 간선 정보
		int from; // 시작 정점
		int to; // 도착 정점
		double weight; // 가중치
		
		public Edge(int from, int to, double weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		
		V = Integer.parseInt(st.nextToken()); // 정점 개수 입력
		int M = Integer.parseInt(st.nextToken()); // 이미 연결된 간선의 개수
		
		godPos = new ArrayList<double[]>(); // 정점 좌표 저장할 리스트 생성
		for (int i = 0; i < V; i++) { // 정점 좌표 정보 입력
			st = new StringTokenizer(in.readLine(), " ");
			godPos.add(new double[] {Double.parseDouble(st.nextToken()),Double.parseDouble(st.nextToken())});
		}
		
		make(); // 정점 배열 생성
		
		edgeList = new ArrayList<Edge>(); // 간선 정보 배열 생성
		for (int i = 0; i < V; i++) { // 두 정점끼리 거리를 계산하여 간선 정보 생성 및 저장
			for (int j = i+1; j < V; j++) {
				edgeList.add(new Edge(i+1, j+1, calcDistance(i, j)));
			}
		}
		
		Collections.sort(edgeList, new Comparator<Edge>() { // 가중치가 낮은 간선부터 오름차순으로 정렬
			@Override
			public int compare(Edge e1, Edge e2) {
				return e1.weight < e2.weight ? -1 : 1;
			} 
		});
		
		int a, b;
		for (int i = 0; i < M; i++) { // 이미 연결되어 있는 간선 연결 처리하기
			st = new StringTokenizer(in.readLine(), " ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			union(a, b);
		}
		
		double spWeightSum = 0; // 모든 간선의 가중치 합
		for (Edge edge : edgeList) { // 가중치가 낮은 간선부터 정점 연결
			if(union(edge.from, edge.to)) {
				spWeightSum += edge.weight;
			}
		}
		
		out.write(String.format("%.2f", spWeightSum));
		out.flush();
		out.close();
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
	
	static double calcDistance(int num1, int num2) { // 두 정점사이 거리 계산
		double[] star1 = godPos.get(num1);
		double[] star2 = godPos.get(num2);
		
		double distance = Math.sqrt((star1[0]-star2[0])*(star1[0]-star2[0]) + (star1[1]-star2[1])*(star1[1]-star2[1]));
		
		return distance;
	}
}

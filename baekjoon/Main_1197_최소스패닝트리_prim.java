package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1197_최소스패닝트리_prim {
	static class Node { // 정점 클래스(연결성 고려)
		int vertex, weight; // 정점 번호, 간선 가중치
		Node next; // 가리키는 다음 정점

		public Node(int vertex, int weight, Node next) {
			this.vertex = vertex;
			this.weight = weight;
			this.next = next;
		}
	}
	
	static class Vertex { // 정점 클래스
		int no, weight;

		public Vertex(int no, int weight) {
			this.no = no;
			this.weight = weight;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(in.readLine(), " ");
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		Node[] adjList = new Node[V+1]; // 각 정점별 인접리스트, 정점은 1번부터 V까지
		
		for (int i = 0; i < E; i++) { // 간선 정보 입력, from to weight
			st = new StringTokenizer(in.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			adjList[from] = new Node(to, weight, adjList[from]);
			adjList[to] = new Node(from, weight, adjList[to]);
		}

		int[] minEdge = new int[V+1]; // 각 정점기준에서 스패닝트리에 포함된 정점과의 간선 최소 가중치
		boolean[] visited = new boolean[V+1]; // 스패닝트리에 포함 체크
		Arrays.fill(minEdge, Integer.MAX_VALUE);
		
		minEdge[1] = 0; // 1번 정점을 스패닝트리 시작점으로, 1번 정점 가중치는 0
		long spWeightSum = 0; // 최소신장트리 가중치 누적
		
		PriorityQueue<Vertex> pQ = new PriorityQueue<>((v1, v2) -> v1.weight - v2.weight); // 가중치 오름차순으로 저장되는 우선순위큐
		pQ.offer(new Vertex(1, minEdge[1]));
		
		int cnt = 0;  // 신장트리에 추가된 정점 수 
		while (true) {
			Vertex minVertex = pQ.poll(); // 기준 정점에서 다른 정점까지 가중치 중 최소 가중치 정점 선택
			
			if (visited[minVertex.no]) // 이미 포함된 정점이면 넘어가기
				continue;

			visited[minVertex.no] = true; // 스패닝 트리에 포함시키기
			spWeightSum += minVertex.weight;
			if (++cnt == V) 
				break;

			for (Node temp = adjList[minVertex.no]; temp != null; temp = temp.next) { // 스패닝 트리에 포함된 정점 기준 인접한 정점들 확인
				if (!visited[temp.vertex] && minEdge[temp.vertex] > temp.weight) { // 포함되지 않은 정점들 가중치를 비교해서 최소 가중치로 갱신
					minEdge[temp.vertex] = temp.weight;
					pQ.offer(new Vertex(temp.vertex, minEdge[temp.vertex]));
				}
			}
		}
	
		out.write(Long.toString(spWeightSum));
		out.flush();
		out.close();
	}
}

package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main_24484_알고리즘수업_깊이우선탐색6 {
	static int N, M, R; // N:정점의 개수, M:간선의 개수, R:탐색을 시작할 정점의 번호
	static long T; // T: 탐색시간
	static List<Integer>[] list; // 노드의 인접 노드 정보를 저장할 배열
	static long[] visited; // 방문 배열
	static long[] time; // 방문시간 배열
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N+1];
		visited = new long[N+1];
		time = new long[N+1];
		int from, to;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			if(list[from] == null) list[from] = new ArrayList<Integer>();
			list[from].add(to);
			if(list[to] == null) list[to] = new ArrayList<Integer>();
			list[to].add(from);
		}
		
		long depth = 1;
		T = 1;
		dfs(R, depth); // DFS
		
		BigInteger answer = new BigInteger("0");
		for (int i = 1; i <= N; i++) {
			long tmp = (visited[i]-1)*time[i];
			answer = answer.add(new BigInteger(Long.toString(tmp)));
		}
		
		out.write(answer.toString());
		out.flush();
		out.close();
	}
	
	public static void dfs(int curr, long depth) { // DFS 재귀 메서드
		visited[curr] = depth; // 현재 노드 방문 처리
		time[curr] = T++;
		
		if(list[curr] == null) return;
			
		list[curr].sort(new Comparator<Integer>() { // 인접한 노드 번호가 작은것부터 내림차순으로 정렬
			@Override
			public int compare(Integer n1, Integer n2) {
				return n2 - n1;
			}
		});
		
		for (int next : list[curr]) { // 인접 노드 탐색
			if(visited[next] == 0) // 방문기록이 없다면 
				dfs(next, depth+1); // 재귀 호출			
		}
	}
}

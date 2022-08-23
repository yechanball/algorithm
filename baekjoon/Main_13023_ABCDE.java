package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_13023_ABCDE {
	static int N; // 사람의 수
	static List<Integer>[] nodes;
	static boolean[] visited;
	static boolean isFriend = false;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 사람의 수 입력
		int M = Integer.parseInt(st.nextToken()); // 간선의 수 입력
		
		nodes = new ArrayList[N]; // 노드 별 인접 리스트를 관리할 배열 생성
		for (int i = 0; i < N; i++) {
			nodes[i] = new ArrayList<Integer>();
		}
		
		int from, to;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			nodes[from].add(to);
			nodes[to].add(from);
		}
		
		visited = new boolean[N];
		for (int i = 0; i < N; i++) { // 각 노드에서 출발해서 깊이 탐색
			visited[i] = true;
			dfs(i, 0);
			if(isFriend) break; // 친구 관계가 완성되면 더 이상 탐색 X
			visited[i] = false;
		}
		
		int answer = (isFriend) ? 1 : 0; // 친구관계가 있으면 1, 없으면 0
		out.write(Integer.toString(answer));
		out.flush();
		out.close();
	}
	
	public static void dfs(int node, int depth) {
		if(depth == 4) { // 깊이가 4가 되면 종료
			isFriend = true;
			return;
		}
		
		for(int i = 0, size = nodes[node].size(); i < size; i++) { // 인접 노드 탐색
			int adjNode = nodes[node].get(i); // 인접 노드 번호
			if(!visited[adjNode]) {
				visited[adjNode] = true;
				dfs(adjNode, depth+1);
				visited[adjNode] = false;				
			}
		}
	}
}

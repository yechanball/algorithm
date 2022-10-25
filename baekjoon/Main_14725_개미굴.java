package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_14725_개미굴 {
	static StringBuilder sb = new StringBuilder();

	static class Node { // 노드 클래스
		Map<String, Node> childNode = new HashMap<String, Node>(); // 자식 노드 정보
	}
	
	static class Trie { // 트라이 클래스
		Node root = new Node(); // 루트 노드 생성
		
		void insert(String str) { // 문자열 삽입
			Node node = this.root;
			
			StringTokenizer st = new StringTokenizer(str, " ");
			int K = Integer.parseInt(st.nextToken());
			for (int i = 0; i < K; i++) {
				String word = st.nextToken();
				node = node.childNode.computeIfAbsent(word, key -> new Node());
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(in.readLine());
		
		Trie trie = new Trie();
		for (int i = 0; i < N; i++) { // 문자열 삽입
			trie.insert(in.readLine());
		}
		
		for (Map.Entry<String, Node> next : trie.root.childNode.entrySet()) {
			sb.append(next.getKey()).append("\n");
			dfs(next.getValue(), 1);
		}
		
		out.write(sb.toString());
		out.flush();
		out.close();
	}

	private static void dfs(Node node, int depth) { // 깊이 우선 탐색
		Object[] words = node.childNode.keySet().toArray();
		Arrays.sort(words); // 오름차순 정렬
		
		for (Object next : words) {
			for (int i = 0; i < depth; i++) {
				sb.append("--");
			}
			sb.append(next).append("\n");
			dfs(node.childNode.get(next), depth+1);
		}
	}
}

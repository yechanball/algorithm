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

public class Main_7432_디스크트리 {
	static StringBuilder sb = new StringBuilder();

	static class Node {
		Map<String, Node> childNode = new HashMap<String, Node>();
	}
	
	static class Trie {
		Node root = new Node();
		
		void insert(String input) {
			Node node = this.root;
			StringTokenizer st = new StringTokenizer(input, "\\");
			while(st.hasMoreTokens()) {
				node = node.childNode.computeIfAbsent(st.nextToken(), key -> new Node());
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(in.readLine());
		
		Trie trie = new Trie();
		for (int i = 0; i < N; i++) {
			trie.insert(in.readLine());
		}
		
		dfs(trie.root, 0);
		
		out.write(sb.toString());
		out.flush();
		out.close();
	}

	private static void dfs(Node node, int depth) {
		Object[] words = node.childNode.keySet().toArray();
		Arrays.sort(words);
		
		for (Object next : words) {
			for (int i = 0; i < depth; i++) {
				sb.append(" ");
			}
			sb.append(next).append("\n");
			if (node.childNode.get(next) != null) {
				dfs(node.childNode.get(next), depth+1);				
			}
		}
	}
}
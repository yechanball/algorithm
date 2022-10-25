package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_14426_접두사찾기 {
	static class Node { // 노드 클래스
		Map<Character, Node> childNode = new HashMap<Character, Node>(); // 자식 노드 정보
		boolean isEnd; // true(단말 노드), false(자식 노드 존재)
	}
	
	static class Trie { // 트라이 클래스
		Node root = new Node(); // 루트 노드 생성
		
		void insert(String str) { // 문자열 삽입
			Node node = this.root; // 시작은 루트
			
			for (int i = 0, len = str.length(); i < len; i++) { // 이미 존재하는 문자는 해당 노드를, 존재하지 않으면 새로운 문자를 가지고 있는 노드 추가
				node = node.childNode.computeIfAbsent(str.charAt(i), key -> new Node());
			}
			
			node.isEnd = true; // 단말 노드 체크
		}
		
		boolean find(String str) { // 문자열 찾기
			Node node = this.root; // 시작은 루트
			
			for (int i = 0, len = str.length(); i < len; i++) { // 문자가 있는지 확인하고, 없으면(null) false 반환
				node = node.childNode.getOrDefault(str.charAt(i), null);
				if(node == null) return false;
			}
			
			return true;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// 트라이 탐색
		Trie trie = new Trie();
		for (int i = 0; i < N; i++) {
			trie.insert(in.readLine());
		}
		
		int cnt = 0;
		for (int i = 0; i < M; i++) {
			if(trie.find(in.readLine())) {
				cnt++;
			}	
		}
		
		// 단순 반복문 탐색
//		List<String> list = new ArrayList<String>();
//		for (int i = 0; i < N; i++) {
//			list.add(in.readLine());
//		}
//		int cnt = 0;
//		for (int i = 0; i < M; i++) {
//			String input = in.readLine();
//			for(String str : list) {
//				if(input.equals(str.substring(0, input.length()))) {
//					cnt++;
//					break;
//				}
//			}
//		}
		
		System.out.print(cnt);
	}
}

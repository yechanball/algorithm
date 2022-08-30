package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_1991_트리순회 {
	static StringBuilder sb = new StringBuilder();
	static int[][] node = new int[26][2]; // 노드 정보, 0번이 A
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(in.readLine());
		int p, l, r;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			p = st.nextToken().charAt(0)-'A';
			l = st.nextToken().charAt(0)-'A';
			r = st.nextToken().charAt(0)-'A';
			node[p][0] = l;
			node[p][1] = r;
		}
		
		preOrder(0); // 전위 순회
		sb.append("\n");
		inOrder(0); // 중위 순회
		sb.append("\n");
		postOrder(0); // 후위 순회		
		
		out.write(sb.toString());
		out.flush();
		out.close();
	}
	
	public static void preOrder(int cur) { // 전위 순회
		if(cur == -19) return; // .인 경우
		
		sb.append((char)(cur+'A')); // 출력
		preOrder(node[cur][0]); // 왼쪽 자식
		preOrder(node[cur][1]); // 오른쪽 자식
	}
	
	public static void inOrder(int cur) { // 중위 순회
		if(cur == -19) return; // .인 경우
		
		inOrder(node[cur][0]); // 왼쪽 자식
		sb.append((char)(cur+'A')); // 출력
		inOrder(node[cur][1]); // 오른쪽 자식
	}
	
	public static void postOrder(int cur) { // 후위 순회
		if(cur == -19) return; // .인 경우
		
		postOrder(node[cur][0]); // 왼쪽 자식
		postOrder(node[cur][1]); // 오른쪽 자식
		sb.append((char)(cur+'A')); // 출력
	}
}

package algorithm.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1233_사칙연산유효성검사 {
	static char[] tree;
	static int N;
	
	public static boolean searchChild(int nodeNum, char parents) {
		if(nodeNum > N) { // 이전노드가 단말노드인 경우
			if(Character.isDigit(parents)) return true; // 단말노드가 숫자면 정상
			else return false; // 단말노드가 연산기호면 비정상
		}else { // 자식노드 탐색
			return searchChild(nodeNum*2, tree[nodeNum]) && searchChild(nodeNum*2+1, tree[nodeNum]);
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= 10; tc++) {
			sb.append("#").append(tc).append(" ");
			N = Integer.parseInt(in.readLine());
			tree = new char[N+1]; // 트리를 저장할 배열
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				st.nextToken(); // 노드 번호 버리기
				tree[i] = st.nextToken().charAt(0); // 노드 데이터 입력, 완전이진트리이기 때문에 자식 정보 읽지 않음
			}
			if(searchChild(1, tree[1])) sb.append(1).append("\n");
			else sb.append(0).append("\n");
		}
		System.out.print(sb);
	}
}

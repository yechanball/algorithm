package algorithm.swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_3289_서로소집합 {
	static int[] parents;
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(in.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			parents = new int[N+1]; // 부모 정보 저장할 배열 생성
			make(); // 크기가 1인 서로소 집합 생성
			
			int K, A, B; // K: 연산, A,B: 집합
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				K = Integer.parseInt(st.nextToken());
				A = Integer.parseInt(st.nextToken());
				B = Integer.parseInt(st.nextToken());
				
				if(K == 0) union(A, B); // A B 합집합
				else {
					if(find(A) == find(B)) sb.append(1); // 두 집합이 같다면 1
					else sb.append(0); // 다르다면 0
				}
				
			}
			sb.append("\n");
		}
		out.write(sb.toString());
		out.flush();
		out.close();
	}
	
	static void make() { // 크기가 1인 서로소 집합 생성
		for (int i = 1; i <= N; i++) {
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
}

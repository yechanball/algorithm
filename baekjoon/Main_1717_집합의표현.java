package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1717_집합의표현 {
	static int N; // 집합의 개수
	static int[] parents; // 각 집합의 대표 정보

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		make(); // 정점 배열 생성
		
		int calc, a, b;
		for (int i = 0; i < M; i++) { // M개의 연산 실행
			st = new StringTokenizer(in.readLine(), " ");
			calc = Integer.parseInt(st.nextToken());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			
			if(calc == 0) { // 0번은 합집합
				union(a, b);
			}else { // 1번은 같은 집합인지 확인하는 연산
				if(find(a) == find(b)) { // 두 집합의 대표가 같은 경우 => 같은 집합
					sb.append("YES").append("\n");
				}else { // 두 집합의 대표가 다른 경우 => 다른 집합
					sb.append("NO").append("\n");					
				}
			}
		}

		out.write(sb.toString());
		out.flush();
		out.close();
	}
	
	static void make() { // 크기가 1인 서로소 집합 생성
		parents = new int[N+2];
		for (int i = 0; i <= N+1; i++) {
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

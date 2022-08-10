package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_15651_N과M3 {
	static StringBuilder sb = new StringBuilder();
	static int N,  M;
	static int[] result;
	
	public static void permutationint(int cnt) { // 중복 순열 구하기
		if(cnt == M) { // 더 이상 뽑을 것이 없을 때 재귀 종료
			for (int num : result) {
				sb.append(num).append(" ");				
			}
			sb.append("\n");
			return;
		}else {
			for (int num = 1; num <= N; num++) {
				result[cnt] = num;
				permutationint(cnt+1); // 선택하고 재귀 호출
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		result = new int[M];
		permutationint(0); // nㅠr 중복순열 구하기
		out.write(sb.toString());
		out.flush();
		out.close();
	}
}

package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_15650_N과M2 {
	static StringBuilder sb = new StringBuilder();
	static int N,  M;
	static int[] result;
	static boolean[] check;
	
	public static void permutationint(int cnt) { // 순열 구하기
		if(cnt > M) { // 더 이상 뽑을 것이 없을 때 재귀 종료
			for (int i = 1; i <= M; i++) {
				sb.append(result[i]).append(" ");				
			}
			sb.append("\n");
			return;
		}else { // 고르지 않은 것 중 하나 뽑기
			for (int num = 1; num <= N; num++) {
				if(!check[num] && num > result[cnt-1]) {
					result[cnt] = num;
					check[num] = true;
					permutationint(cnt+1); // 선택하고 재귀 호출
					check[num] = false; // 다음 선택지를 위해 체크 풀어주기
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		result = new int[M+1];
		check = new boolean[N+1];
		permutationint(1);
		out.write(sb.toString());
		out.flush();
		out.close();
	}
}

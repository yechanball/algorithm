package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_15656_N과M7 {
	static StringBuilder sb = new StringBuilder();
	static int N,  M;
	static int[] input;
	static int[] result;
	
	public static void permutationint(int cnt) { // 중복순열 구하기
		if(cnt == M) { // 더 이상 뽑을 것이 없을 때 재귀 종료
			for (int num : result) {
				sb.append(num).append(" ");				
			}
			sb.append("\n");
			return;
		}else { 
			for (int num : input) {
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
		input = new int[N];
		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(input); // 오름차순으로 입력 숫자 정렬
		result = new int[M];
		permutationint(0);
		out.write(sb.toString());
		out.flush();
		out.close();
	}
}

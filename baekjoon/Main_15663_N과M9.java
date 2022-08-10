package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_15663_N과M9 {
	static StringBuilder sb = new StringBuilder();
	static int N,  M;
	static int[] input;
	static int[] result;
	static boolean[] check;
	
	public static void permutationint(int cnt) { // 중복순열 구하기
		if(cnt == M) { // 더 이상 뽑을 것이 없을 때 재귀 종료
			for (int num : result) {
				sb.append(num).append(" ");				
			}
			sb.append("\n");
			return;
		}else { 
			int preNum = -1;
			for (int i = 0; i < N; i++) {
				if(check[i] || preNum == input[i]) continue; // 이미 사용했거나 이전 수와 중복이 되는 경우
				else {
					preNum = input[i]; // 사용한 숫자 이전 숫자로 저장, 다음번 반복에서 확인용
					check[i] = true;
					result[cnt] = input[i];
					permutationint(cnt+1); // 선택하고 재귀 호출					
					check[i] = false;
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
		input = new int[N];
		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(input); // 오름차순으로 입력 숫자 정렬
		result = new int[M];
		check = new boolean[N];
		permutationint(0);
		out.write(sb.toString());
		out.flush();
		out.close();
	}
}

package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_1182_부분수열의합 {
	static int[] num;
	static int N, S, answer = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		num = new int[N];
		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		combi(0, 0);
		
		out.write((S == 0) ? Integer.toString(answer-1) : Integer.toString(answer));
		out.flush();
		out.close();
	}
	
	public static void combi(int cnt, int sum) { // 수열에서 만들수 있는 조합 생성
		if(cnt == N) {
			if(sum == S) answer++;
			return;
		}
		
		combi(cnt + 1, sum + num[cnt]); // 해당 숫자를 포함하는 경우
		combi(cnt + 1, sum); // 포함하지 않는 경우
	}
}

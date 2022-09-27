package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_14225_부분수열의합 {
	static int[] num;
	static boolean[] result;
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(in.readLine());
		
		num = new int[N];
		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		result = new boolean[2_000_001];
		combi(0, 0);
		
		for (int i = 1; i < 2_000_001; i++) {
			if(!result[i]) {
				out.write(Integer.toString(i));			
				break;
			}
		}
		out.flush();
		out.close();
	}
	
	public static void combi(int cnt, int sum) { // 수열에서 만들수 있는 조합 생성
		if(cnt == N) {
			result[sum] = true;
			return;
		}
		
		combi(cnt + 1, sum + num[cnt]); // 해당 숫자를 포함하는 경우
		combi(cnt + 1, sum); // 포함하지 않는 경우
	}
}

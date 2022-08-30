package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_11051_이항계수2 {
	static int[][] combi;
	
	static int combination(int N, int K) {
		if(combi[N][K] != 0) return combi[N][K];
		else if(N == K || K == 0) return combi[N][K] = 1;
		else return combi[N][K] = (combination(N-1, K)+combination(N-1, K-1))%10_007;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		combi = new int[N+1][K+1];
		
		out.write(Integer.toString(combination(N, K)));
		out.flush();
		out.close();
	}
}

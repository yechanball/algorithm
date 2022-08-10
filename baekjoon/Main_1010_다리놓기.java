package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_1010_다리놓기 {
	static int[][] memo = new int[30][30];
	public static int combination(int N, int R) { // 조합 nCr 구하기
		if(memo[N][R] != 0) { // 이미 계산한 조합은 바로 반환
			return memo[N][R];
		}else if(N == R) { // nCn = 1
			memo[N][R] = 1;
			return 1;
		}else if(R == 1) {  // nC1 = n
			memo[N][R] = N;
			return N;
		}else { // 조합 점화식 nCr = n-1Cr + n-1Cr-1
			memo[N][R] = combination(N-1, R) + combination(N-1, R-1);
			return memo[N][R];
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		int N, M;
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(in.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			sb.append(combination(M,N)).append("\n");
		}
		out.write(sb.toString());
		out.flush();
		out.close();
	}
}

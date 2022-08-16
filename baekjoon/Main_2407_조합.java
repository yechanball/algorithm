package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main_2407_조합 {
	static BigInteger[][] combination;
	
	private static BigInteger combi(int N, int M) { // nCm 계산
		if(!combination[N][M].equals(BigInteger.ZERO)) {
			return combination[N][M];
		}else if(N == M) {  // nCn = 1
			combination[N][M] = BigInteger.valueOf(1);
			return combination[N][M];
		}else if(M == 1) {  // nC1 = n
			combination[N][M] = BigInteger.valueOf(N);
			return combination[N][M];
		}else { //  // nCm = n-1Cm + n-1Cm-1;
			combination[N][M] = combi(N-1, M).add(combi(N-1, M-1));
			return combination[N][M];
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		combination = new BigInteger[N+1][M+1];
		for (int i = 1; i <= N; i++) {
			 for (int j = 1; j <= M; j++) {
				combination[i][j] = BigInteger.ZERO; // 메모이제이션 배열 초기화
			}
		}
		out.write(combi(N, M).toString());
		out.flush();
		out.close();
	}
}

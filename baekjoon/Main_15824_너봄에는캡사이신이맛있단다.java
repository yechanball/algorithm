package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_15824_너봄에는캡사이신이맛있단다 {
	static final int mod = 1_000_000_007;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[] scoville = new int[N];

		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++){
			scoville[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(scoville);

		long painScoreSum = 0;
		for (int i = 0; i < N; i++) {
			painScoreSum += (pow(i) - pow(N-1-i)) * scoville[i];
			painScoreSum %= mod;
		}

		System.out.print(painScoreSum);
	}
	
	public static long pow(long X) {
		if(X == 0) return 1;
		long half = pow(X/2);
		return (X%2 == 0) ? half*half%mod : half*half*2%mod;
	}
}

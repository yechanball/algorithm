package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15565_귀여운라이언 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] ryans = new int[N];
		int ryanCnt = 0;
		
		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < N; i++) {
			int doll = Integer.parseInt(st.nextToken());
			if(doll == 2) continue;
			ryans[ryanCnt++] = i;
		}
		
		if(ryanCnt < K) {
			System.out.print(-1);
		}else {
			int start = 0, end = K-1;
			int minSize = ryans[end] - ryans[start] + 1;
			for (int i = K; i < ryanCnt; i++) {
				minSize = Math.min(ryans[++end] - ryans[++start] + 1, minSize);
			}
			System.out.print(minSize);
		}
	}
}
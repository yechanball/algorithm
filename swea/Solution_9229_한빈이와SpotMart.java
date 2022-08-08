package algorithm.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_9229_한빈이와SpotMart {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		int N, M, sum, maxWeight;
		int[] snackWeight;
		
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(in.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			snackWeight = new int[N];			
			st = new StringTokenizer(in.readLine(), " ");
			for (int i = 0; i < N; i++) {
				snackWeight[i] = Integer.parseInt(st.nextToken());
			}
			maxWeight = -1; // 최대 무게 초기화
			for (int i = 0; i < N; i++) {
				for (int j = i+1; j < N; j++) { // 과자 두개 무게 합 계산 및 비교
					sum = snackWeight[i] + snackWeight[j];
					if(sum > maxWeight && sum <= M) {
						maxWeight = sum;
					}
				}
			}
			sb.append(maxWeight).append("\n");
		}
		System.out.print(sb);
	}
}

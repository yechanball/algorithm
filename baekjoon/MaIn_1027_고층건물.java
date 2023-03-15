package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MaIn_1027_고층건물 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		int[] height = new int[N];
		for (int i = 0; i < N; i++) {
			height[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] cnt = new int[N];
		for (int i = 0; i < N; i++) {
			double leftGradient = 1000000000;
			for (int j = i-1; j >= 0; j--) {
				double gradient = ((double)(height[i] - height[j])) / ((double)(i - j));
				if(gradient < leftGradient) {
					leftGradient = gradient;
					cnt[i]++;
				}
			}
			double rightGradient = -1000000000;
			for (int j = i+1; j < N; j++) {
				double gradient = ((double)(height[i] - height[j])) / ((double)(i - j));
				if(gradient > rightGradient) {
					rightGradient = gradient;
					cnt[i]++;
				}
			}
		}
		
		int maxCnt = 0;
		for (int i = 0; i < N; i++) {
			maxCnt = Math.max(maxCnt, cnt[i]);
		}
		
		System.out.print(maxCnt);
	}
}

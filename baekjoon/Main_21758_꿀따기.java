package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_21758_꿀따기 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine()), maxHoney = 0;

		StringTokenizer st = new StringTokenizer(in.readLine());
		int[] honey = new int[N+1], honeySum = new int[N+1];
		for(int i = 1; i <= N; i++){
			honey[i] = Integer.parseInt(st.nextToken());
			honeySum[i] = honeySum[i-1] + honey[i];
		}

		int left = honeySum[N-1], right = honeySum[N]*2 - honeySum[1], mid = honeySum[N-1] - honeySum[1];
		for(int i = 2; i < N; i++) {
			maxHoney = Math.max(maxHoney, left - honey[i] + honeySum[i-1]);
			maxHoney = Math.max(maxHoney, right - honey[i] - honeySum[i]);
			maxHoney = Math.max(maxHoney, mid + honey[i]);
		}
		System.out.print(maxHoney);
	}
}

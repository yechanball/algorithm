package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_2798_블랙잭 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] card = new int[N];
		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < N; i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}
		
		int maxSum = Integer.MIN_VALUE;
		int sum = 0;
		for (int i = 0; i < N; i++) {
			int card1 = card[i];
			for (int j = i+1; j < N; j++) {
				int card2 = card[j];
				for (int k = j+1; k < N; k++) {
					int card3 = card[k];
					sum = card1+card2+card3;
					if(sum <= M) {
						maxSum = (sum > maxSum) ? sum : maxSum;
					}
				}
			}
		}
		
		out.write(Integer.toString(maxSum));
		out.flush();
		out.close();
	}
}

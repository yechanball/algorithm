package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_5800_성적통계 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int K = Integer.parseInt(in.readLine());
		for (int k = 1; k <= K; k++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int N = Integer.parseInt(st.nextToken());
			int[] score = new int[N];
			for (int i = 0; i < N; i++) {
				score[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(score);
			
			int gap = 0;
			for (int i = 1; i < N; i++) {
				gap = Math.max(gap, score[i] - score[i-1]);
			}
			sb.append("Class " + k + "\nMax " + score[N-1] + ", Min " + score[0] + ", Largest gap " + gap + "\n");
		}
		out.write(sb.toString());
		out.flush();
		out.close();
	}
}

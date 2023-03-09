package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1969_DNA {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		String[] DNA = new String[N];
		for (int i = 0; i < N; i++) {
			DNA[i] = in.readLine();
		}
		
		int minHamDistSum = 0;
		for (int i = 0; i < M; i++) {
			int[] ACGT = new int[4];
			
			for (int j = 0; j < N; j++) {
				switch (DNA[j].charAt(i)) {
				case 'A':
					ACGT[0]++;
					break;
				case 'C':
					ACGT[1]++;
					break;
				case 'G':
					ACGT[2]++;
					break;
				case 'T':
					ACGT[3]++;
					break;
				}
			}
			
			int maxCnt = 0, maxIdx = 0;
			for (int j = 0; j < 4; j++) {
				if(ACGT[j] > maxCnt || (ACGT[j] == maxCnt && j < maxIdx)) {
					maxCnt = ACGT[j];
					maxIdx = j;
				}
			}
			
			minHamDistSum += (N - maxCnt);
			
			if(maxIdx == 0) sb.append('A');
			else if(maxIdx == 1) sb.append('C');
			else if(maxIdx == 2) sb.append('G');
			else sb.append('T');
		}

		System.out.print(sb.toString() + "\n" + minHamDistSum);
	}
}

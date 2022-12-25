package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_17425_약수의합 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		long[] gN = new long[1_000_001];
		for (int num = 1; num <= 1_000_000; num++) {
			for (int i = 1; num*i <= 1_000_000; i++) {
				gN[num * i] += num;
			}
			gN[num] += gN[num-1];
		}

		int T = Integer.parseInt(in.readLine());
		for (int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(in.readLine());
			sb.append(gN[N] + "\n");			
		}
		
		out.write(sb.toString());
		out.flush();
		out.close();
	}
}
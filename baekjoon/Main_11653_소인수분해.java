package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_11653_소인수분해 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(in.readLine());
		for (int i = 2; i*i <= N; i++) {
			while (N % i == 0) {
				out.write(i + "\n");
				N /= i;
			}
		}
		if (N != 1) out.write(N + "");
		out.flush();
		out.close();
	}
}

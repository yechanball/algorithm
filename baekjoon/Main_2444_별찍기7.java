package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_2444_별찍기7 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(in.readLine());
		for (int i = 0; i < N; i++) {
			for (int j = 1; j < N-i; j++) {
				out.write(" ");
			}
			for (int j = 0; j < 2*i+1; j++) {
				out.write("*");
			}
			out.write("\n");
		}
		for (int i = N-2; i >= 0; i--) {
			for (int j = 1; j < N-i; j++) {
				out.write(" ");
			}
			for (int j = 0; j < 2*i+1; j++) {
				out.write("*");
			}
			out.write("\n");
		}
		out.flush();
		out.close();
	}
}

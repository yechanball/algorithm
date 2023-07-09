package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_4779_칸토어집합 {
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));		
		String N;
		
		while((N = in.readLine()) != null) {
			printCantorSet((int)Math.pow(3, Integer.parseInt(N)));
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}

	public static void printCantorSet(int len) {
		if(len == 1) {
			sb.append("-");
			return;
		}
		
		printCantorSet(len/3);
		for (int i = 0; i < len/3; i++) {
			sb.append(" ");
		}
		printCantorSet(len/3);
	}
}

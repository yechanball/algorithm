package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2775_부녀회장이될테야 {
	private static int requirePerson(int K, int N) {
		if(N == 1) return 1;
		else if(K == 0) return N;
		else return requirePerson(K, N-1) + requirePerson(K-1, N);		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		for (int tc = 0; tc < T; tc++) {			
			int K = Integer.parseInt(in.readLine());
			int N = Integer.parseInt(in.readLine());
			sb.append(requirePerson(K, N)).append("\n");
		}
		System.out.print(sb);
	}
}

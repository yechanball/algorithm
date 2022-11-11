package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11402_이항계수4 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		long N = Long.parseLong(st.nextToken());
		long K = Long.parseLong(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
			
		long[] fact = new long[M+1];
		fact[0] = 1;
		for (int i = 1; i <= M; i++) {
			fact[i] = i * fact[i-1] % M;
		}
		
		long answer = 1;
		while (K > 0 || N > 0){
			int X = (int) (N % M); 
			int Y = (int) (K % M);
			
			if (Y > X){
				answer = 0;
				break;
			}
			
			answer = answer * fact[X] % M;
			for (int i = 0; i < M - 2; i++){
				answer = answer * fact[X - Y] * fact[Y] % M;
			}
			N /= M; 
			K /= M;
		}
		answer %= M;
		
		System.out.print(answer);
	}
}

package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_10844_쉬운계단수 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(in.readLine());
		long[][] stepNum = new long [N+1][10];
		
		for (int i = 1; i <= 9; i++) { // 기본 초기화
			stepNum[1][i] = 1;
		}
		
		for (int i = 2; i <= N; i++) {
			stepNum[i][0] = stepNum[i-1][1] % 1_000_000_000;
			stepNum[i][9] = stepNum[i-1][8] % 1_000_000_000;
			for (int j = 1; j < 9; j++) {
				stepNum[i][j] = (stepNum[i-1][j-1] + stepNum[i-1][j+1])% 1_000_000_000;				
			}
		}
		
		long result = 0;
		for (int i = 0; i <= 9; i++) { // 기본 초기화
			result += stepNum[N][i];
		}
		result %= 1_000_000_000;
		
		out.write(Long.toString(result));
		out.flush();
		out.close();
	}
}

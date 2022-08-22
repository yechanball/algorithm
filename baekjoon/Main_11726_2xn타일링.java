package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_11726_2xn타일링 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(in.readLine());
		int[] tiling = new int[N+1];
		tiling[0] = 1;
		tiling[1] = 1;
		for (int i = 2; i <= N; i++) { // 2xn 타일링 규칙 P(n) = P(n-1) + p(n-2);
			tiling[i] = (tiling[i-1] + tiling[i-2])%10_007;
		}
		out.write(Integer.toString(tiling[N]));
		out.flush();
		out.close();
	}
}
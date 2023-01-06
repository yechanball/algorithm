package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_1009_분산처리 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
			int res = squared(a, b);
			sb.append(((res == 0) ? 10 : res) + "\n");
		}
		out.write(sb.toString());
		out.flush();
		out.close();
	}
	
	public static int squared(int a, int b) {
		if(b == 1) return a%10;
		int half = squared(a, b/2);
		return (b%2 == 0) ? half * half % 10 : half * half * a % 10;
	}
}

package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_1850_최대공약수 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		long resCnt = (A > B) ? gcd(A, B) : gcd(B, A);
		
		for (int i = 0; i < resCnt; i++) // A와 B의 최대공약수만큼 1 붙이기
			sb.append("1");
		
		out.write(sb.toString());
		out.flush();
		out.close();
	}
	
	public static long gcd(long a, long b) { // 유클리드 호제법으로 최대공약수 계산
		if(a%b == 0)
			return b;
		else
			return gcd(b, a%b);
	}
}
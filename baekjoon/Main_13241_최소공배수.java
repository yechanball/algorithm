package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_13241_최소공배수 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		long lcm = A * B / ((A > B) ? gcd(A, B) : gcd(B, A)); // 최소공배수 = 두 수의 곱 / 최대공약수
		out.write(Long.toString(lcm));
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
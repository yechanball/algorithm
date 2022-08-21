package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_5347_LCM {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(in.readLine(), " ");
			long num1 = Long.parseLong(st.nextToken());
			long num2 = Long.parseLong(st.nextToken());
			long gcdNum = (num1 > num2) ? gcd(num1, num2) : gcd(num2, num1);
			sb.append(num1 * num2 / gcdNum).append("\n");
		}
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

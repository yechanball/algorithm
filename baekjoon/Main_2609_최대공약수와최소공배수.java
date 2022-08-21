package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_2609_최대공약수와최소공배수 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int num1 = Integer.parseInt(st.nextToken());
		int num2 = Integer.parseInt(st.nextToken());
		int gcdNum = (num1 > num2) ? gcd(num1, num2) : gcd(num2, num1);
		sb.append(gcdNum).append("\n").append(num1 * num2 / gcdNum);
		out.write(sb.toString());
		out.flush();
		out.close();
	}
	
	public static int gcd(int a, int b) { // 유클리드 호제법으로 최대공약수 계산
		if(a%b == 0)
			return b;
		else
			return gcd(b, a%b);
	}
}

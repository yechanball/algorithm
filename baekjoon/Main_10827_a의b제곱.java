package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.StringTokenizer;

public class Main_10827_a의b제곱 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		BigDecimal a = new BigDecimal(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		BigDecimal res = pow(a, b);
		
		System.out.print(res.toPlainString());
	}
	
	public static BigDecimal pow(BigDecimal a, int b) {
		if(b == 1) return a;
		BigDecimal half = pow(a, b/2);
		return (b%2 == 0) ? half.multiply(half) : a.multiply(half.multiply(half));
	}
}

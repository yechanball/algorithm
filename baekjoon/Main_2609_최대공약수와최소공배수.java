package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2609_최대공약수와최소공배수 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int num1 = Integer.parseInt(st.nextToken());
		int num2 = Integer.parseInt(st.nextToken());
		int gcd = 1;
		int lcm = 0;
		
		for (int i = 1; i <= ((num1>num2)?num2:num1); i++) {
			if(num1%i == 0 && num2%i == 0) gcd = i;
		}
		lcm = num1 * num2 / gcd;
		System.out.println(gcd);
		System.out.print(lcm);		
	}
}

package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1735_분수합 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(in.readLine());
		int C = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		
		int numerator = A * D + B * C;
        int denominator = B * D;
        
        int mod = gcd(numerator, denominator);
        numerator /= mod;
        denominator /= mod;
		
		System.out.println(numerator + " " + denominator);
	}
	
	public static int gcd(int a, int b) {
		if(a%b == 0) return b;
		else return gcd(b, a%b);
	}
}

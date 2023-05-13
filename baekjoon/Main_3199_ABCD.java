package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_3199_ABCD {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		double p = Double.parseDouble(st.nextToken());
		double q = Double.parseDouble(st.nextToken());
		double r = Double.parseDouble(st.nextToken());
		
		if(p == r) System.out.printf("%.4f", (p+q)*r*2);
		else System.out.print(0);
	}
}

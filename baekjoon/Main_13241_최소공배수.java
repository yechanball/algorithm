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
		long gcd = 1;
		long lcm = 0;
		
		for (int i = (int)((A>B)?B:A); i >= 1; i--) {
			if(A%i == 0 && B%i == 0) { // 최대 공약수 찾기
				gcd = i;
				break;
			}
		}
		lcm = A * B / gcd; // 최소공배수 = 두 수의 곱 / 최대공약수
		
		out.write(Long.toString(lcm));
		out.flush();
		out.close();
	}
}
package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_15829_Hashing {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(in.readLine()), mod = 1_234_567_891;
		String str = in.readLine();
		long hashCode = 0, pow = 1;
		for (int i = 0; i < L; i++) {
			hashCode += ((str.charAt(i) - 96) * pow);
			pow = (pow * 31) % mod;
		}
		System.out.print(hashCode % mod);
	}
}
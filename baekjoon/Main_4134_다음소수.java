package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class Main_4134_다음소수 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(in.readLine());
		for (int tc = 0; tc < t; tc++) {
			BigInteger num = new BigInteger(in.readLine());
			if(num.isProbablePrime(10)) sb.append(num.toString() + "\n");
			else sb.append(num.nextProbablePrime() + "\n");
		}
		
		out.write(sb.toString());
		out.flush();
		out.close();
	}
}

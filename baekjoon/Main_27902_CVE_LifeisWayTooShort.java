package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class Main_27902_CVE_LifeisWayTooShort {
	static BigInteger TWO = BigInteger.valueOf(2);

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(in.readLine());
		
		BigInteger answer = pow(n);
		String ans = answer.toString();

		if(ans.length() <= 4300){
			out.write(ans);
			out.flush();
			out.close();
		}
	}

	public static BigInteger pow(int n) {
		if(n == 1) return TWO;

		BigInteger half = pow(n/2);
		BigInteger result = half.multiply(half);

		return n%2 == 1 ? result.multiply(TWO) : result;
	}
}

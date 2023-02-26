package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1439_뒤집기 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String S = in.readLine();
		int zero = 0, one = 0;
		boolean preZero = false;
		
		if(S.charAt(0) == '0') {
			preZero = true;
			zero++;
		}else {
			one++;
		}
		
		for (int i = 1, len = S.length(); i < len; i++) {
			if(S.charAt(i) == '0' && !preZero) {
				preZero = true;
				zero++;
			}
			else if(S.charAt(i) == '1' && preZero) {
				preZero = false;
				one++;
			}
		}
		System.out.print(Math.min(zero, one));
	}
}

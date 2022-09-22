package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_1748_수이어쓰기1 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(in.readLine());
		int result = 0;
		int digit = 1;
		int powTen = 10;
		for (int i = 1; i <= N; i++) {
			if(i%powTen == 0) {
				digit++;
				powTen = (int)Math.pow(10, digit);
			}
			result += digit;
		}
		out.write(Integer.toString(result));
		out.flush();
		out.close();
	}
}

package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_5622_다이얼 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = in.readLine();
		int t = 0;
		for (int i = 0, len = str.length(); i < len; i++) {
			int c = str.charAt(i) - 'A';
			if(c < 15) t += (c/3 + 3);
			else if(c < 19) t += 8;
			else if(c < 22) t += 9;
			else t += 10;
		}
		System.out.print(t);
	}
}

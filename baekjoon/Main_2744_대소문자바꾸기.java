package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2744_대소문자바꾸기 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		String str = in.readLine();
		for (int i = 0, len = str.length(); i < len; i++) {
			int ascii = str.charAt(i);
			sb.append((char)(ascii >= 97 ? ascii-32 : ascii+32));
		}
		
		System.out.println(sb.toString());
	}
}

package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1259_팰린드롬수 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str;
		int left, right;
		boolean isPalindrome;
		
		while(true) {
			str = in.readLine();
			if(str.equals("0")) break;
			isPalindrome = true;
			left = 0;
			right = str.length()-1;
			for (int i = 0; i < (str.length()/2); i++) {
				if(str.charAt(left+i) != str.charAt(right-i) ) {
					isPalindrome = false;
					break;
				}
			}
			if(isPalindrome) sb.append("yes").append("\n");
			else sb.append("no").append("\n");
		}
		System.out.print(sb);
	}
}

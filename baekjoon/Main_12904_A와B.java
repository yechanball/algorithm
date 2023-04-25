package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_12904_A와B {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String S = in.readLine(); 
		StringBuffer T = new StringBuffer(in.readLine());
		int len = S.length();
		
		while(len < T.length()) {
			char last = T.charAt(T.length()-1);
			T.deleteCharAt(T.length()-1);
			
			if(last == 'B') T.reverse();
		}
		
		System.out.print(S.equals(T.toString()) ? 1 : 0);
	}
}

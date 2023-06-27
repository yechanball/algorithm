package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main_11478_서로다른부분문자열의개수 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String S = in.readLine();
		int len = S.length();
		
		HashSet<String> set = new HashSet<>();
		for (int i = 0; i < len; i++) {
			for (int j = i; j <= len; j++) {
				set.add(S.substring(i, j));
			}
		}
		
		System.out.println(set.size()-1);
	}
}

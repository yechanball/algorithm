package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_5555_반지 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String str = in.readLine();
		int N = Integer.parseInt(in.readLine()), cnt = 0;
		
		for (int i = 0; i < N; i++) {
			String tmp = in.readLine();
			if(tmp.concat(tmp).contains(str)) cnt++;
		}
		System.out.println(cnt);
	}
}

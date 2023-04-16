package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_27961_고양이는많을수록좋다 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		long N = Long.parseLong(in.readLine());
		int cnt = 1;
		
		if(N == 0) cnt = 0;
		else {
			long cat = 1;

			while(cat < N) {
				cat *= 2;
				cnt++;
			}
			
		}	
		System.out.println(cnt);
	}
}

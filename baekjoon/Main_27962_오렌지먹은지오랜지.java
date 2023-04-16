package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_27962_오렌지먹은지오랜지 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		String str = in.readLine();
		
		boolean isVitaStr = false;
		for (int i = 1; i <= N; i++) {
			int diffCnt = 0;
			
			for (int j = 0; j < i; j++) {
				if(str.charAt(j) != str.charAt(N-i+j)) diffCnt++;
			}
			
			if(diffCnt == 1) {
				isVitaStr = true;
				break;
			}
		}
		
		System.out.println(isVitaStr ? "YES" : "NO");
	}
}

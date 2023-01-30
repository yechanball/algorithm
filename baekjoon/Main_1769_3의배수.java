package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1769_3의배수 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String X = in.readLine();
		int cnt = 0;
		while(X.length() > 1) {
			int tmp = 0;
			for (int i = 0, len = X.length(); i < len; i++) {
				tmp += (X.charAt(i) - '0');
			}
			X = Integer.toString(tmp);
			cnt++;
		}
		
		System.out.println(cnt);
		
		int result = Integer.parseInt(X);
		if(result%3 == 0) System.out.print("YES");
		else System.out.print("NO");
	}
}

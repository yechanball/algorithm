package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_9012_괄호 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		String str;
		char ch;
		int cnt;
		
		for(int tc = 1; tc <= T; tc++) {
			str = in.readLine();
			cnt = 0;
			for(int i = 0; i < str.length(); i++) {
				ch = str.charAt(i);
				if(cnt < 0) {
					break;
				}else if(ch == '('){
					cnt++;
				}else if(ch == ')') {
					cnt--;
				}
			}
			if(cnt == 0)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}
}

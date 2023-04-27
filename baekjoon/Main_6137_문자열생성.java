package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_6137_문자열생성 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer S = new StringBuffer();
		
		int N = Integer.parseInt(in.readLine());
		for (int i = 0; i < N; i++) {
			S.append(in.readLine());
		}
		
		int left = 0, right = N-1, len = 0;
		while(left <= right) {
			if(S.charAt(left) < S.charAt(right)) out.append(S.charAt(left++));
			else if(S.charAt(left) > S.charAt(right)) out.append(S.charAt(right--));
			else {
				int l = left, r = right;
				
				while(l <= r && S.charAt(l) == S.charAt(r)) {
					if(r <= 0 || l >= N-1) break;
					r--;
					l++;
				}
				
				if(S.charAt(l) < S.charAt(r)) out.append(S.charAt(left++));
				else out.append(S.charAt(right--));
			}

			if(++len%80 == 0) out.append("\n");
		}
		out.flush();
		out.close();
	}
}

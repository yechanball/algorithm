package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_2941_크로아티아알파벳 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		String input = in.readLine();
		int cnt = 0, idx = 0;
		while(idx < input.length()) {
			if(idx+1 < input.length() && input.charAt(idx) == 'c' && input.charAt(idx+1) == '=') { // 크로아티아 알파벳 c=
				cnt++;
				idx += 2;
			}else if(idx+1 < input.length() && input.charAt(idx) == 'c' && input.charAt(idx+1) == '-') { // 크로아티아 알파벳 c-
				cnt++;
				idx += 2;
			}else if(idx+1 < input.length() && input.charAt(idx) == 'd' && input.charAt(idx+1) == '-') { // 크로아티아 알파벳 d-
				cnt++;
				idx += 2;
			}else if(idx+2 < input.length() && input.charAt(idx) == 'd' && input.charAt(idx+1) == 'z' && input.charAt(idx+2) == '=') { // 크로아티아 알파벳 dz=
				cnt++;
				idx += 3;
			}else if(idx+1 < input.length() && input.charAt(idx) == 'l' && input.charAt(idx+1) == 'j') { // 크로아티아 알파벳 lj
				cnt++;
				idx += 2;
			}else if(idx+1 < input.length() && input.charAt(idx) == 'n' && input.charAt(idx+1) == 'j') { // 크로아티아 알파벳 nj
				cnt++;
				idx += 2;
			}else if(idx+1 < input.length() && input.charAt(idx) == 's' && input.charAt(idx+1) == '=') { // 크로아티아 알파벳 s=
				cnt++;
				idx += 2;
			}else if(idx+1 < input.length() && input.charAt(idx) == 'z' && input.charAt(idx+1) == '=') { // 크로아티아 알파벳 z=
				cnt++;
				idx += 2;
			}else { // 다른 알파벳인 경우
				cnt++;
				idx += 1;
			}
		}
		out.write(Integer.toString(cnt));
		out.flush();
		out.close();
	}
}

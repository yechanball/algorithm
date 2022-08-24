package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_14405_피카츄 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = in.readLine();
		boolean isPikachu = true;
		
		int idx = 0, len = str.length();
		while(idx < len) {
			if(str.charAt(idx) == 'p' && idx+1 < len && str.charAt(idx+1) == 'i') {
				idx += 2;
			}else if(str.charAt(idx) == 'k' && idx+1 < len && str.charAt(idx+1) == 'a') {
				idx += 2;
			}else if(str.charAt(idx) == 'c' && idx+2 < len && str.charAt(idx+1) == 'h' && str.charAt(idx+2) == 'u') {
				idx += 3;
			}else {
				isPikachu = false;
				break;
			}
		}
		
		out.write(isPikachu ? "YES" : "NO");
		out.flush();
		out.close();
	}
}

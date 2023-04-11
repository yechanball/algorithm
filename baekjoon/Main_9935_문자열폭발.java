package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_9935_문자열폭발 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		String str = in.readLine();
		String boom = in.readLine();
		int boomLen = boom.length();
		
		for (int i = 0, strLen = str.length(); i < strLen; i++) {
			char ch = str.charAt(i);
			sb.append(ch);
			
			if(sb.length() >= boomLen) {
				boolean isContain = true;
				
				for (int j = 0; j < boomLen; j++) {
					if(sb.charAt(sb.length() - boomLen + j) == boom.charAt(j)) continue;
					isContain = false;
					break;
				}
				
				if(isContain) sb.delete(sb.length() - boomLen, sb.length());
			}
		}
		
		if(sb.length() == 0) sb.append("FRULA");
		
		out.write(sb.toString());
		out.flush();
		out.close();
	}
}

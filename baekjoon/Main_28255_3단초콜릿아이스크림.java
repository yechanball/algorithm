package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_28255_3단초콜릿아이스크림 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(in.readLine());
		for (int t = 0; t < T; t++) {
			String str = in.readLine();
			int n = str.length();
			
	        String subStr = str.substring(0, (n + 2) / 3);
	        String tailSubStr = subStr.substring(1, subStr.length());
	        String reverseSubStr = new StringBuilder(subStr).reverse().toString();
	        String tailReverseSubStr = reverseSubStr.substring(1, reverseSubStr.length());
	        
	        if (str.equals(subStr + reverseSubStr + subStr)) {
	        	out.append("1\n");
	        } else if (str.equals(subStr + tailReverseSubStr + subStr)) {
	        	out.append("1\n");
	        } else if (str.equals(subStr + reverseSubStr + tailSubStr)) {
	        	out.append("1\n");
	        } else if (str.equals(subStr + tailReverseSubStr + tailSubStr)) {
	        	out.append("1\n");
	        } else {
	        	out.append("0\n");
	        }
		}
		
		out.flush();
		out.close();
	}
}

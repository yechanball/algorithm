package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_10798_세로읽기 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringBuffer[] sb = new StringBuffer[15];
		for (int i = 0; i < 15; i++) {
			sb[i] = new StringBuffer();
		}
		
		for (int i = 0; i < 5; i++) {
			String str = in.readLine();
			for (int j = 0, len = str.length(); j < len; j++) {
				sb[j].append(str.charAt(j));
			}
		}
		
		for (int i = 0; i < 15; i++) {
			out.write(sb[i].toString());
		}
		out.flush();
		out.close();
	}
}

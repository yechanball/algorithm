package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main_5052_전화번호목록 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= t; tc++) {
			int n = Integer.parseInt(in.readLine());
			
			String[] phoneNums = new String[n];
			for (int i = 0; i < n; i++) {
				phoneNums[i] = in.readLine();
			}
			
			Arrays.sort(phoneNums);
			
			boolean isConsist = true;
			for (int i = 0; i < n-1; i++) {
	            if (phoneNums[i + 1].startsWith(phoneNums[i])) {
	                isConsist = false;
	                break;
	            }
	        }
			
			out.write(isConsist ? "YES\n" : "NO\n");
		}
		out.flush();
		out.close();
	}
}

package algorithm.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_1289_원재의메모리복구하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		String str;
		char start, preCh;
		int cnt;
		
		for (int tc = 1; tc <= T; tc++) {
			str = in.readLine();
			start = str.charAt(0);
			preCh = start;
			cnt = 0;	
			if(start == '1')
				cnt++;	
			for (int i = 1; i < str.length(); i++) {
				if(preCh == str.charAt(i))
					continue;
				else {
					preCh = str.charAt(i);
					cnt++;
				}
			}	
			sb.append("#").append(tc).append(" ").append(cnt).append("\n");
		}
		System.out.print(sb);
	}
}

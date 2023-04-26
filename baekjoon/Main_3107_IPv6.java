package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_3107_IPv6 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String ipv6 = in.readLine();
		boolean isContain = ipv6.contains("::");
		
		if(isContain) ipv6 = ipv6.replace("::", ":ZEROADR:");
		
		StringTokenizer st = new StringTokenizer(ipv6, ":");
		StringBuilder sb = new StringBuilder();
		int cnt = isContain ? st.countTokens() - 1 : st.countTokens();
		
		while(st.hasMoreTokens()) {
			String adr = st.nextToken();
			int len = adr.length();
			
			if(len > 4) {				
				for (int i = 0; i < 8 - cnt; i++) {
					sb.append("0000:");
				}
			}else {
				if(len < 4) {
					for (int i = 0; i < 4-len; i++) {
						sb.append("0");
					}
				}
				sb.append(adr + ":");
			}
		}
		
		sb.deleteCharAt(sb.length()-1);
		System.out.print(sb.toString());
	}
}

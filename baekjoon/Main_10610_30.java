package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_10610_30 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String N = in.readLine();
		
		int[] num = new int[10];
		int sum = 0;
		for (int i = 0, len = N.length(); i < len; i++) {
			int tmp = N.charAt(i) - '0';
			num[tmp]++;
			sum += tmp;
		}
		
		if(num[0] > 0 && sum%3 == 0) {
			StringBuilder sb = new StringBuilder();
			for (int i = 9; i >= 0; i--) {
				for (int j = 0; j < num[i]; j++) {
					sb.append(i);
				}
			}
			System.out.print(sb.toString());
		}else {
			System.out.print(-1);
		}
	}
}

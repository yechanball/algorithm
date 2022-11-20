package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2920_음계 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		boolean check = true;
		int start = Integer.parseInt(st.nextToken());
		if(start == 1) {
			for (int i = 2; i <= 8; i++) {
				if(i == Integer.parseInt(st.nextToken())) continue;
				check = false;
				break;
			}
			System.out.print((check) ? "ascending" : "mixed");
		}else if(start == 8) {
			for (int i = 7; i >= 1; i--) {
				if(i == Integer.parseInt(st.nextToken())) continue;
				check = false;
				break;
			}
			System.out.print((check) ? "descending" : "mixed");			
		}else {
			System.out.print("mixed");
		}
	}
}
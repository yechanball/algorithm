package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1476_날짜계산 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int E = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int e = 1, s = 1, m = 1, year = 1;
		while(!(e == E && s == S && m == M)) {
			year++;
			if(++e > 15) e = 1; 
			if(++s > 28) s = 1; 
			if(++m > 19) m = 1; 
		}
		
		System.out.print(year);
	}
}

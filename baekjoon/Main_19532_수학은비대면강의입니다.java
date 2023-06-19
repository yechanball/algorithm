package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_19532_수학은비대면강의입니다 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int a = Integer.parseInt(st.nextToken()),
			b = Integer.parseInt(st.nextToken()),
			c = Integer.parseInt(st.nextToken()),
			d = Integer.parseInt(st.nextToken()),
			e = Integer.parseInt(st.nextToken()),
			f = Integer.parseInt(st.nextToken());
	
		for (int x = -999; x <= 999; x++) {
			for (int y = -999; y <= 999; y++) {
				if(a*x+b*y == c && d*x+e*y == f) {
					System.out.println(x + " " + y);
					System.exit(0);
				}
			}
		}
	}
}

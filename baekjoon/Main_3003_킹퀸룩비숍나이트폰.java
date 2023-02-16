package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_3003_킹퀸룩비숍나이트폰 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		System.out.print((1 - Integer.parseInt(st.nextToken())) + " " + (1 - Integer.parseInt(st.nextToken())) + " " + (2 - Integer.parseInt(st.nextToken())) + " " + (2 - Integer.parseInt(st.nextToken())) + " " + (2 - Integer.parseInt(st.nextToken())) + " " + (8 - Integer.parseInt(st.nextToken())));
	}
}

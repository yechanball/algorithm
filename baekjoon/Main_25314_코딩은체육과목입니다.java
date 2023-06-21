package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_25314_코딩은체육과목입니다 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		int N = Integer.parseInt(in.readLine());
		for (int i = 0; i < N/4; i++) {
			sb.append("long ");
		}
		sb.append("int");
		
		System.out.println(sb.toString());
	}
}

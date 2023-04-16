package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_27960_사격내기 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int SA = Integer.parseInt(st.nextToken());
		int SB = Integer.parseInt(st.nextToken());
	
		System.out.println(SA ^ SB);
	}
}

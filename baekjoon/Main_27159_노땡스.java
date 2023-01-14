package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_27159_노땡스 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		int preNum = Integer.parseInt(st.nextToken());
		int score = preNum;		
		for (int i = 0; i < N-1; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(num - preNum != 1) {
				score += num;
			}
			preNum = num;
		}
		System.out.print(score);
	}
}

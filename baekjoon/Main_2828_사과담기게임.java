package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2828_사과담기게임 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int J = Integer.parseInt(in.readLine());
		int left = 1, right = M, move = 0;
		
		for (int i = 0; i < J; i++) {
			int pos = Integer.parseInt(in.readLine());
			
			if(pos < left) {
				int tmpMove = left - pos;
				move += tmpMove;
				left = pos;
				right -= tmpMove;
			}else if(pos > right) {
				int tmpMove = pos - right;
				move += tmpMove;
				left += tmpMove;				
				right = pos;
			}else continue;
		}
		
		System.out.print(move);
	}
}

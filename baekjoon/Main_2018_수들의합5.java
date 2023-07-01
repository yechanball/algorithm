package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2018_수들의합5 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		int start = 0, end = 0, sum = 0, cnt = 0;
		
		while(start <= N) {
			while(++end <= N) {
				sum += end;
				
				if(sum == N) cnt++;
				if(sum >= N) break;
			}
			
			while(++start <= N) {
				sum -= start;
				
				if(sum == N) cnt++;
				if(sum <= N) break;
			}	
		}
		
		System.out.println(cnt);
	}
}

package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_5525_IOIOI {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(in.readLine());
		int M = Integer.parseInt(in.readLine());

		String input = in.readLine();
		int idx = 0, cnt = 0;
		boolean isIOI;
		while(idx < M) {
			if(input.charAt(idx) == 'I') { // I인 경우
				 isIOI = true;
				 if(idx+N*2 > M) break; // 범위를 넘어가는 경우 반복 종료 
				 for (int i = 1; i <= N*2; i++) {
					 if(i%2 == 0) { // 짝수번째
						 if(input.charAt(idx+i) == 'I') continue;
						 isIOI = false;
						 break;
					 }else { // 홀수번째
						 if(input.charAt(idx+i) == 'O') continue;
						 isIOI = false;
						 break;
					 }
				 }
				 if(isIOI) cnt++;					 
			}
			idx++;
		}
		out.write(Integer.toString(cnt));
		out.flush();
		out.close();
	}
}

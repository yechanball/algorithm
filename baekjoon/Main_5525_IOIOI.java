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
		int idx = 0, cnt = 0, len = 0;
		while(idx < M) {
			if(input.charAt(idx) == 'I') { // I인 경우
				if(idx+1 >= M || idx+2 >= M ) {
					if(len >= N) {
						cnt += (len-N+1);
					}
					break;
				}
				if(input.charAt(idx+1) == 'O' && input.charAt(idx+2) == 'I') {
					len++;
					idx += 2;
				}else {
					idx += 1;
					if(len >= N) {
						cnt += (len-N+1);
					}
					len = 0;
				}
			}else {
				idx++;				
			}
		}
		out.write(Integer.toString(cnt));
		out.flush();
		out.close();
	}
}

package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_9519_졸려 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		int X = Integer.parseInt(in.readLine());
		String word = in.readLine();
		String firstWord = word;
		int N = word.length(), cycle = 0;

		if(N%2 == 0) {
			while(X > 0) {
				StringBuilder tmp = new StringBuilder();
				int head = N-2, tail = N-1;
				while(tail > 0) {
					tmp.insert(0, word.charAt(head));
					tmp.append(word.charAt(tail));
					head -= 2;
					tail -= 2;
				}
				word = tmp.toString();
				X--;
				cycle++;
				if(word.equals(firstWord)) X %= cycle;
			}
		}else {
			while(X > 0) {
				StringBuilder tmp = new StringBuilder();
				int head = N-3, tail = N-2;
				tmp.append(word.charAt(N-1));
				while(tail > 0) {
					tmp.insert(0, word.charAt(head));
					tmp.append(word.charAt(tail));
					head -= 2;
					tail -= 2;
				}
				word = tmp.toString();
				X--;
				cycle++;
				if(word.equals(firstWord)) X %= cycle;
			}
		}
		out.write(word);
		out.flush();
		out.close();
	}
}

package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main_2161_카드1 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		Deque<Integer> deque = new ArrayDeque<Integer>();
		int N = Integer.parseInt(in.readLine());
		for (int i = 1; i <= N; i++) {
			deque.offer(i);
		}
		
		while(!deque.isEmpty()) {
			sb.append(deque.poll()).append(" ");
			if(deque.isEmpty()) {
				break;
			}
			deque.offer(deque.poll());
		}
		
		out.write(sb.toString());
		out.flush();
		out.close();
	}
}

package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_10845_큐 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		Deque<Integer> q = new ArrayDeque<Integer>();
		int N = Integer.parseInt(in.readLine());
		for (int i = 0; i < N; i++) {
			String input = in.readLine();
			if(input.charAt(0) == 'p') {
				if(input.charAt(1) == 'u') {
					st = new StringTokenizer(input, " ");
					st.nextToken();
					q.offer(Integer.parseInt(st.nextToken()));
				}else {
					if(q.isEmpty()) sb.append("-1").append("\n");
					else sb.append(q.poll()).append("\n");
				}
			}else if(input.charAt(0) == 's') {
				sb.append(q.size()).append("\n");
			}else if(input.charAt(0) == 'e') {
				sb.append(q.isEmpty() ? 1 : 0).append("\n");
			}else if(input.charAt(0) == 'f'){
				if(q.isEmpty()) sb.append("-1").append("\n");
				else sb.append(q.peek()).append("\n");
			}else{
				if(q.isEmpty()) sb.append("-1").append("\n");
				else sb.append(q.peekLast()).append("\n");
			}
		}
		
		out.write(sb.toString());
		out.flush();
		out.close();
	}
}
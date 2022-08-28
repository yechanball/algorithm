package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_10828_스택 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		Deque<Integer> stack = new ArrayDeque<Integer>();
		int N = Integer.parseInt(in.readLine());
		for (int i = 0; i < N; i++) {
			String input = in.readLine();
			if(input.charAt(0) == 'p') {
				if(input.charAt(1) == 'u') {
					st = new StringTokenizer(input, " ");
					st.nextToken();
					stack.push(Integer.parseInt(st.nextToken()));
				}else {
					if(stack.isEmpty()) sb.append("-1").append("\n");
					else sb.append(stack.pop()).append("\n");
				}
			}else if(input.charAt(0) == 's') {
				sb.append(stack.size()).append("\n");
			}else if(input.charAt(0) == 'e') {
				sb.append(stack.isEmpty() ? 1 : 0).append("\n");
			}else {
				if(stack.isEmpty()) sb.append("-1").append("\n");
				else sb.append(stack.peek()).append("\n");
			}
		}
		
		out.write(sb.toString());
		out.flush();
		out.close();
	}
}

package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_10866_덱 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		Deque<Integer> dQ = new ArrayDeque<Integer>();
		int N = Integer.parseInt(in.readLine());
		for (int i = 0; i < N; i++) {
			String input = in.readLine();
			if(input.charAt(0) == 'p') {
				if(input.charAt(1) == 'u') {
					st = new StringTokenizer(input, " ");
					st.nextToken();					
					if(input.charAt(5) == 'f') {
						dQ.addFirst(Integer.parseInt(st.nextToken()));						
					}else {
						dQ.addLast(Integer.parseInt(st.nextToken()));						
					}
				}else {
					if(dQ.isEmpty()) sb.append("-1").append("\n");
					else {
						if(input.charAt(4) == 'f') {
							sb.append(dQ.pollFirst()).append("\n");
						}else {
							sb.append(dQ.pollLast()).append("\n");
						}						
					}
				}
			}else if(input.charAt(0) == 's') {
				sb.append(dQ.size()).append("\n");
			}else if(input.charAt(0) == 'e') {
				sb.append(dQ.isEmpty() ? 1 : 0).append("\n");
			}else if(input.charAt(0) == 'f'){
				if(dQ.isEmpty()) sb.append("-1").append("\n");
				else sb.append(dQ.peek()).append("\n");
			}else{
				if(dQ.isEmpty()) sb.append("-1").append("\n");
				else sb.append(dQ.peekLast()).append("\n");
			}
		}
		
		out.write(sb.toString());
		out.flush();
		out.close();
	}
}
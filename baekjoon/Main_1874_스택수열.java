package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main_1874_스택수열 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		Stack<Integer> stack = new Stack<>();
		int N = Integer.parseInt(in.readLine()), num = 1;
		boolean isPoss = true;

		for (int i = 0; i < N; i++){
			int tmp = Integer.parseInt(in.readLine());
			
			if(num <= tmp) {
				while(num <= tmp) {
					stack.push(num++);
					sb.append("+\n");
				}
				stack.pop();
				sb.append("-\n");				
			}else {
				int top = stack.pop();
				if(top == tmp) {
					sb.append("-\n");
				}else {
					isPoss = false;
					break;
				}
			}
		}
		
		out.write((isPoss && stack.isEmpty()) ? sb.toString() : "NO");
		out.flush();
		out.close();
	}
}

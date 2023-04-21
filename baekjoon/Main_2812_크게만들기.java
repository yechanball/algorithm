package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_2812_크게만들기 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int len = N - K;
		
		Stack<Integer> stack = new Stack<>();
		String str = in.readLine();
		for(int i = 0; i < N; i++) {
			int num = str.charAt(i) - '0';
			
			while(K > 0 && !stack.isEmpty() && stack.peek() < num) {
				stack.pop();
				K--;
			}
			
			stack.push(num);
		}
		
		for(int i = 0; i < len; i++) {
			System.out.print(stack.elementAt(i));
		}
	}
}

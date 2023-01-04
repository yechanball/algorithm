package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_2504_괄호의값 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> stack = new Stack<>();
		int ans = 0, tmp = 1;
		boolean isError = false;
		
		String str = in.readLine();
		for (int i = 0, len = str.length(); i < len; i++) {
			char ch = str.charAt(i);
			if(ch == '(') {
				stack.push(ch);
				tmp *= 2;
			}else if(ch == '[') {
				stack.push(ch);
				tmp *= 3;
			}else if(ch == ')') {
				if(stack.isEmpty() || stack.peek() != '(') {
					isError = true;
					break;
				}
				if(str.charAt(i-1) == '(') {
					ans += tmp;
				}
				stack.pop();
				tmp /= 2;
			}else if(ch == ']') {
				if(stack.isEmpty() || stack.peek() != '[') {
					isError = true;
					break;
				}
				if(str.charAt(i-1) == '[') {
					ans += tmp;
				}
				stack.pop();
				tmp /= 3;
			}else {
				isError = true;
				break;
			}
		}
		
		System.out.print((isError || !stack.isEmpty()) ? 0 : ans);
	}
}

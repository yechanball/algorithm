package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_4949_균형잡힌세상 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String str = in.readLine();
			if(str.equals(".")) break;
			
			Stack<Character> stack = new Stack<>();
			boolean isBalance = true;
			for (int i = 0, len = str.length(); i < len && isBalance; i++) {
				char ch = str.charAt(i);
				if(ch == ')') {
					while(true) {
						if(stack.size() == 0) {
							isBalance = false;
							break;
						}
						
						char pop = stack.pop();
						if(pop == '(') {
							break;
						}else if(pop == '[') {
							isBalance = false;
							break;
						}
					}
				}else if(ch == ']') {
					while(true) {
						if(stack.size() == 0) {
							isBalance = false;
							break;
						}
						
						char pop = stack.pop();
						if(pop == '[') {
							break;
						}else if(pop == '(' || stack.size() == 0) {
							isBalance = false;
							break;
						}
					}
				}else {
					stack.push(ch);
				}
			}

			if(isBalance && stack.size() > 0) {
				while(stack.size() > 0) {
					char pop = stack.pop();
					if(pop == '(' || pop == '[') {
						isBalance = false;
						break;
					}
				}
			}
			
			if(isBalance){
				System.out.println("yes");				
			}else {
				System.out.println("no");
			}
		}
	}
}

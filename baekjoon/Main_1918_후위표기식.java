package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main_1918_후위표기식 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		String input = in.readLine();
		
		Deque<Character> stack = new ArrayDeque<Character>();
		
		for (int i = 0, len = input.length(); i < len; i++) {
			char key = input.charAt(i);
			
			switch (key) {
			case '(': // 여는 괄호는 그냥 push
				stack.push(key);
				break;
				
			case ')': // 닫는 괄호인 경우 여는 괄호가 나올때까지 pop
				while(!stack.isEmpty() && stack.peek() != '(') { // 연산자만 출력
					sb.append(stack.pop()); 
				}
				stack.pop(); // 여는 괄호 빼내기
				break;
				
			case '+': case '-': case '*': case '/':
				while(!stack.isEmpty() && priority(stack.peek()) >= priority(key)) { // 이전에 들어간 연산자가 같거나 더 높은 우선순위인 경우 빼내기
					sb.append(stack.pop());
				}
				stack.push(key);
				break;
				
			default: // 문자는 그냥 붙여서 출력
				sb.append(key);
				break;	
			}		
		}
		
		while(!stack.isEmpty()) { // 모든 입력이 다 끝나고 스택에 잔여 연산기호가 있는 경우 비워주기
			sb.append(stack.pop());
		}
		
		out.write(sb.toString());
		out.flush();
		out.close();
	}
	
	public static int priority(char op){ // 연산자 우선순위 반환 메서드
		if (op == '*' || op == '/') {
			return 2;
		}else if (op == '+' || op == '-') {
			return 1;
		} else{
			return 0;
		}
	}
}

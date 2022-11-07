package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_16120_PPAP {
	public static void main(String[] args) throws IOException {
		String str = new BufferedReader(new InputStreamReader(System.in)).readLine();
		Stack<Character> stack = new Stack<>();
		boolean isPPAP = true; // PPAP 문자열 체크
		int len = str.length(); // 문자열 길이
		int idx = 0, size = 0; // 인덱스, 스택 크기
		
		while(idx < len) {
			if(str.charAt(idx) == 'P') {
				stack.push('P');
				size++;
				idx++;
			}else {
				if(size >= 2 && idx+1 < len && str.charAt(idx+1) == 'P') { // PPAP 부분문자열을 P로 치환
					stack.pop();
					size--;
					idx += 2;
				}else { // A문자 앞에 PP가 없는 경우 PPAP 문자열 성립 X
					isPPAP = false;
					break;
				}
			}
		}
		if(size != 1 || stack.peek() != 'P') isPPAP = false; // 문자열 길이가 1이고 P인 문자열이 아니면 PPAP 문자열 성립 X
		
		System.out.print((isPPAP) ? "PPAP" : "NP");
	}
}
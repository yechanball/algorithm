package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_10422_괄호 {
	static int L; // 괄호 문자열 길이
	static long bracketCnt; // 올바른 괄호 문자열의 개수
	
	public static void brackets(int cnt, int sum) {
		if(sum < 0) return; // 괄호)가 더 들어간 경우
		else if(cnt == L) { // 문자열을 괄호로 다 채운 경우
			if(sum == 0) { // 괄호가 맞게 닫힌 경우
				bracketCnt++;
				return;
			}else return; // 괄호가 맞게 안 닫힌 경우
		}else {
			brackets(cnt+1, sum+1); // 괄호(를 여는 경우
			brackets(cnt+1, sum-1); // 괄호)를 닫는 경우
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			L = Integer.parseInt(in.readLine());
			bracketCnt = 0; // 초기화
			if(L % 2 == 0) { // 짝수인 경우만 고려				
				brackets(0, 0); // 괄호 문자열 생성 호출
			}
			sb.append(bracketCnt).append("\n"); // 생성 가능한 괄호 문자열 개수 출력
		}
		out.write(sb.toString());
		out.flush();
		out.close();
	}
}

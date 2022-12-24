package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1107_리모컨 {
	static int N, min;
	static List<Integer> list = new ArrayList<Integer>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(in.readLine());
		int M = Integer.parseInt(in.readLine());
		int digit = Integer.toString(N).length();
		
		// 리모컨 가능한 버튼 초기화
		for (int i = 0; i < 10; i++) {
			list.add(i);
		}
		
		if(M != 0) {
			st = new StringTokenizer(in.readLine());
			for (int i = 0; i < M; i++) {
				list.remove((Integer)Integer.parseInt(st.nextToken()));
			}			
		}
		
		min = Math.abs(N-100); // +, - 버튼으로 이동시 누른 횟수
		
		for (int btnNum : list) { // 1자리 입력의 경우
			min = Math.min(min, 1 + Math.abs(N - btnNum));
		}
		
		for (int i = 2; i <= digit+1; i++) { // 2자리 이상의 입력인 경우
			makeNum(i, 1, 0, 0); // 가능한 경우의 수 계산			
		}
		
		System.out.print(min);
	}

	public static void makeNum(int digit, int pow, int cnt, int num) {
		if(cnt == digit) {
			for (int btnNum : list) {
				if(btnNum == 0) continue;
				min = Math.min(min, cnt + 1 + Math.abs(N-(num + btnNum*pow)));
			}
			return;
		}
		
		for (int btnNum : list) {
			makeNum(digit, pow * 10, cnt + 1, num + btnNum*pow);
		}
	}
}

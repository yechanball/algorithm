package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_2493_탑 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		Stack<Integer> tower = new Stack<>(); // 탑 스택
		for (int i = 0; i < N; i++) {
			tower.push(Integer.parseInt(st.nextToken()));
		}
		Stack<Integer> check = new Stack<>(); // 확인한 탑 스택
		int nowTower;
		while (!tower.empty()) { // 탑 순차적 검사
			nowTower = tower.pop();
			if(tower.isEmpty()) sb.append(0).append(" "); // 수신 탑이 없을때
			while(!tower.empty()) { // 수신 탑 찾기
				if(tower.peek() > nowTower) {
					sb.append(tower.size()).append(" ");
					break;
				}else {
					check.push(tower.pop());
				}
			}
			while(!check.empty()) { // 검사한 탑 복원
				tower.push(check.pop());
			}
		}
		sb.append(0); // 마지막 탑은 수신 탑 X
		System.out.print(sb.reverse());
	}
}

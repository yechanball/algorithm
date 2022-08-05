package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_2493_탑 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		Deque<int[]> tower = new ArrayDeque<>(); // 탑 Deque
		int[] nowTower, curTower;
		
		for (int i = 1; i <= N; i++) {
			nowTower = new int[] {i, Integer.parseInt(st.nextToken())};
			// 탑 순차적 검사
			while (true) {
				// 탑이 없으면 넣기
				if(tower.isEmpty()) {
					sb.append(0).append(" ");			
					tower.push(nowTower);
					break;
				}
				curTower = tower.peek();
				// 수신 탑 찾기
				if(curTower[1] > nowTower[1]) {
					sb.append(curTower[0]).append(" ");
					tower.push(nowTower);
					break;
				}else {
					tower.pop();
				}
			}
		}
		System.out.print(sb);
	}
}

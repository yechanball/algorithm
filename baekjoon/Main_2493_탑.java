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
		Stack<Integer> tower = new Stack<>();
		for (int i = 0; i < N; i++) {
			tower.push(Integer.parseInt(st.nextToken()));
		}
		Stack<Integer> contact = new Stack<>();
		boolean isContact = false;
		int nowTower;
		while (!tower.empty()) {
			isContact = false;
			nowTower = tower.pop();
			
			for (int j = tower.size()-1; j >= 0; j--) {
				if(tower.elementAt(j) > nowTower) {
					isContact = true;
					contact.push(j+1);
					break;
				}
			}
			if(!isContact) contact.push(0);
		}
		int size = contact.size();
		for (int i = 0; i < size; i++) {
			sb.append(contact.pop()).append(" ");
		}
		System.out.print(sb);
	}
}

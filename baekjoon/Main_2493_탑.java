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
		int[] tower = new int[N];
		for (int i = 0; i < N; i++) {
			tower[i] = Integer.parseInt(st.nextToken());
		}
		Stack<Integer> stack = new Stack<>();
		boolean isContact = false;
		for (int i = N-1; i >= 0; i--) {
			isContact = false;
			for (int j = i-1; j >= 0; j--) {
				if(tower[j] > tower[i]) {
					isContact = true;
					stack.push(j+1);
					break;
				}
			}
			if(!isContact) stack.push(0);
		}
		int size = stack.size();
		for (int i = 0; i < size; i++) {
			sb.append(stack.pop()).append(" ");
		}
		System.out.print(sb);
	}
}

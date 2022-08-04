package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main_2164_카드2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		Queue<Integer> card = new ArrayDeque<>();
		// 초기화
		for(int i = 1; i <= N; i++) {
			card.offer(i);			
		}
		// 1개 남을때까지 루틴 반복
		while(card.size() > 1) { 
			card.poll();
			card.offer(card.poll());
		}
		System.out.print(card.peek());
	}
}

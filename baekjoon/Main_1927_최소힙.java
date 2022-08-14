package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main_1927_최소힙 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		PriorityQueue<Integer> pQ = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer n1, Integer n2) { // 오름차순 정렬
				return n1 - n2;
			}
		});
		int N = Integer.parseInt(in.readLine());
		int num;
		for (int i = 0; i < N; i++) {
			num = Integer.parseInt(in.readLine()); 
			if(num == 0) {
				if(pQ.isEmpty()) sb.append(0).append("\n"); // 비어있는데 출력하는 경우
				else sb.append(pQ.poll()).append("\n"); // 최솟값 출력
			}else {
				pQ.offer(num); // 0이 아닌 경우 삽입
			}
		}
		out.write(sb.toString());
		out.flush();
		out.close();
	}
}

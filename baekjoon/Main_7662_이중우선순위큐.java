package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_7662_이중우선순위큐 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			PriorityQueue<Integer> minQ = new PriorityQueue<>(new Comparator<Integer>() {
				@Override
				public int compare(Integer n1, Integer n2) { // 오름차순 정렬
					return n1 - n2;
				}
			});
			
			PriorityQueue<Integer> maxQ = new PriorityQueue<>(new Comparator<Integer>() {
				@Override
				public int compare(Integer n1, Integer n2) { // 내림차순 정렬
					return n2 - n1;
				}
			});
			
			int size = 0; // 큐 사이즈
			int N = Integer.parseInt(in.readLine());
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				char input = st.nextToken().charAt(0);
				int num = Integer.parseInt(st.nextToken());
				
				if(input == 'D') { // D 연산인 경우 삭제
					if(size != 0) {
						if(num == 1) maxQ.poll(); // D 1 : 최댓값 제거
						else minQ.poll(); // D -1 : 최솟값 제거
						size--;
					}
				}else { // I 연산인 경우 삽입
					minQ.offer(num);
					maxQ.offer(num);
					size++;
				}
			}
			if(size == 0) sb.append("EMPTY").append("\n"); // 비어있는 경우
			else sb.append(maxQ.poll()).append(" ").append(minQ.poll()).append("\n"); // 최댓값 최솟값 출력
		}
		out.write(sb.toString());
		out.flush();
		out.close();
	}
}
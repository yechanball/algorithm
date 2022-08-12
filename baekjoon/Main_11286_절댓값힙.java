package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main_11286_절댓값힙 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		// int[2]를 저장하는 우선 순위 큐 생성, 0: 절댓값, 1: 원래 값
		PriorityQueue<int[]> pQ = new PriorityQueue<>(new Comparator<int[]>() { 
			@Override
			public int compare(int[] n1, int[] n2) { // 오름차순 정렬
				if(n1[0] == n2[0]) return n1[1] - n2[1]; // 절댓값이 같을때 원래 값 비교하기
				return n1[0] - n2[0]; // 절댓값 비교하기
			}
		});
		int N = Integer.parseInt(in.readLine());
		int x;
		for (int i = 0; i < N; i++) {
			x = Integer.parseInt(in.readLine());
			if(x == 0) { // x=0인경우 최솟값 뽑기
				if(pQ.isEmpty()) { // 힙이 비어있는 경우
					sb.append(0).append("\n");
				}else {
					sb.append(pQ.poll()[1]).append("\n"); // 맨 앞 최솟값 뽑아 출력
				}
			}else { // x가 0이 아닌 경우 큐에 넣기
				pQ.add(new int[] {Math.abs(x), x});
			}
		}
		out.write(sb.toString());
		out.flush();
		out.close();
	}
}

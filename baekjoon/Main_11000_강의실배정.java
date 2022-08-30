package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_11000_강의실배정 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		List<int[]> time = new ArrayList<int[]>(); // {강의 시작 시간, 강의 끝나는 시간}
		int N = Integer.parseInt(in.readLine());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			time.add(new int[] {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())});
		}
		
		Collections.sort(time, new Comparator<int[]>() { // 강의 시작시간 오름차순 정렬, 강의 시작 시간이 같다면 강의 끝나는 시간 오름차순 정렬
			@Override
			public int compare(int[] t1, int[] t2) {
				return t1[0] != t2[0] ? t1[0]-t2[0] : t1[1]-t2[1];
			}
		});
		
		PriorityQueue<Integer> pQ = new PriorityQueue<>(); // 가장 빠른 종료시간 우선순위 큐
		pQ.offer(time.get(0)[1]); // 가장 빨리 시작하는 강의의 종료 시간
		
		for (int i = 1; i < N; i++) {
			if(time.get(i)[0] >= pQ.peek()) { // 강의의 시작 시간과 강의 끝나는 시간 비교
				pQ.poll();
			}
			pQ.offer(time.get(i)[1]);
		}
		
		out.write(Integer.toString(pQ.size())); // 필요한 강의실 개수 출력
		out.flush();
		out.close();
	}
}

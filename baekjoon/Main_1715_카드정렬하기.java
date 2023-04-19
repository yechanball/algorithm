package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main_1715_카드정렬하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		
		PriorityQueue<Long> pq = new PriorityQueue<>();
		for (int i = 0; i <N; i++) {
			pq.add(Long.parseLong(in.readLine()));
		}
		
		long cnt = 0;
		while(pq.size() > 1) {
			long tmpCnt = pq.poll() + pq.poll();
			cnt += tmpCnt;
			pq.add(tmpCnt);
		}
		
		System.out.print(cnt);
	}
}

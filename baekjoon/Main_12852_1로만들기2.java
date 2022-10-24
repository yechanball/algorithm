package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main_12852_1로만들기2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(in.readLine());
		int[] pre = new int[N+1]; // 이전 숫자 정보 저장
		int[] cnt = new int[N+1]; // 각 숫자를 만들기까지 필요한 횟수
		
		Deque<Integer> q = new ArrayDeque<Integer>();
		q.offer(N);
		while(!q.isEmpty()) {
			int now = q.poll();
			
			if(now == 1 || now == 0) continue;
			
			int next;
			if(now%3 == 0) {
				next = now/3;
				if(cnt[next] == 0 || cnt[next] > cnt[now] + 1) {
					cnt[next] = cnt[now] + 1;
					pre[next] = now;
					q.offer(next);
				}
			}
			
			if(now%2 == 0) {
				next = now/2;
				if(cnt[next] == 0 || cnt[next] > cnt[now] + 1) {
					cnt[next] = cnt[now] + 1;
					pre[next] = now;
					q.offer(next);
				}
			}
			
			next = now-1;
			if(cnt[next] == 0 || cnt[next] > cnt[now] + 1) {
				cnt[next] = cnt[now] + 1;
				pre[next] = now;
				q.offer(next);
			}
		}
		
		int idx = 1;
		sb.insert(0, 1);
		while(idx != N) {
			sb.insert(0, pre[idx] + " ");
			idx = pre[idx];
		}
		sb.insert(0, cnt[1] + "\n");

		out.write(sb.toString());
		out.flush();
		out.close();
	}
}

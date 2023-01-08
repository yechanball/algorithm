package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_13913_숨바꼭질4 {
	static int[] preNode;
	static int[] time;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		preNode = new int[100001];
		time = new int[100001];
		
		findBro(N, K);
		
		StringBuilder sb = new StringBuilder();
		int idx = K;
		while(true) {
			sb.insert(0, idx + " ");
			if(idx == N) break;
			idx = preNode[idx];
		}
		
		out.write(Integer.toString(time[K] - 1) + "\n" + sb.toString());
		out.flush();
		out.close();
	}
	
	public static void findBro(int N, int K) {
		Deque<Integer> q = new ArrayDeque<>();
		q.offer(N);
		time[N] = 1;
		
		while(!q.isEmpty()) {
			int now = q.poll();

			if(now == K) return;
			
			if(now*2 <= 100000 && time[now*2] == 0) {
				q.offer(now*2);
				time[now*2] = time[now] + 1;
				preNode[now*2] = now;
			}
			if(now+1 <= 100000 && time[now+1] == 0) {
				q.offer(now+1);
				time[now+1] = time[now] + 1;
				preNode[now+1] = now;
			}
			if(now-1 >= 0 && time[now-1] == 0) {
				q.offer(now-1);
				time[now-1] = time[now] + 1;
				preNode[now-1] = now;
			}
		}
	}
}

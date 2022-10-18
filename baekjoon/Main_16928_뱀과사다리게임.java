package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_16928_뱀과사다리게임 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] jump = new int[101];
		int u, v;
		for (int i = 0; i < N+M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			jump[u] = v;
		}
		
		int[] time = new int[101];
		Deque<Integer> q = new ArrayDeque<Integer>();
		q.offer(1);
		q.offer(0);
		
		while(!q.isEmpty()) {
			int now = q.poll();
			int nowTime = q.poll();
			
			for (int i = 6; i >= 1; i--) {
				int next = now + i;
				
				if(next > 100) continue;
				
				if(time[next] != 0 && time[next] <= nowTime+1) 
					continue;
				
				if(jump[next] != 0) { // 사다리 또는 뱀이 있는 경우
					q.offer(jump[next]);
					q.offer(nowTime+1);					
					time[next] = nowTime+1;
					time[jump[next]] = nowTime+1;							
				}else {
					q.offer(next);
					q.offer(nowTime+1);
					time[next] = nowTime+1;		
				}
				
			}
		}
		
		System.out.print(time[100]);
	}
}

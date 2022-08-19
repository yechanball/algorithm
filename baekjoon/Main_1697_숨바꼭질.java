package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_1697_숨바꼭질 {
	static int fastTime = Integer.MAX_VALUE;
	static int[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		visited = new int[100001];
		findBro(N, K);
		out.write(Integer.toString(fastTime));
		out.flush();
		out.close();
	}
	
	public static void findBro(int N, int K) {
		Deque<Integer> q = new ArrayDeque<Integer>();
		q.offer(N);
		visited[N] = 0;
		
		while(!q.isEmpty()) {
			int now = q.poll();
			
			if(now == K) { // 수빈이가 동생과 같은 위치에 있는 경우
				fastTime = (visited[K] < fastTime) ? visited[K] : fastTime;
			}else {
				if(now-1 >= 0 && visited[now-1] == 0) {
					q.offer(now-1);
					visited[now-1] = visited[now]+1;
				}							
				if(now+1 <= 100000 && visited[now+1] == 0) {
					q.offer(now+1);
					visited[now+1] = visited[now]+1;
				}
				if(now*2 <= 100000 && visited[now*2] == 0) {
					q.offer(now*2);
					visited[now*2] = visited[now]+1;
				}
			}
		}
	}
}

package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_13549_숨바꼭질3 {
	static int fastTime = Integer.MAX_VALUE;
	static boolean[] visited;
	
	static class Node{
		int num;
		int time;
		
		public Node(int num, int time) {
			this.num = num;
			this.time = time;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		visited = new boolean[100001];
		findBro(N, K);
		out.write(Integer.toString(fastTime));
		out.flush();
		out.close();
	}
	
	public static void findBro(int N, int K) {
		Deque<Node> q = new ArrayDeque<>();
		q.offer(new Node(N, 0));
		
		while(!q.isEmpty()) {
			Node now = q.poll();
			visited[now.num] = true;
			
			if(now.num == K) // 수빈이가 동생과 같은 위치에 있는 경우
				fastTime = (now.time < fastTime) ? now.time : fastTime;
			
			if(now.num*2 <= 100000 && !visited[now.num*2])
				q.offer(new Node(now.num*2, now.time));
			if(now.num+1 <= 100000 && !visited[now.num+1]) 
				q.offer(new Node(now.num+1, now.time+1));
			if(now.num-1 >= 0 && !visited[now.num-1]) 
				q.offer(new Node(now.num-1, now.time+1));
		}
	}
}

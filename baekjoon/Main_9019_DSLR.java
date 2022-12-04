package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_9019_DSLR {
	static String[] queryName = {"D","S","L","R"};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine());
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(in.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			sb.append(bfs(A, B) + "\n");
		}
		
		out.write(sb.toString());
		out.flush();
		out.close();
	}

	private static String bfs(int A, int B) {
		String[] query = new String[10000];

		Queue<Integer> q = new ArrayDeque<Integer>();
		q.offer(A);
		query[A] = "";

		while(query[B] == null && !q.isEmpty()) {
			int now = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int next = calc(now, i);
				if(query[next] != null) continue;
				q.offer(next);
				query[next] = query[now] + queryName[i];
			}
		}
		
		return query[B];
	}

	private static int calc(int n, int query) {
		if(query == 0) { // D: n*2
			return n*2 % 10000;
		}else if(query == 1) { // S: n-1
			return (n == 0) ? 9999 : n-1;
		}else if(query == 2) { // L: left shift
			return n*10%10000 + n/1000;
		}else { // R: right shift
			return n/10 + n%10*1000;			
		}
	}
}

package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2623_음악프로그램 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		List<Integer>[] adjList = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			adjList[i] = new ArrayList<>();
		}

		int[] indegree = new int[N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int singerCnt = Integer.parseInt(st.nextToken());
			int preSinger = Integer.parseInt(st.nextToken());

			while (st.hasMoreTokens()) {
				int singer = Integer.parseInt(st.nextToken());

				adjList[preSinger].add(singer);
				indegree[singer]++;
				preSinger = singer;
			}
		}

		// 위상 정렬
		Queue<Integer> que = new ArrayDeque<>();
		List<Integer> result = new ArrayList<>();

		for (int i = 1; i <= N; i++) {
			if (indegree[i] == 0) que.offer(i);
		}

		while (!que.isEmpty()) {
			int curr = que.poll();
			result.add(curr);

			for (int next : adjList[curr]) {
				indegree[next]--;

				if (indegree[next] == 0) que.offer(next);
			}
		}

		if (result.size() == N) {
			for (int i = 0; i < N; i++) {
				sb.append(result.get(i) + "\n");
			}
		}else{
			sb.append("0");
		}

		out.write(sb.toString());
		out.flush();
		out.close();
	}
}

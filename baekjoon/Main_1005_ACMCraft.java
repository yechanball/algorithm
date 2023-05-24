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

public class Main_1005_ACMCraft {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(in.readLine());
		for(int tc = 0; tc < T; tc++){
			StringTokenizer st = new StringTokenizer(in.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			int[] D = new int[N+1];
			List<Integer>[] adjList = new ArrayList[N+1];

			st = new StringTokenizer(in.readLine());
			for (int i = 1; i <= N; i++) {
				adjList[i] = new ArrayList<>();
				D[i] = Integer.parseInt(st.nextToken());
			}

			int[] inDegree = new int[N + 1];
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(in.readLine());
				int prev = Integer.parseInt(st.nextToken());
				int next = Integer.parseInt(st.nextToken());

				adjList[prev].add(next);
				inDegree[next]++;
			}

			int W = Integer.parseInt(in.readLine());
			int minTime = topologySort(adjList, inDegree, D, N, W);

			out.write(minTime + "\n");
		}
		out.flush();
		out.close();
	}

	public static int topologySort(List<Integer>[] adjList, int[] inDegree, int[] D, int N, int W){
		Queue<Integer> que = new ArrayDeque<>();
		for (int i = 1; i <= N; i++) {
			if (inDegree[i] == 0) que.offer(i);
		}

		int[] prevTime = new int[N+1];
		while (!que.isEmpty()) {
			int curr = que.poll();

			for (int next : adjList[curr]) {
				prevTime[next] = Math.max(prevTime[next], prevTime[curr] + D[curr]);
				inDegree[next]--;

				if (inDegree[next] == 0){
					que.offer(next);

					if(next == W){
						return prevTime[W] + D[W];
					}
				}
			}
		}
		return prevTime[W] + D[W];
	}
}

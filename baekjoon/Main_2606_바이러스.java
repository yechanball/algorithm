package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_2606_바이러스 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N = Integer.parseInt(in.readLine());
		boolean[][] connect = new boolean[N+1][N+1];
		int com1, com2, sickCom = -1;
		int P = Integer.parseInt(in.readLine());
		for (int i = 0; i < P; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			com1 = Integer.parseInt(st.nextToken());
			com2 = Integer.parseInt(st.nextToken());
			connect[com1][com2] = true;
			connect[com2][com1] = true;
		}
		Deque<Integer> queue = new ArrayDeque<Integer>();
		boolean[] visited = new boolean[N+1];
		queue.add(1);
		while(!queue.isEmpty()) {
			int nowCom = queue.poll();
			visited[nowCom] = true;
			sickCom++;
			for (int i = 1; i <= N; i++) {
				if(connect[nowCom][i] == true && !visited[i]) { // 현재 컴퓨터와 연결되어 있고 방문하지 않은 컴퓨터 큐에 넣기
					visited[i] = true; // 체크한 컴퓨터는 방문 체크하기
					queue.offer(i);
				}
			}
		}
		out.write(Integer.toString(sickCom));
		out.flush();
		out.close();
	}
}

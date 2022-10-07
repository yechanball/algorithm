package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main_17471_게리맨더링 {
	static int N; // 구역 개수
	static int minDiff = Integer.MAX_VALUE; // 최소 인구 차이
	static int[] pop; // 인구
	static List<Integer>[] adjList; // 인접 구역 정보
	static boolean[] select; // 선택된 선거구
	static boolean[] visited; // 방문 확인 배열
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(in.readLine());
		pop = new int[N+1];
		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			pop[i] = Integer.parseInt(st.nextToken());
		}

		adjList = new List[N+1];
		for (int i = 1; i <= N; i++) {
			adjList[i] = new ArrayList<Integer>();
			
			st = new StringTokenizer(in.readLine(), " ");
			int size = Integer.parseInt(st.nextToken());
			for (int j = 0; j < size; j++) {
				adjList[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		
		select = new boolean[N+1];
		for (int i = 1; i <= N/2; i++) {
			combi(i, 1, i); // 선거구 선택
		}
		
		if(minDiff == Integer.MAX_VALUE) // 선거구를 나눌 수 없는 경우
			out.write("-1");
		else
			out.write(Integer.toString(minDiff));
		out.flush();
		out.close();
	}
	
	public static void combi(int cnt, int start, int selectCnt) { // 조합
		if(cnt == 0) { // 선거구를 다 뽑은 경우
			visited = new boolean[N+1];
			if(bfsSelect(selectCnt) && bfsOther(N - selectCnt)) { // 각 선거구의 구역들이 연결되어 있는 경우
				int popDiff = 0;
				for (int i = 1; i <= N; i++) {
					if(select[i]) {
						popDiff += pop[i];
					}else {
						popDiff -= pop[i];
					}
				}
				minDiff = Math.min(Math.abs(popDiff), minDiff);
			}
			
			return;
		}
		
		for (int i = start; i <= N; i++) {
			select[i] = true;
			combi(cnt-1, i+1, selectCnt);
			select[i] = false;
		}
	}

	private static boolean bfsSelect(int selectCnt) { // 선택된 선거구가 연결되었는지 확인
		int cnt = 0;
		
		Deque<Integer> q = new ArrayDeque<Integer>();
		for (int i = 1; i <= N; i++) {
			if(select[i]) {
				q.offer(i);
				cnt++;
				visited[i] = true;
				break;
			}
		}
		
		while (!q.isEmpty()) {
			int now = q.poll();

			for (int next : adjList[now]) {
				if(select[next] && !visited[next]) {
					q.offer(next);
					cnt++;
					visited[next] = true;
				}
			}
			
			if(selectCnt == cnt) // 전부 연결되어 있는 경우 참 반환
				return true;
		}
		
		return false;
	}
	
	private static boolean bfsOther(int otherCnt) { // 선택되지 않은 선거구가 연결되었는지 확인
		int cnt = 0;
		
		Deque<Integer> q = new ArrayDeque<Integer>();
		for (int i = 1; i <= N; i++) {
			if(!select[i]) {
				q.offer(i);
				cnt++;
				visited[i] = true;
				break;
			}
		}
		
		while (!q.isEmpty()) {
			int now = q.poll();
			
			for (int next : adjList[now]) {
				if(!select[next] && !visited[next]) {
					q.offer(next);
					cnt++;
					visited[next] = true;
				}
			}
			
			if(otherCnt == cnt) // 전부 연결되어 있는 경우 참 반환
				return true;
		}
		
		return false;
	}
}

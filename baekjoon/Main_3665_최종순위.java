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

public class Main_3665_최종순위 {
	static int V; // 정점의 수
	static List<Integer>[] adjList; // 각 정점별 인접리스트
	static int[] inDegree; // 정점별 진입차수
	static List<Integer> input; // 처음 입력 받은 순위
	static List<Integer> result; // 최종 순위 순서
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(in.readLine()); // 테스트 케이스
		for (int tc = 1; tc <= T; tc++) {
			V = Integer.parseInt(in.readLine());
			
			adjList = new ArrayList[V+1];
			inDegree = new int[V+1];
			
			input = new ArrayList<Integer>();
			st = new StringTokenizer(in.readLine(), " ");
			for (int i = 0; i < V; i++) {
				input.add(Integer.parseInt(st.nextToken()));
			}
			
			int from, to;
			for (int i = 0; i < V; i++) {
				from = input.get(i);
				if(adjList[from] == null) {
					adjList[from] = new ArrayList<Integer>();
				}
				for (int j = i+1; j < V; j++) {
					to = input.get(j);
					adjList[from].add(to); // 정점 연결 정보 입력
					inDegree[to]++; // 연결되어 있는 정점 진입차수 늘리기					
				}
			}
			
			int m = Integer.parseInt(in.readLine()); // 바뀐 쌍의 개수
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				from = Integer.parseInt(st.nextToken());
				to = Integer.parseInt(st.nextToken());
				
				if(adjList[from].contains(to)) { // 위상 순서 변경
					adjList[from].remove((Integer)to);
					adjList[to].add(from);
					inDegree[from]++;
					inDegree[to]--;					
				}
				else {
					adjList[to].remove((Integer)from);
					adjList[from].add(to);
					inDegree[to]++;
					inDegree[from]--;										
				}
			}
			
			result = new ArrayList<Integer>();
			topologySort(); // 위상 정렬 실행
			
			if(result.size() == V) { // 결과 최종순위의 개수가 모든 팀의 수가 맞아야 확실한 순위를 찾은 경우
				for (int team : result) {
					sb.append(team).append(" ");
				}
				sb.append("\n");
			}else { // 아닌 경우는 불가능 출력
				sb.append("IMPOSSIBLE").append("\n");
			}
		}
		
		out.write(sb.toString());
		out.flush();
		out.close();
	}
	
	private static void topologySort(){
		Queue<Integer> queue = new ArrayDeque<>();
		
		// 진입차수가 0인 정점 큐에 넣기
		for (int i = 1; i <= V; i++) {
			if(inDegree[i] == 0) queue.offer(i);
		}
		
		while(!queue.isEmpty()) { // 인접 정점 탐색
			int curr = queue.poll();
			result.add(curr);
			
			if(adjList[curr] == null) continue;
			
			for (int next : adjList[curr]) {
				if(--inDegree[next]==0) queue.offer(next); // 인접 정점이 현재 정점을 제외했을때 진입차수가 0이 되면 큐에 넣기
			}
		}
	}
}

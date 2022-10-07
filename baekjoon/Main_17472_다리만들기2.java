package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

class Edge {
	int from;
	int to;
	int length;
	
	public Edge(int from, int to, int length) {
		super();
		this.from = from;
		this.to = to;
		this.length = length;
	}
}

public class Main_17472_다리만들기2 {
	static int N, M; // 세로, 가로
	static int landCnt = 0; // 섬 개수
	static int[][] map; // 지도
	static boolean[][] visited;
	static int[][] dist; // 두 섬 사이 거리
	static int[] parents; // 대표 정보 배열
	static List<Edge> edgeList = new ArrayList<Edge>(); // 섬과 섬 사이 간선 정보
	static int[] dr = new int[] {-1, 1, 0, 0};
	static int[] dc = new int[] {0, 0, -1, 1};
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(!visited[i][j] && map[i][j] == 1) {
					landCnt++;
					bfs(i, j); // 같은 섬 영역끼리 체크
				}
			}
		}
		
		//////////////////////////////////////////////////////
		/*System.out.println("----- 섬 정보 -------");
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}*/
		///////////////////////////////////////////////////////
		
		dist = new int[landCnt+1][landCnt+1];
		for (int i = 0; i <= landCnt; i++) {
			for (int j = 0; j <= landCnt; j++) {
				dist[i][j] = Integer.MAX_VALUE; // 두 섬 사이 거리 무한대 초기화
			}
		}
		
		for (int i = 0; i < N; i++) { // 두 섬 사이 최소 거리 찾기
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 0) continue; // 섬이 아닌 경우 생략
				
				for (int d = 0; d < 4; d++) { // 연결할 수 있는 섬 탐색
					int nr = i;
					int nc = j;
					int cnt = 0; // 두 섬 사이 거리
					
					while(true) { // 상하좌우 일직선 상에 섬이 있는지 체크
						nr += dr[d];
						nc += dc[d];
						
						if(nr < 0 || nr >= N || nc < 0 || nc >= M || map[nr][nc] == map[i][j]) // 범위를 벗어나거나 같은 섬인 경우
							break;
						
						if(map[nr][nc] == 0) { // 바다인 경우는 다음 칸 탐색
							cnt++;
							continue;
						}
						
						if(cnt < 2) // 다리길이가 2미만인 경우 종료
							break;
						
						if(cnt < dist[map[i][j]][map[nr][nc]] || cnt < dist[map[nr][nc]][map[i][j]]) { // 두 섬 사이 거리 최솟값 갱신
							dist[map[i][j]][map[nr][nc]] = cnt;
							dist[map[nr][nc]][map[i][j]] = cnt;
						}
						break;
					}
				}
			}
		}
		
		//////////////////////////////////////////////////////
		/*System.out.println("----- 간선 정보 -------");
		for (int i = 1; i <= landCnt; i++) {
			for (int j = 1; j <= landCnt; j++) {
				if(dist[i][j] == Integer.MAX_VALUE) System.out.print("0 ");
				else System.out.print(dist[i][j] + " ");
			}
			System.out.println();
		}*/
		///////////////////////////////////////////////////////
		
		for (int i = 1; i <= landCnt; i++) { // 섬 사이 간선 정보 추출
			for (int j = 1; j <= landCnt; j++) {
				if(dist[i][j] == Integer.MAX_VALUE) continue;
				
				edgeList.add(new Edge(i, j, dist[i][j])); // 간선 정보 추가
				dist[j][i] = Integer.MAX_VALUE;
			}
		}
		
		Collections.sort(edgeList, new Comparator<Edge>() { // 다리 길이 오름차순 정렬
			@Override
			public int compare(Edge e1, Edge e2) {
				return e1.length - e2.length;
			}
		});
		
		parents = new int[landCnt+1];
		for (int i = 1; i <= landCnt; i++) {
			parents[i] = i;
		}
		
		int totalLength = 0;
		int edgeCnt = 0; 
		for (Edge edge : edgeList) {  // 길이가 짧은 다리부터 연결
			if(union(edge.from, edge.to)) {
				totalLength += edge.length;
				edgeCnt++;
			}
		}
		
		if(edgeCnt == landCnt-1 && totalLength != 0)
			out.write(Integer.toString(totalLength));			
		else // 모든 섬을 연결할 수 없는 경우
			out.write("-1");
		out.flush();
		out.close();
	}
	
	private static void bfs(int row, int col) {
		Deque<Integer> q = new ArrayDeque<Integer>();
		q.offer(row);
		q.offer(col);
		map[row][col] = landCnt;
		visited[row][col] = true;
		
		while (!q.isEmpty()) {
			int r = q.poll();
			int c = q.poll();

			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc] || map[nr][nc] == 0) {
					continue;
				}
				
				q.offer(nr);
				q.offer(nc);
				map[nr][nc] = landCnt;
				visited[nr][nc] = true;
			}
		}
	}
	
	private static int find(int a) {
		if(parents[a] == a) return a;
		
		return parents[a] = find(parents[a]);
	}
	
	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot == bRoot) return false;
		
		parents[bRoot] = aRoot;
		return true;
	}
}

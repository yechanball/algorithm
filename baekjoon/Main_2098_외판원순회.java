package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2098_외판원순회 {
	static int N; // 도시 개수
	static int[][] map; // 도시간 이동 비용
	static int[][] dp; // dp에 사용할 배열
	static final int INF = 15_000_000; // 각 사이의 거리가 1,000,000이하, 최대 16개의 도시 -> 15개의 간선
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(in.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp = new int[N][(1 << N) - 1]; // 2진수로 N자리 생성 -> 비트마스킹 활용
		for (int i = 0; i < N; i++) {
			for (int j = 0, size = (1 << N) - 1; j < size; j++) {
				dp[i][j] = INF; // 초기화
			}
		}

		System.out.print(dfs(0, 1)); // 0번 도시를 시작점으로 모든 도시 순회하기
	}
	
	public static int dfs(int city, int visit) { // 깊이 우선 탐색 (도시 번호, 방문 도시 비트마스킹)
		if(visit == (1<<N)-1) { // N개의 도시를 전부 순회한 경우
			return (map[city][0] == 0) ? INF : map[city][0];  // 마지막 도시에서 시작도시로 오는 길이 없다면 INF, 있다면 거리 반환
		}
		
		if(dp[city][visit] != INF) { // 이미 해당 경로를 방문하여 값이 존재하는 경우 값 반환
			return dp[city][visit];
		}
		
		for (int i = 0; i < N; i++) {
			if((visit & (1<<i)) == 0 && map[city][i] != 0 ) { // city -> i로 가는 길이 있고, i 도시를 방문하지 않은 경우
				dp[city][visit] = Math.min(dp[city][visit], dfs(i, visit | (1<<i)) + map[city][i]);
			}
		}
		
		return dp[city][visit];
	}
}
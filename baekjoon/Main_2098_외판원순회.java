package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2098_외판원순회 {
	static int N, bitMax; // 도시 개수
	static int[][] map; // 도시간 이동 비용
	static int[][] dp; // dp에 사용할 배열
	static final int INF = 16_000_000; // 각 사이의 거리가 1,000,000이하, 최대 16개의 도시
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(in.readLine());
		bitMax = (1 << N) - 1;
		map = new int[N][N];
		dp = new int[N][bitMax]; // 2진수로 N자리 생성 -> 비트마스킹 활용
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
			Arrays.fill(dp[i], -1);
		}

		System.out.print(dfs(0, 1)); // 0번 도시를 시작점으로 모든 도시 순회하기
	}
	
	public static int dfs(int city, int visit) { // 깊이 우선 탐색 (도시 번호, 방문 도시 비트마스킹)
		if(visit == bitMax) { // N개의 도시를 전부 순회한 경우
			return (map[city][0] == 0) ? INF : map[city][0];  // 마지막 도시에서 시작도시로 오는 길이 없다면 INF, 있다면 거리 반환
		}
		
		if(dp[city][visit] != -1) { // 이미 해당 경로를 방문하여 값이 존재하는 경우 값 반환
			return dp[city][visit];
		}
		
		dp[city][visit] = INF;
		
		for (int i = 0; i < N; i++) {
			if(map[city][i] == 0 || (visit & (1<<i)) != 0)  // i번 도시를 이미 방문했거나 city -> i로 가는 길이 없는 경우
				continue;
			
			dp[city][visit] = Math.min(dp[city][visit], dfs(i, visit | (1<<i)) + map[city][i]);
		}
		
		return dp[city][visit];
	}
}
package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_16991_외판원순회3 {
	static int N, bitMax; // 도시 개수
	static double[][] map; // 도시간 이동 비용
	static double[][] dp; // dp에 사용할 배열
	static final double INF = 1_000_000;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(in.readLine());
		bitMax = (1 << N) - 1;
		
		int[][] pos = new int[N][2];		
		for (int i = 0; i < N; i++) { // 좌표 입력
			st = new StringTokenizer(in.readLine(), " ");
			pos[i][0] = Integer.parseInt(st.nextToken());
			pos[i][1] = Integer.parseInt(st.nextToken());
		}
		
		map = new double[N][N];
		dp = new double[N][bitMax]; // 2진수로 N자리 생성 -> 비트마스킹 활용
		for (int i = 0; i < N; i++) {
			int x1 = pos[i][0];
			int y1 = pos[i][1];
			
			for (int j = 0; j < N; j++) {
				if(i == j) continue;
				int x2 = pos[j][0];
				int y2 = pos[j][1];
				
				map[i][j] = Math.sqrt((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1)); // 거리 계산 후 배열 채우기
			}
			Arrays.fill(dp[i], -1);
		}

		System.out.print(dfs(0, 1)); // 0번 도시를 시작점으로 모든 도시 순회하기
	}
	
	public static double dfs(int city, int visit) { // 깊이 우선 탐색 (도시 번호, 방문 도시 비트마스킹)
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
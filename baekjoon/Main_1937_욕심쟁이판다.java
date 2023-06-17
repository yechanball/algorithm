package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1937_욕심쟁이판다 {
    static int N;
    static int[][] map;
    static int[][] dp;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
 
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
        	StringTokenizer st = new StringTokenizer(in.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
 
        int maxMove = 0;
        dp = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                maxMove = Math.max(maxMove, dfs(i, j));
            }
        }
 
        System.out.println(maxMove);
    }
 
    public static int dfs(int r, int c) {
        if (dp[r][c] != 0) return dp[r][c];
        
        dp[r][c] = 1;
        
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            
            if (nr < 0 || nc < 0 || nr >= N || nc >= N || map[nr][nc] <= map[r][c]) continue;
            
            dp[r][c] = Math.max(dp[r][c], dfs(nr, nc) + 1);
        }
        
        return dp[r][c];
    }
}

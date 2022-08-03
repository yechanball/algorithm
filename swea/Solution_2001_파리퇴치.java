package algorithm.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2001_파리퇴치 {
    public static void main(String args[]) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(in.readLine());
        for (int testcase = 1; testcase <= T; testcase++) {
            sb.append("#").append(testcase).append(" ");
            st = new StringTokenizer(in.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[][] arr = new int[N][N];
            int sum, max = Integer.MIN_VALUE;
            int num = N - M + 1;
            // 배열 입력
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(in.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            // 파리채 영역 합 계산 및 최댓 값 찾기
            for (int i = 0; i < num; i++) {
                for (int j = 0; j < num; j++) {
                    sum = 0;
                    for (int k = i; k < i + M; k++) {
                        for (int p = j; p < j + M; p++) {
                            sum += arr[k][p];
                        }
                    }
                    if (sum > max) {
                        max = sum;
                    }
                }
            }
            sb.append(max).append("\n");
        }
        System.out.print(sb);
    }
}
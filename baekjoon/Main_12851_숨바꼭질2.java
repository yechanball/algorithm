package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_12851_숨바꼭질2 {
	public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] result = bfs(N, K);

        System.out.print(result[0] + "\n" + result[1]);
    }

    private static int[] bfs(int N, int K) {
        int[] time = new int[100_001];
        Arrays.fill(time, Integer.MAX_VALUE);
        int cnt = 0;

        Queue<Integer> q = new ArrayDeque<>();
        q.offer(N);
        time[N] = 0;

        while(!q.isEmpty()){
            int now = q.poll();

            if(now == K) cnt++;

            if(now+1 <= 100_000 && time[now+1] >= time[now] + 1) {
                q.offer(now+1);
                time[now+1] = time[now] + 1;
            }
            if(now-1 >= 0 && time[now-1] >= time[now] + 1) {
                q.offer(now-1);
                time[now-1] = time[now] + 1;
            }
            if(now*2 <= 100_000 && time[now*2] >= time[now] + 1) {
                q.offer(now*2);
                time[now*2] = time[now] + 1;
            }
        }

        int[] result = new int[2];
        result[0] = time[K];
        result[1] = cnt;

        return result;
    }
}

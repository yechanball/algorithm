package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10986_나머지합 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

        long ans = 0;
		long[] A = new long[N+1];
		long[] cnt = new long[M];
		
		st = new StringTokenizer(in.readLine());
		for (int i = 1; i <= N; i++) {
			A[i] = (A[i-1] + Integer.parseInt(st.nextToken())) % M;			
            cnt[(int)A[i]]++;
            
            if(A[i] == 0) ans++;
		}

        for (int i = 0; i < M; i++) {
            if(cnt[i] > 1) ans += (cnt[i] * (cnt[i]-1) / 2);
        }
        System.out.println(ans);
	}
}

package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2501_약수구하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int cnt = 0, ans = 0;
		for(int i = 1; i <= N; i++) {
			if(N % i == 0) cnt++;
			
			if(cnt == K) {
				ans = i;
				break;
			}
		}
		System.out.println(ans);
	}
}

package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1300_K번째수 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int k = Integer.parseInt(in.readLine());

		int left = 1, right = k, mid;
		int ans = 0;

		while(left <= right) {
			mid = (left + right) / 2;

			int cnt = 0;
			for (int i = 1; i <= N; i++){
				cnt += Math.min(N, mid/i);
			}

			if (cnt < k) {
				left = mid + 1;
			}else {
				ans = mid;
				right = mid - 1;
			}
		}
		
		System.out.println(ans);
	}
}

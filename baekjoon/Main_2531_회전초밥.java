package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2531_회전초밥 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		int[] belt = new int[N+K];
		int[] susi = new int[D+1];
		for (int i = 0; i < N; i++) {
			belt[i] = Integer.parseInt(in.readLine());
		}
		for (int i = N; i < N+K; i++) {
			belt[i] = belt[i-N];
		}
				
		int start = 0;
		int end = K-1;
		int dish = 0;
		for (int i = start; i <= end; i++) {
			if(susi[belt[i]] == 0) dish++;
			susi[belt[i]]++;
		}

		int maxDish = (susi[C] == 0) ? dish+1 : dish;
		
		while(start < N) {
			if(susi[belt[start]] == 1) dish--;
			susi[belt[start++]]--;
			
			if(susi[belt[++end]] == 0) dish++;
			susi[belt[end]]++;
		
			maxDish = (susi[C] == 0) ? Math.max(dish+1, maxDish) : Math.max(dish, maxDish);
		}
		
		System.out.print(maxDish);
	}
}

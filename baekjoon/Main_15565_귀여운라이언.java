package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15565_귀여운라이언 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] dolls = new int[N];
		int start = -1, end = 0, ryanCnt = 0;
		int minSize = Integer.MAX_VALUE;
		
		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < N; i++) {
			dolls[i] = Integer.parseInt(st.nextToken());
			if(dolls[i] == 2) continue;
			
			if(start == -1) start = i;
			end = i;
			if(++ryanCnt == K) {
				minSize = Math.min(end-start+1, minSize);
				for (int j = start+1; j <= end; j++) {
					if(dolls[j] == 1) {
						start = j;
						ryanCnt--;
						break;
					}
				}
			}
		}
		
		System.out.print((minSize == Integer.MAX_VALUE) ? -1 : minSize);	
	}
}

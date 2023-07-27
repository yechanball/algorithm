package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2110_공유기설치 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		int[] x = new int[N];
		for (int i = 0; i < N; i++) {
			x[i] = Integer.parseInt(in.readLine());
		}
		
		Arrays.sort(x);
		
		int start = 1, end = x[N-1] - x[0];
	    int maxLen = 0;
	    
	    while (start <= end) {
	        int mid = (start + end)/2;
	        
	        int cnt = 1, prev = x[0];
	        for (int i = 1; i < N; i++) {
	            if (x[i] - prev >= mid) {
	                cnt++;
	                prev = x[i];
	            }
	        }

	        if (cnt >= C) {
	            maxLen = Math.max(maxLen, mid);
	            start = mid+1;
	        }else {
	        	end = mid-1;
	        }
	    }
	    
	    System.out.println(maxLen);
	}
}

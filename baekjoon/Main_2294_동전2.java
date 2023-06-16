package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2294_동전2 {
	 public static void main(String[] args) throws Exception {
	        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	        StringTokenizer st = new StringTokenizer(in.readLine());
	        
	        int n = Integer.parseInt(st.nextToken());
	        int k = Integer.parseInt(st.nextToken());
	        
	        int[] dp = new int[k+1];
	        for (int i = 1; i <= k; i++) {
	            dp[i] = 100001;
	        }
	        
	        int[] coin = new int[n+1];
	        for (int i = 1; i <= n; i++) {
	        	coin[i] = Integer.parseInt(in.readLine());
	        	
	            for(int j = coin[i]; j <= k; j++) {
	                dp[j] = Math.min(dp[j], dp[j-coin[i]] + 1);
	            }
	        }
	        
	        System.out.println(dp[k] == 100001 ? -1 : dp[k]);
	    }
}

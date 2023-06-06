package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1562_계단수 {
	static int N;
	static int[][][] dp;
	static final int MOD = 1_000_000_000;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		dp = new int[10][N+1][1024];
		
		int ans = 0;
	    for(int i = 1; i < 10; i++){
	        ans = (ans + count(i, 1, 1<<i)) % MOD;
	    }
	    System.out.print(ans);
	}
	
	public static int count(int num, int digit, int bit){
	    if(dp[num][digit][bit] != 0) return dp[num][digit][bit];
	    
	    if(digit == N){
	        if(bit == 1023) return 1;
	        else return 0;
	    }
	    
	    if(num == 0) dp[num][digit][bit] += count(num+1, digit+1, (bit | 1<<(num+1)));
	    else if(num == 9) dp[num][digit][bit] += count(num-1, digit+1, (bit | 1<<(num-1)));
	    else dp[num][digit][bit] += (count(num+1, digit+1, (bit | 1<<(num+1))) + count(num-1, digit+1, (bit | 1<<(num-1))));

	    dp[num][digit][bit] %= MOD;
	    
	    return dp[num][digit][bit];
	}
}

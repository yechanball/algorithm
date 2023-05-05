package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1709_타일위의원 {
	public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        
        long N = Long.parseLong(in.readLine())/2;       
        long x = 0, y = N-1, R = N*N, cnt = 0;
    
	  	while (x <= N && y >= 0) {
	  		long d = dist(x+1, y);
	  		if(d <= R) x++;
	  		if(d >= R) y--;
	  		cnt++;
	  	}

        System.out.print(cnt*4);
	}
	
	public static long dist(long x, long y) {
		return x * x + y * y;
	}
}

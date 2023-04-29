package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16931_겉넓이구하기 {
    public static void main(String[] args) throws IOException {
    	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(in.readLine());
    	
    	int N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());
    	
    	int[][] map = new int[N][M];   	
    	for(int i = 0; i < N; i++) {
    		st = new StringTokenizer(in.readLine());
    		for(int j = 0; j < M; j++) {
    			map[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
    	
    	int surface = N*M*2;

    	for(int i = 0; i < N; i++) {
    		surface += map[i][0];
    		for(int j = 1; j < M; j++) {
    			int tmp = map[i][j] - map[i][j-1];
    			if(tmp > 0) surface += tmp;
    			else surface -= tmp;
    		}
    		surface += map[i][M-1];
    	}
    	
    	for(int i = 0; i < M; i++) {
    		surface += map[0][i];
    		for(int j = 1; j < N; j++) {	
    			int tmp = map[j][i] - map[j-1][i];
    			if(tmp > 0) surface += tmp;
    			else surface -= tmp;
    		}
    		surface += map[N-1][i];
    	}
    	
    	System.out.print(surface);
    }
}

package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_9063_대지 {
	public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int maxX = -10001, minX = 10001,
        	maxY = -10001, minY = 10001;
        
        int N = Integer.parseInt(in.readLine());
        for (int i = 0; i < N; i++) {
        	st = new StringTokenizer(in.readLine());
        	int x = Integer.parseInt(st.nextToken()),
        		y = Integer.parseInt(st.nextToken());
			
        	maxX = Math.max(maxX, x);
        	minX = Math.min(minX, x);
        	maxY = Math.max(maxY, y);
        	minY = Math.min(minY, y);
		}
        
        System.out.println((maxX - minX) * (maxY - minY));
	}
}

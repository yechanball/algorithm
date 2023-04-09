package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_27940_가지산사태 {
	static class Rain implements Comparable<Rain> {
        int t, r;

        public Rain(int t, int r) {
            this.t = t;
            this.r = r;
        }

        @Override
        public int compareTo(Rain rain) {
            return Integer.compare(this.t, rain.t);
        }
    }
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());;

        PriorityQueue<Rain> pq = new PriorityQueue<>();
        int maxRain = 0;
        for (int i = 1; i <= M; i++) {
        	st = new StringTokenizer(in.readLine());
            int t = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            
            pq.add(new Rain(t, r));
            maxRain += r;
            
            if(maxRain > K) {
            	System.out.print(i + " " + pq.poll().t);
            	break;
            }
        }
        
        if(maxRain <= K) System.out.print(-1);
	}
}
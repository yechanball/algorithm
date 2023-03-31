package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main_1417_국회의원선거 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
        int dasom = Integer.parseInt(in.readLine());
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 1; i < N; i++) {
        	pq.add(Integer.parseInt(in.readLine()));			
		}
        
        int cnt = 0;
        while (!pq.isEmpty()) {
        	int num = pq.poll();

        	if(num < dasom) break;
  
    		cnt++;
    		dasom++;
    		pq.add(--num);
        }
        System.out.print(cnt);
	}
}

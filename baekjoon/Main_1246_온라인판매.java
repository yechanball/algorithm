package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1246_온라인판매 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		List<Integer> list = new ArrayList<>();
        for (int i = 0; i < M; i++) {
        	list.add(Integer.parseInt(in.readLine()));			
		}
        
        Collections.sort(list);
       
        int max = 0,  price = 0;
        for(int i = 0; i < M; i++) {
            int sum = 0;
            
            if (N > M - i) sum = list.get(i) * (M - i);
            else sum = list.get(i) * N;
            
            if(sum > max) {
                max = sum;
                price = list.get(i);
            }
        }
        
        System.out.print(price + " " + max);
    }
}

package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main_1448_삼각형만들기 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		
		List<Integer> straws = new ArrayList<>();
        for (int i = 0; i < N; i++) {
        	straws.add(Integer.parseInt(in.readLine()));			
		}
        
        Collections.sort(straws);
       
        int sum = 0;
        for (int i = N-1; i > 1; i--) {
        	if (straws.get(i) < straws.get(i-1) + straws.get(i-2)) {
        		sum = Math.max(sum, straws.get(i) + straws.get(i-1) + straws.get(i-2));
        	}
        }

        System.out.print(sum == 0 ? -1 : sum);
    }
}

package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1083_소트 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		List<Integer> list = new ArrayList<>();
		int N = Integer.parseInt(in.readLine());

        StringTokenizer st = new StringTokenizer(in.readLine());
        for (int i = 0; i < N; i++) {
        	list.add(Integer.parseInt(st.nextToken()));
		}
        
        int S = Integer.parseInt(in.readLine());
        for (int i = 0; i < N; i++) {
			int idx = 0;
			int max = 0;
			
			for (int j = i; j < N && j <= S+i; j++) {
				if(list.get(j) <= max)  continue;
				
				max = list.get(j);
				idx = j;
			}				
			
			list.remove(idx);
			list.add(i, max);
            
			S -= (idx - i);
			
			if(S == 0) break;
		}
        
		for (int num : list) sb.append(num).append(" ");

        out.write(sb.toString());
        out.flush();
        out.close();
	}
}

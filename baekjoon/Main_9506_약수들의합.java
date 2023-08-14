package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_9506_약수들의합 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			int n = Integer.parseInt(in.readLine());
			
			if(n == -1) break;
			
			sb.append(n + " = 1");
			
            int sum = 1;
            for (int i = 2; i < n; i++) {
                if(n%i == 0) {
                    sb.append(" + " + i);
                    sum += i;
                }
            }
            
            if(sum == n) out.write(sb.toString() + "\n");
            else out.write(n + " is NOT perfect.\n");
            
            sb = new StringBuilder();
		}
		out.flush();
		out.close();
	}
}

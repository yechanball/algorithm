package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_4948_베르트랑공준 {
	public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
        
		boolean[] prime = new boolean[246913];
		
		prime[0] = prime[1] = true;
		for (int i = 2; i * i <= 246913; i++) {
			if(prime[i]) continue;
			
			int num = i * i;
			while(num < 246913) {
				prime[num] = true;
				num += i;
			}
		}
		
		while (true) {
			int n = Integer.parseInt(in.readLine());
			if (n == 0) break;
            
			int cnt = 0;
			for (int i = n + 1; i <= 2 * n; i++) {
				if (!prime[i]) cnt++;
			}
			sb.append(cnt).append('\n');
		}
		
		out.write(sb.toString());
		out.flush();
		out.close();
	}
}

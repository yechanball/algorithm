package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_17103_골드바흐파티션 {
	public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
        
		boolean[] prime = new boolean[1000001];
		prime[0] = prime[1] = true;
		for (int i = 2; i * i <= 1000000; i++) {
			if(prime[i]) continue;
			
			int num = i * i;
			while(num <= 1000000) {
				prime[num] = true;
				num += i;
			}
		}
		
		int T = Integer.parseInt(in.readLine());
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(in.readLine());
            
			int cnt = 0;
            for (int i = 2; i <= N / 2; i++) {
                if (!prime[i] && !prime[N - i]) cnt++;
            }
			sb.append(cnt).append('\n');
		}
		
		out.write(sb.toString());
		out.flush();
		out.close();
	}
}

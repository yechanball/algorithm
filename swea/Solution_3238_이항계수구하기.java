package algorithm.swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_3238_이항계수구하기 {
	static int P; 
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(in.readLine(), " ");
			long N = Long.parseLong(st.nextToken());
			long R = Long.parseLong(st.nextToken());
			int P = Integer.parseInt(st.nextToken());
			
			long[] fact = new long[P+1];
			fact[0] = 1;
			for (int i = 1; i <= P; i++) {
				fact[i] = i * fact[i-1] % P;
			}
			
			long answer = 1;
	        while (R > 0 || N > 0){
	            int X = (int) (N % P); 
	            int Y = (int) (R % P);

	            if (Y > X){
	                answer = 0;
	                break;
	            }

	            answer = answer * fact[X] % P;
	            for (int i = 0; i < P - 2; i++){
	                answer = answer * fact[X - Y] * fact[Y] % P;
	            }
	            N /= P; 
	            R /= P;
	        }
	        answer %= P;
			
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		out.write(sb.toString());
		out.flush();
		out.close();
	}
}

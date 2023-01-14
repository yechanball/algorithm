package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_27161_크레이지타임 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(in.readLine());
		
		boolean timeFlow = true;
		int time = 1;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			String S = st.nextToken();
			int X = Integer.parseInt(st.nextToken());
			
			if(S.equals("HOURGLASS") && time == X) {
				sb.append(time + " NO\n");
			}else if(S.equals("HOURGLASS")) {
				sb.append(time + " NO\n");
				timeFlow = (timeFlow) ? false : true;
			}else if(time == X) {
				sb.append(time + " YES\n");				
			}else {
				sb.append(time + " NO\n");
			}
			
			if(timeFlow) time = (++time > 12) ? 1 : time;
			else time = (--time < 1) ? 12 : time;
		}
		
		out.write(sb.toString());
		out.flush();
		out.close();
	}
}

package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_1004_어린왕자 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			int cnt = 0;
			int n = Integer.parseInt(in.readLine());
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(in.readLine());
				
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				
				boolean hasStart = (Math.sqrt((x1 - x) * (x1 - x) + (y1 - y) * (y1 - y)) < r);
				boolean hasEnd = (Math.sqrt((x2 - x) * (x2 - x) + (y2 - y) * (y2 - y)) < r);
				
				if((hasStart && !hasEnd) || (!hasStart && hasEnd)) cnt++;
			}
			
			sb.append(cnt + "\n");
		}
		
		out.write(sb.toString());
		out.flush();
		out.close();
	}
}

package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1966_프린터큐 {
	static class Doc {
		int priority;
		int order;
		
		public Doc(int priority, int order) {
			super();
			this.priority = priority;
			this.order = order;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine());
		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			List<Doc> list = new ArrayList<Doc>();
			st = new StringTokenizer(in.readLine());
			for (int i = 0; i < N; i++) {
				list.add(new Doc(Integer.parseInt(st.nextToken()), i));
			}
			
			int cnt = 0;
			boolean isFind = false;
			while(!isFind) {
				Doc maxDoc = list.get(0);
				int maxIdx = 0;
				for (int i = 0, size = list.size(); i < size; i++) {
					if(list.get(i).priority > maxDoc.priority) {
						maxDoc = list.get(i);
						maxIdx = i;
					}
				}
				
				for (int i = 0; i < maxIdx; i++) {
					Doc tmp = list.get(0);
					list.remove(0);
					list.add(tmp);
				}
				
				maxDoc = list.get(0);
				list.remove(0);
				cnt++;
				
				if(maxDoc.order == M) isFind = true;
			}
			
			sb.append(cnt + "\n");
		}
		
		out.write(sb.toString());
		out.flush();
		out.close();
	}
}

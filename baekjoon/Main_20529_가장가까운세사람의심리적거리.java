package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_20529_가장가까운세사람의심리적거리 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine());
		for (int tc = 0; tc < T; tc++) {
			List<String> mbti = new ArrayList<String>();
			
			int N = Integer.parseInt(in.readLine());
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int i = 0; i < N; i++) {
				mbti.add(st.nextToken());
			}
			
			if(N >= 33) sb.append("0\n");
			else {
				int minDist = Integer.MAX_VALUE;
				for (int i = 0; i < N && minDist != 0; i++) {
					for (int j = i+1; j < N && minDist != 0; j++) {
						for (int k = j+1; k < N && minDist != 0; k++) {
							int dist = distance(mbti.get(i), mbti.get(j)) + distance(mbti.get(j), mbti.get(k)) + distance(mbti.get(k), mbti.get(i));
							minDist = Math.min(minDist, dist);
						}
					}
				}
				sb.append(minDist + "\n");				
			}
		}
		out.write(sb.toString());
		out.flush();
		out.close();
	}

	public static int distance(String mbti1, String mbti2) {
		int dist = 0;
		
		for (int i = 0; i < 4; i++) {
			if(mbti1.charAt(i) == mbti2.charAt(i)) continue;
			dist++;
		}
		
		return dist;
	}
	
	
}

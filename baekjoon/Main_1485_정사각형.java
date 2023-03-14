package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_1485_정사각형 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine());
		for (int tc = 0; tc < T; tc++) {
			int[] X = new int[4];
			int[] Y = new int[4];
			int[] dist = new int[4];
			
			for (int i = 0; i < 4; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				X[i] = Integer.parseInt(st.nextToken());
				Y[i] = Integer.parseInt(st.nextToken());
			}
			
			int maxLen = 0;
			int crossPos = 0;
			for (int i = 1; i < 4; i++) {
				dist[i] = (X[0]-X[i])*(X[0]-X[i]) + (Y[0]-Y[i])*(Y[0]-Y[i]);
				if(dist[i] > maxLen) {
					maxLen = dist[i];
					crossPos = i;
				}
			}
			
			boolean isSquare = false;
			int nearPos1 = (crossPos+1 > 3) ? (crossPos+1) % 3 : crossPos+1;
			int nearPos2 = (crossPos+2 > 3) ? (crossPos+2) % 3 : crossPos+2;
			
			if(dist[nearPos1]+dist[nearPos2] == dist[crossPos] && (Y[nearPos1]-Y[nearPos2])*(Y[0]-Y[crossPos]) == -1*(X[nearPos1]-X[nearPos2])*(X[0]-X[crossPos]) ) {
				isSquare = true;
			}
			
			sb.append(isSquare ? "1\n" : "0\n");		
		}
		out.write(sb.toString());
		out.flush();
		out.close();
	}
}

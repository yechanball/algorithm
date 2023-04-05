package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_3034_앵그리창영 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		
		int diagonal = W * W + H * H;
		for (int i = 0; i < N; i++) {
			int len = Integer.parseInt(in.readLine());
			if(len * len <= diagonal) sb.append("DA\n");
			else sb.append("NE\n");
		}
		
		out.write(sb.toString());
		out.flush();
		out.close();
	}
}

package algorithm.swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_3307_최장증가부분수열 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(in.readLine());
			int[] arr = new int[N];
			int[] LIS = new int[N];
			
			st = new StringTokenizer(in.readLine(), " ");
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			int max = 0;
			for (int i = 0; i < N; i++) {
				LIS[i] = 1;
				for (int j = 0; j < i; j++) {
					if(arr[j] < arr[i] && LIS[i] < LIS[j]+1) {
						LIS[i] = LIS[j]+1;
					}
				}
				max = Math.max(max, LIS[i]);
			}
			sb.append("#").append(tc).append(" ").append(max).append("\n");
		}
		out.write(sb.toString());
		out.flush();
		out.close();
	}
}

package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_3061_사다리 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(in.readLine());
			int[] arr = new int[N];
			
			st = new StringTokenizer(in.readLine(), " ");
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			// 사다리를 그리는데 필요한 가로줄 개수의 최솟값 = 버블정렬의 swap 횟수
			int tmp, cnt = 0;
			for (int i = N-1; i > 0; i--) {
				for (int j = 0; j < i; j++) {
					if (arr[j] > arr[j+1]) {
						cnt++; // swap이 발생할 때마다 카운트
						tmp = arr[j];
						arr[j] = arr[j+1];
						arr[j+1] = tmp;
					}
				}
			}
			sb.append(cnt).append("\n");
		}
		out.write(sb.toString());
		out.flush();
		out.close();
	}
}

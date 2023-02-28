package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1449_수리공항승 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken()), L = Integer.parseInt(st.nextToken());
		int[] point = new int [N];
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			point[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(point);
		int pre = point[0], cnt = 1;
		for (int i = 1; i < N; i++) {
			if(point[i]-pre > L-1) {
				cnt++;
				pre = point[i];
			}
		}
		System.out.print(cnt);
	}
}

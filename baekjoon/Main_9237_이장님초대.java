package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_9237_이장님초대 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine()), day = 0;
		Integer[] t = new Integer[N];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			t[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(t, Comparator.reverseOrder());
		for (int i = 0; i < N; i++) {
			day = Math.max(day, t[i] + i + 2);
		}
		System.out.print(day);
	}
}

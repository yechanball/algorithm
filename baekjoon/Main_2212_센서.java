package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2212_센서 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int K = Integer.parseInt(in.readLine());
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		int[] sensor = new int[N];
		for (int i = 0; i < N; i++) {
			sensor[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(sensor);
		
		int[] diff = new int[N-1];
		for (int i = 0; i < N-1; i++) {
			diff[i] = sensor[i+1] - sensor[i];
		}
		
		Arrays.sort(diff);
		
		int sum = 0;
		for (int i = 0; i < N-K; i++) {
			sum += diff[i];
		}
		System.out.print(sum);
	}
}

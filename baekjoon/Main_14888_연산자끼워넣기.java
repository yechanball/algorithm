package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14888_연산자끼워넣기 {
	static int N;
	static int[] A;
	static int[] op = new int[4];
	static int min = 1000000001;
	static int max = -1000000001;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		
		A = new int[N];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < 4; i++) {
			op[i] = Integer.parseInt(st.nextToken());
		}
		
		findAns(A[0], 1);
		
		System.out.println(max + "\n" + min);
	}

	public static void findAns(int result, int idx) {
		if(idx == N) {
			min = Math.min(min, result);
			max = Math.max(max, result);
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			if(op[i] > 0) {
				op[i]--;
				if(i == 0) findAns(result + A[idx], idx+1);
				else if(i == 1) findAns(result - A[idx], idx+1);
				else if(i == 2) findAns(result * A[idx], idx+1);
				else findAns(result / A[idx], idx+1);
				op[i]++;
			}
		}
		
		return;
	}
}

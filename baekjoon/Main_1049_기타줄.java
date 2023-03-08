package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1049_기타줄 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int minPackage = 1001, minSingle = 1001;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			minPackage = Math.min(minPackage, Integer.parseInt(st.nextToken()));
			minSingle = Math.min(minSingle, Integer.parseInt(st.nextToken()));
		}
		
		System.out.print(Math.min(Math.min(minPackage * (N/6+1), minSingle*N), minPackage*(N/6) + minSingle*(N%6)));
	}
}

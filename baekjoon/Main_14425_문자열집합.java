package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main_14425_문자열집합 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashSet<String> set = new HashSet<>();
		for (int i = 0; i < N; i++) {
			set.add(in.readLine());
		}
		
		int cnt = 0;
		for (int i = 0; i < M; i++) {
			if(set.contains(in.readLine())) cnt++;
		}
		
		System.out.println(cnt);
	}
}

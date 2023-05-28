package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10807_개수세기 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int V = Integer.parseInt(in.readLine());
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			if(Integer.parseInt(st.nextToken()) == V) cnt++;
		}
		
		System.out.print(cnt);
	}
}

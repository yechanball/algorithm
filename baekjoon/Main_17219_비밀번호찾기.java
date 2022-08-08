package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_17219_비밀번호찾기 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashMap<String,String> sitePass = new HashMap<String,String>();
		for (int i = 0; i < N; i++) { // 입력
			st = new StringTokenizer(in.readLine(), " ");
			sitePass.put(st.nextToken(), st.nextToken());
		}
		
		for (int i = 0; i < M; i++) { // 찾기
			sb.append(sitePass.get(in.readLine())).append("\n");
		}
		System.out.print(sb);
	}
}

package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_14426_접두사찾기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < N; i++) {
			list.add(in.readLine());
		}
		
		int cnt = 0;
		for (int i = 0; i < M; i++) {
			String input = in.readLine();
			
			for(String str : list) {
				if(input.equals(str.substring(0, input.length()))) {
					cnt++;
					break;
				}
			}
		}
		
		System.out.print(cnt);
	}
}

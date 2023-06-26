package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main_10815_숫자카드 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		HashSet<Integer> set = new HashSet<>();
		int N = Integer.parseInt(in.readLine());
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			set.add(Integer.parseInt(st.nextToken()));
		}
		
		int M = Integer.parseInt(in.readLine());
		
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < M; i++) {
			if(set.contains(Integer.parseInt(st.nextToken()))) out.write("1 ");
			else out.write("0 ");
		}
		
		out.flush();
		out.close();
	}
}

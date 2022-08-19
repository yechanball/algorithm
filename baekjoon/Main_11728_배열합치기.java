package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main_11728_배열합치기 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		List<Integer> list = new ArrayList<Integer>();
		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < N; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < M; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		
		Collections.sort(list, new Comparator<Integer>() {
			@Override
			public int compare(Integer n1, Integer n2) {
				return n1 - n2;
			}
		});
		
		for(int num : list) {
			sb.append(num).append(" ");
		}
		out.write(sb.toString());
		out.flush();
		out.close();
	}
}

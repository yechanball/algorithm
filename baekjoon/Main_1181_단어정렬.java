package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1181_단어정렬 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(in.readLine());
		Set<String> input = new HashSet<String>();
		for (int i = 0; i < N; i++) {
			input.add(in.readLine());
		}
		List<String> list = new ArrayList<String>(input);
		Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				if(s1.length() == s2.length()) return s1.compareTo(s2);
				return s1.length()-s2.length();
			}
		});
		for(String str : list)
			sb.append(str).append("\n");
		System.out.print(sb);
	}
}

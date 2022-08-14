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

public class Main_1427_소트인사이드 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		String input = in.readLine();
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < input.length(); i++) {
			list.add(input.charAt(i)-'0'); // 각 자리수 입력
		}
		Collections.sort(list, new Comparator<Integer>() {
			@Override
			public int compare(Integer n1, Integer n2) { // 내림차순 정렬
				return n2 - n1;
			}
		});
		for (int num : list) {
			sb.append(num);
		}
		out.write(sb.toString());
		out.flush();
		out.close();
	}
}

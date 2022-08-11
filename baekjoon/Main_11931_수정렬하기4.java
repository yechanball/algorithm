package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main_11931_수정렬하기4 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(in.readLine());
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			list.add(Integer.parseInt(in.readLine()));
		}
		Collections.sort(list, new Comparator<Integer>() {
			@Override
			public int compare(Integer n1, Integer n2) {
				return n2 - n1; // 내림차순 정렬
			}
		});
		for(int num : list)
			sb.append(num).append("\n");
		System.out.print(sb);
	}
}

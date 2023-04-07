package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main_1758_알바생강호 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < N; i++) {
			list.add(Integer.parseInt(in.readLine()));
		}
		
		Collections.sort(list, new Comparator<Integer>() {
			@Override
			public int compare(Integer n1, Integer n2) {
				return n2 - n1;
			}
		});
		
		long tip = 0;
		for (int i = 0; i < N; i++) {
			if(list.get(i) - i <= 0) break;
			tip += list.get(i) - i;
		}
		
		System.out.print(tip);
	}
}

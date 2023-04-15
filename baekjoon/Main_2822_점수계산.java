package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main_2822_점수계산 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<int[]> list = new ArrayList<>();
		for (int i = 1; i <= 8; i++) {
			list.add(new int[] {i, Integer.parseInt(in.readLine())});
		}
		
		Collections.sort(list, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o2[1] > o1[1] ? 1 : -1;
			}
		});
		
		int total = 0;
		boolean[] isContain = new boolean[9];
		for(int i = 0; i < 5; i++) {
			isContain[list.get(i)[0]] = true;
			total += list.get(i)[1];
		}
		
		System.out.println(total);
		for(int i = 1; i <= 8; i++) {
			if(isContain[i]) System.out.print(i + " ");
		}		
	}

}

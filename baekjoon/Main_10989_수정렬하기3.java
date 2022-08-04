package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_10989_수정렬하기3 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(in.readLine());
		ArrayList<Integer> list = new ArrayList<>();
		int num, len=0;
		boolean isAdd;
		
		list.add(Integer.parseInt(in.readLine()));
		for (int i = 1; i < N; i++) {
			num = Integer.parseInt(in.readLine());
			isAdd = false;
			len = i;
			for (int j = 0; j < i; j++) {
				if(num <= list.get(j)) {
					list.add(j, num);
					isAdd = true;
					break;
				}
			}
			if(!isAdd) {
				list.add(num);
			}
		}
		for (int i = 0; i < N; i++) {
			sb.append(list.get(i)).append("\n");
		}
		System.out.print(sb);
	}
}

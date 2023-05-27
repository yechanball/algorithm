package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main_28062_준석이의사탕사기 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine()), maxCandy = 0;

		List<Integer> odd = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++){
			int candy = Integer.parseInt(st.nextToken());
			if(candy%2 == 0) maxCandy += candy;
			else odd.add(candy);
		}

		odd.sort(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});

		int tmpCandy = 0;
		for (int i = 0, size = odd.size(); i < size; i++) {
			tmpCandy += odd.get(i);
			if(i%2 == 1){
				maxCandy += tmpCandy;
				tmpCandy = 0;
			}
		}

		System.out.print(maxCandy);
	}
}

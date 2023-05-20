package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main_6068_시간관리하기 {
	static class Work {
		int T, S;

		public Work(int T, int S){
			this.T = T;
			this.S = S;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());

		List<Work> list = new ArrayList<>();
		for(int i = 0; i < N; i++){
			StringTokenizer st = new StringTokenizer(in.readLine());
			list.add(new Work(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}

		Collections.sort(list, new Comparator<Work>() {
			@Override
			public int compare(Work w1, Work w2) {
				return (w1.S == w2.S) ? w1.T - w2.T : w1.S - w2.S;
			}
		});

		int time = Integer.MAX_VALUE;
		for(int i = N-1; i >= 0; i--){
			time = Math.min(time, list.get(i).S);
			time -= list.get(i).T;
		}

		System.out.print(time < 0 ? -1 : time);
	}
}

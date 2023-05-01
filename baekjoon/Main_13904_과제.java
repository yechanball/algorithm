package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_13904_과제 {
	static class Homework {
		int d, w;

		public Homework(int d, int w) {
			this.d = d;
			this.w = w;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		
		Homework[] hw = new Homework[N];
		for (int i = 0; i < N; i++) {			
			StringTokenizer st = new StringTokenizer(in.readLine());
			hw[i] = new Homework(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(hw, new Comparator<Homework>() {
			@Override
			public int compare(Homework hw1, Homework hw2) {
				return hw1.w == hw2.w ? hw2.d - hw1.d : hw2.w - hw1.w;
			}
		});
		
		int score = 0;
		boolean[] checkDay = new boolean[1001];
		
		for(int i = 0; i < N; i++) {
			for(int j = hw[i].d; j > 0; j--) {
				if(checkDay[j]) continue;
				
				checkDay[j] = true;
				score += hw[i].w;
				break;
			}
		}
		
		System.out.print(score);
	}
}

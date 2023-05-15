package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_2109_순회강연 {
	static class Lecture {
		int p, d;

		public Lecture(int p, int d) {
			this.p = p;
			this.d = d;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int money = 0;

		if(N != 0) {			
			Lecture[] lecture = new Lecture[N];
			for (int i = 0; i < N; i++) {			
				StringTokenizer st = new StringTokenizer(in.readLine());
				lecture[i] = new Lecture(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			
			Arrays.sort(lecture, new Comparator<Lecture>() {
				@Override
				public int compare(Lecture lec1, Lecture lec2) {
					return lec1.p == lec2.p ? lec2.d - lec1.d : lec2.p - lec1.p;
				}
			});
			
			boolean[] checkDay = new boolean[10001];
			
			for(int i = 0; i < N; i++) {
				for(int j = lecture[i].d; j > 0; j--) {
					if(checkDay[j]) continue;
					
					checkDay[j] = true;
					money += lecture[i].p;
					break;
				}
			}
		}

		System.out.print(money);
	}
}

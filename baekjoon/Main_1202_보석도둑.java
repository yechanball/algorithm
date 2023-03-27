package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1202_보석도둑 {
	static class Jewel {
		int m;
		int v;

		public Jewel(int m, int v){
			this.m = m;
			this.v = v;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		Jewel[] jewel = new Jewel[N];
		for (int i = 0; i < N; i++){
			st = new StringTokenizer(in.readLine());		
			jewel[i] = new Jewel(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(jewel, new Comparator<Jewel>() {
			@Override
			public int compare(Jewel j1, Jewel j2) {
				return j1.m == j2.m ? j2.v - j1.v : j1.m - j2.m;
			}
		});

		int[] bag = new int[K];
		for (int i = 0; i < K; i++) {
			bag[i] = Integer.parseInt(in.readLine());
		}
		Arrays.sort(bag);

		PriorityQueue<Jewel> pq = new PriorityQueue<Jewel>(new Comparator<Jewel>() {
			@Override
			public int compare(Jewel j1, Jewel j2) {
				return j2.v - j1.v;
			}
		});
		
		long maxValue = 0;
		int bagNum = 0, jewelNum = 0;
		while(bagNum < K){
			while(jewelNum < N && jewel[jewelNum].m <= bag[bagNum]) {
				pq.offer(jewel[jewelNum++]);
			}
			
			if(!pq.isEmpty()) maxValue += pq.poll().v;

			bagNum++;
		}
		System.out.print(maxValue);
	}
}

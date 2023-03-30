package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_27514_1차원2048 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		
		Map<Long, Integer> map = new HashMap<Long, Integer>();
		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			long a = Long.parseLong(st.nextToken());
			if(map.containsKey(a)) map.put(a, map.get(a) + 1);
			else map.put(a, 1);
		}
		
		long key = 1, max = 0;
		for (int i = 0; i < 63; i++) {
			if(map.containsKey(key)) {
				if(map.get(key) >= 2) {
					if(map.containsKey(key*2)) map.put(key*2, map.get(key*2) + map.get(key)/2);
					else map.put(key*2, map.get(key)/2);					
				}
				max = key;
			}
			key *= 2;
		}

		System.out.print(max);
	}
}

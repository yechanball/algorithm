package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main_2108_통계학 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		int N = Integer.parseInt(in.readLine());
		for (int i = 0; i < N; i++) {
			int key = Integer.parseInt(in.readLine());
			
			if(map.containsKey(key)) map.put(key, map.get(key) + 1);
			else map.put(key, 1);
		}
		
		List<int[]> list = new ArrayList<>();
		int sum = 0;
		for(int key : map.keySet()) {
			list.add(new int[] {key, map.get(key)});
			sum += (key * map.get(key));
		}
		list.sort((n1, n2) -> n1[0] - n2[0]);
		
		int min = list.get(0)[0];
		int max = list.get(list.size()-1)[0];
		
		int mid = 0, idx = N/2+1, cnt = 0;		
		for (int[] num : list) {
			cnt += num[1];
			if(cnt >= idx) {
				mid = num[0];
				break;
			}
		}
		
		int most = 0;
		list.sort((n1, n2) -> (n2[1] == n1[1]) ? (n1[0] - n2[0]) : (n2[1] - n1[1]));
		if(list.size() > 1 && list.get(0)[1] == list.get(1)[1]) {
			most = list.get(1)[0];
		}else {
			most = list.get(0)[0];
		}

		System.out.print(Math.round((double)sum/(double)N) + "\n" + mid + "\n" + most + "\n" + (max-min));
	}
}

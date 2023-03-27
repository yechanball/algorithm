package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_26069_붙임성좋은총총이 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		map.put("ChongChong", true);
		int answer = 1;
		int N = Integer.parseInt(in.readLine());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			String person1 = st.nextToken();
			String person2 = st.nextToken();
			
			if(!map.containsKey(person1)) map.put(person1, false);
			if(!map.containsKey(person2)) map.put(person2, false);
			
			if(map.get(person1)) {
				if(map.get(person2)) continue;
				else {
					map.put(person2, true);
					answer++;
				}
			}else {
				if(map.get(person2)) {
					map.put(person1, true);
					answer++;					
				}else continue;
			}
		}
		System.out.print(answer);
	}
}

package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_26123_외계침략자윤이 {	
	static class Building implements Comparable<Building>{
		int height;
		long cnt;	
		public Building(int height, long cnt) {
			this.height = height;
			this.cnt = cnt;
		}
		@Override
		public int compareTo(Building b) {
			return (this.height < b.height) ? 1 : -1;
		}
	}
	
	public static void main(String[] args) throws IOException  {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		st = new StringTokenizer(in.readLine(), " ");
		while(st.hasMoreTokens()) {
			int h = Integer.parseInt(st.nextToken());
			if(h == 0) continue;
			if(map.containsKey(h)) {
				map.put(h, map.get(h) + 1);
			}else{
				map.put(h, 1);
			}
		}
		
		long cnt = 0;
		if(!map.isEmpty()) {
			PriorityQueue<Building> pQ = new PriorityQueue<>();
			for(int key : map.keySet()) {
				pQ.add(new Building(key, map.get(key)));
			}
			
			Building now = pQ.poll();
			for (int i = 0; i < D; i++) {
				cnt += now.cnt;
				now.height--;
				if(now.height == 0) break;
				if(!pQ.isEmpty() && pQ.peek().height == now.height) {
					Building top = pQ.poll();
					now.cnt += top.cnt;
				}
			}			
		}
		System.out.print(cnt);
	}
}

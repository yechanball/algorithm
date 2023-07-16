package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_4195_친구네트워크 {
	static int[] parents;
	static int[] netCnt;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(in.readLine());
		for (int t = 0; t < T; t++) {
			int N = 0;
			int F = Integer.parseInt(in.readLine());
			
			make(F*2);
			
			HashMap<String, Integer> friend = new HashMap<>();
			for (int i = 0; i < F; i++) {
				st = new StringTokenizer(in.readLine());
				String name1 = st.nextToken();
				String name2 = st.nextToken();

				if(!friend.containsKey(name1)) friend.put(name1, N++);
				if(!friend.containsKey(name2)) friend.put(name2, N++);
		
				out.write(union(friend.get(name1), friend.get(name2)) + "\n");
			}
		}
		out.flush();
		out.close();
	}
	
	static void make(int n) {
		parents = new int[n];
		netCnt = new int[n];
		
		for (int i = 0; i < n; i++) {
			parents[i] = i;
			netCnt[i] = 1;
		}
	}
	
	static int find(int a) {
		if(parents[a] == a) return a;
		
		return parents[a] = find(parents[a]);
	}
	
	static int union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot != bRoot) {
			parents[bRoot] = aRoot;
			netCnt[aRoot] += netCnt[bRoot];
			netCnt[bRoot] = 1;			
		}
		
		return netCnt[aRoot];
	}
}

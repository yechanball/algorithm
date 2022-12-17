package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_16198_에너지모으기 {	
	static List<Integer> W = new ArrayList<Integer>();
	static int maxEnergy = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			W.add(Integer.parseInt(st.nextToken()));
		}
		
		dfs(N, 0);
		
		System.out.print(maxEnergy);
	}

	private static void dfs(int N, int energy) {
		if(N == 2) {
			maxEnergy = Math.max(maxEnergy, energy);
			return;
		}
		
		for (int i = 1; i < N-1; i++) {
			int e = W.get(i);
			W.remove(i);
			dfs(N-1, energy + W.get(i-1) * W.get(i));
			W.add(i, e);
		}
	}
}

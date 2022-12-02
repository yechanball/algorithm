package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_1208_부분수열의합2 {
	static int N, S, cnt = 0;
	static int[] arr;
	static Map<Integer, Long> leftMap = new HashMap<Integer, Long>();
	static Map<Integer, Long> rightMap = new HashMap<Integer, Long>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(in.readLine(), " ");
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		leftSubSum(0, N/2, 0, 0);
		rightSubSum(N/2, N, 0, 0);

		if(leftMap.get(S) == null) leftMap.put(S, (long)0);
		if(rightMap.get(S) == null) rightMap.put(S, (long)0);

		System.out.print(leftMap.get(S) + rightMap.get(S));
	}
	
	public static void leftSubSum(int start, int end, int sum, int cnt) {
		if(start == end) {
			if(cnt == 0) return;
			
			if(leftMap.containsKey(sum)) leftMap.put(sum, leftMap.get(sum) + (long)1);
			else leftMap.put(sum, (long)1);
			return;
		}		
		leftSubSum(start + 1, end, sum, cnt);
		leftSubSum(start + 1, end, sum + arr[start], cnt+1);
	}
	
	public static void rightSubSum(int start, int end, int sum, int cnt) {
		if(start == end) {
			if(cnt == 0) return;

			if(leftMap.containsKey(S-sum)) {
				if(rightMap.containsKey(S)) rightMap.put(S, rightMap.get(S) + leftMap.get(S-sum));
				else rightMap.put(S, leftMap.get(S-sum));
			}

			if(rightMap.containsKey(sum)) rightMap.put(sum, rightMap.get(sum) + (long)1);
			else rightMap.put(sum, (long)1);
			return;
		}
		rightSubSum(start + 1, end, sum, cnt);
		rightSubSum(start + 1, end, sum + arr[start], cnt+1);
	}
}

package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1450_냅색문제 {
	static int N, C;
	static int[] W;
	static List<Integer> left, right;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		W = new int[N];
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			W[i] = Integer.parseInt(st.nextToken());
		}
		
		left = new ArrayList<>();
		right = new ArrayList<>();
		
		comb(left, 0, N/2, 0);
		comb(right, N/2, N, 0);
		Collections.sort(right);
		
		int cnt = 0;
		for (int i = 0; i < left.size(); i++) {
			cnt += upperbound(0, right.size()-1, left.get(i));
		}
		System.out.println(cnt);
	}
	
	public static int upperbound(int start, int end, int weight) {
		while(start <= end) {
			int mid = (start + end)/2;
			
			if(right.get(mid) <= C-weight) {
				start = mid+1;
			}else {
				end = mid-1;
			}
		}
		return end+1;
	}
	
	public static void comb(List<Integer> list, int start, int end, int sum) {
		if(sum > C) return;
		
		if(start == end) {
			list.add(sum);
			return;
		}
		
		comb(list, start+1, end, sum);
		comb(list, start+1, end, sum + W[start]);
	}
}

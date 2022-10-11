package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_14002_가장긴증가하는부분수열4 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[] arr = new int[N];
		int[] C = new int[N];
		List<int[]> change = new ArrayList<int[]>();
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int size = 0;
		
		for (int i = 0; i < N; i++) {
			int pos = Arrays.binarySearch(C, 0, size, arr[i]);
			
			if(pos >= 0) continue;
			
			int insertPos = Math.abs(pos)-1;
			C[insertPos] = arr[i];
			
			change.add(new int[] {insertPos, arr[i]});
			
			if(insertPos == size) size++;
		}

		int[] result = new int[size];
		int idx = size - 1;
		int len = change.size() - 1;
		for (int i = len; i >= 0; i--) {
			if(change.get(i)[0] == idx && result[idx] == 0)
				result[idx--] = change.get(i)[1];
		}
		
		System.out.println(size);
		for (int i = 0; i < size; i++) {
			System.out.print(result[i] +" ");
		}
	}
}

package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_12015_가장긴증가하는부분수열2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[] arr = new int[N];
		int[] C = new int[N]; // C[k] : k 길이를 만족하는 자리에 오는 수의 최솟값 저장
		
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
			
			if(insertPos == size) size++;
		}
				
		System.out.print(size);
	}
}

package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2477_참외밭 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int[][] arr = new int[8][2];
		int K = Integer.parseInt(in.readLine());
		for (int i = 1; i <= 6; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		arr[0] = arr[6];
		arr[7] = arr[1];
		
		int maxH = 0, minH = 500, maxW = 0, minW = 500;
		for (int i = 1; i <= 6; i++) {
			if(arr[i-1][0] == arr[i+1][0]) {
				if(arr[i][0] <= 2) minW = Math.min(minW, arr[i][1]);
				else minH = Math.min(minH, arr[i][1]);							
			}else {
				if(arr[i][0] <= 2) maxW = Math.max(maxW, arr[i][1]);
				else maxH = Math.max(maxH, arr[i][1]);								
			}
		}
		System.out.print((maxW*maxH - minW*minH) * K);
	}
}

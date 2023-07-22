package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_6549_히스토그램에서가장큰직사각형 {
	static int n;
	static long[] h;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		while(true) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int n = Integer.parseInt(st.nextToken());
			
			if(n == 0) break;
			
			h = new long[n];
			for (int i = 0; i < n; i++) {
				h[i] = Long.parseLong(st.nextToken());
			}
			
			out.write(findMaxArea(0, n-1) + "\n");
		}
		out.flush();
		out.close();
	}

	public static long getArea(int left, int right, long height) {
		return height * (right - left + 1);
	}
	
	public static long findMaxArea(int left, int right) {
		if(left == right) return h[left];

		int mid = (left + right)/2;

		long leftMaxArea = findMaxArea(left, mid);
		long rightMaxArea = findMaxArea(mid + 1, right);
		long midMaxArea = findMidMaxArea(left, mid, right);

		return Math.max(Math.max(leftMaxArea, rightMaxArea), midMaxArea);
	}

	public static long findMidMaxArea(int left, int mid, int right) {
		long height = h[mid], maxArea = height;
		int L = mid, R = mid;

		while(L > left && R < right) {
			if(h[L-1] < h[R+1]) height = Math.min(height, h[++R]);		
			else height = Math.min(height, h[--L]);
	 
			maxArea = Math.max(maxArea, getArea(L, R, height)); 
		}

		while(L > left) {
			height = Math.min(height, h[--L]);
			maxArea = Math.max(maxArea, getArea(L, R, height)); 
		}

		while(R < right) {
			height = Math.min(height, h[++R]);
			maxArea = Math.max(maxArea, getArea(L, R, height)); 
		}

		return maxArea;
	}
}

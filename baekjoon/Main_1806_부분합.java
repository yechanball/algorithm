package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_1806_부분합 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int left = 0;
		int right = 0;
		int len = 1;
		int minLen = Integer.MAX_VALUE;
		int sum = 0;
		
		while(true) {
			if(sum >= S) {
				sum -= arr[left++];
				len--;
				minLen = (len < minLen) ? len : minLen;
			}else if(right == N){
				break;
			}else {
				sum += arr[right++];
				len++;
			}
		}
		
		if(minLen == Integer.MAX_VALUE) {
			out.write("0");
		}else {
			out.write(Integer.toString(minLen));
		}
		out.flush();
		out.close();
	}
}

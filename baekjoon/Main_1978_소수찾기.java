package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1978_소수찾기 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[] arr = new int[N];
		int check, answer = 0;
		
		String str = in.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for(int num : arr) {
			if(num != 1) {
				check = 0;
				for(int i = 2; i < num; i++) {
					if(num%i == 0) {
						check++;
						break;
					}
				}
				if(check == 0) {
					answer++;
				}
			}
		}
		System.out.println(answer);
	}
}

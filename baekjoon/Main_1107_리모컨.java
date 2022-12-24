package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1107_리모컨 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(in.readLine());
		int M = Integer.parseInt(in.readLine());

		List<Integer> list = new ArrayList<Integer>();
		if(M != 0) {
			st = new StringTokenizer(in.readLine());
			for (int i = 0; i < M; i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}			
		}
		
		int min = Math.abs(N-100); // +, - 버튼으로 이동시 누른 횟수
		for (int num = 0; num <= 1_000_000; num++) {
			String str = Integer.toString(num);
			boolean isPoss = true;
			
			for (int btnNum : list) { 
				if(str.contains(Integer.toString(btnNum))){
					isPoss = false;
					break;
				}
			}
			
			if(isPoss) {
				min = Math.min(min, str.length() + Math.abs(N - num));
			}
		}
		
		System.out.print(min);
	}
}

package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2635_수이어가기 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb;

		int N = Integer.parseInt(in.readLine());
		int maxCnt = 0;
		String maxNumList = "";
		
		for (int i = N; i >= N/2; i--) {
			sb = new StringBuilder();
			int pre = N, num = i, cnt = 0;
			
			while(num >= 0) {
				sb.append(pre + " ");
				
				int diff = pre - num;
				pre = num;
				num = diff;
				
				cnt++;
			}
			sb.append(pre);
			cnt++;
			
			if(cnt > maxCnt) {
				maxCnt = cnt;
				maxNumList = sb.toString();
			}
		}
		
		System.out.println(maxCnt);
		System.out.println(maxNumList);
	}
}

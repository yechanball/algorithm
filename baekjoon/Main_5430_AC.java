package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_5430_AC {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine());		
		for (int testcase = 1; testcase <= T; testcase++) {
			String p = in.readLine();
			int n = Integer.parseInt(in.readLine());
			int[] arr = new int[n];
			String str = in.readLine();
			StringTokenizer st = new StringTokenizer(str.subSequence(1, str.length()-1).toString(), ",");
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			boolean isError = false;
			boolean isReverse = false;
			int start = 0;
			int end = n-1;
			int size = n;
			for (int i = 0; i < p.length(); i++) {
				if(p.charAt(i) == 'D') {
					if(size == 0) {
						isError = true;
						break;
					}else if(isReverse){
						end--;
						size--;
					}else {
						start++;						
						size--;
					}
				}else {
					isReverse = (isReverse == false) ? true : false;
				}
			}
			
			if(isError) {
				sb.append("error").append("\n");
			}else {
				sb.append("[");
				if(size == 0) {	
				}else if(isReverse) {
					for (int i = end; i >= start; i--) {
						sb.append(arr[i]).append(",");
					}
					sb.deleteCharAt(sb.length()-1);
				}else {
					for (int i = start; i <= end; i++) {
						sb.append(arr[i]).append(",");
					}
					sb.deleteCharAt(sb.length()-1);
				}
				sb.append("]").append("\n");
			}
		}
		System.out.print(sb);
	}
}

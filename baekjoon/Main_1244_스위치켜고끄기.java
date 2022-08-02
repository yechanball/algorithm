package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1244_스위치켜고끄기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(in.readLine());
		int[] arr = new int[N]; 
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int T = Integer.parseInt(in.readLine());
		int student, num, cnt;
		
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			student = Integer.parseInt(st.nextToken());
			num = Integer.parseInt(st.nextToken());
			
			switch (student) {
			case 1:
				cnt = 1;
				while(num*cnt <= N) {
					arr[num*cnt-1] = (arr[num*cnt-1] == 0 ? 1 : 0);
					cnt++;
				}
				break;
				
			case 2:
				num--;
				cnt = 0;
				while(arr[num+cnt] == arr[num-cnt]) {
					arr[num+cnt] = (arr[num+cnt] == 0 ? 1 : 0); 
					arr[num-cnt] = arr[num+cnt];
					cnt++;
					if((num-cnt)<0 || (num+cnt)>=N) break;
				}
				break;

			default:
				break;
			}
		}
		
		for (int i = 1; i <= N; i++) {
			sb.append(arr[i-1]).append(" ");
			if(i%20 == 0) {
				sb.append("\n");
			}
		}
		System.out.print(sb);
	}
}

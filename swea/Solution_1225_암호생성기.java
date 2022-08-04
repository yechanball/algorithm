package algorithm.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_1225_암호생성기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		ArrayList<Integer> list = new ArrayList<>(); 
		int testcase, cycle, num;
		
		for(int tc = 1; tc <= 10; tc++) {
			testcase = Integer.parseInt(in.readLine());
			sb.append("#").append(testcase).append(" ");
			st = new StringTokenizer(in.readLine(), " ");
			for (int i = 0; i < 8; i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			cycle = 1;
			while(true) {
				num = list.get(0)-cycle;
				list.remove(0);
				if(num <= 0) {
					list.add(0);
					break;
				}else {
					list.add(num);
					cycle++;
					if(cycle > 5) {
						cycle = 1;
					}
				}
			}
			for (int i = 0; i < 8; i++) {
				sb.append(list.get(i)).append(" ");
			}
			sb.append("\n");
			list.removeAll(list);
		}
		System.out.print(sb);
	}
}

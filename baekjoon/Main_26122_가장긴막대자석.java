package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main_26122_가장긴막대자석 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int K = Integer.parseInt(in.readLine());
		String str = in.readLine();
		List<Integer> list = new ArrayList<Integer>();
		
		char nowChar = str.charAt(0);
		int cnt = 0;
		for (int i = 0, len = str.length(); i < len; i++) {
			if(str.charAt(i) == nowChar) {
				cnt++;
			}else {
				list.add(cnt);
				nowChar = str.charAt(i);
				cnt = 1;
			}
		}
		list.add(cnt);
		
		int len = 0;
		if(list.size() > 1) {
			for (int i = 0, size = list.size()-1; i < size; i++) {
				int tmpLen = Math.min(list.get(i), list.get(i+1))*2;
				len = Math.max(len, tmpLen);
			}
		}
		System.out.print(len);
	}
}

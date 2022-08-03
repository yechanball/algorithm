package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_1157_단어공부 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		char[] ch = in.readLine().toUpperCase().toCharArray();
		Arrays.sort(ch);
		
		int[] cnt = new int[ch.length];
		int nIdx = 0;
		cnt[0] = 1;
		for (int i = 1; i < ch.length; i++) {
			if(ch[i] == ch[nIdx]) {
				cnt[nIdx]++;
			}else {
				nIdx = i;
				cnt[nIdx] = 1;
			}
		}
		
		int max = 0;
		int maxIdx = 0;
		boolean overlap = false;
		for (int i = 0; i < cnt.length; i++) {
			if(cnt[i] > max) {
				max = cnt[i];
				maxIdx = i;
				overlap = false;
			}else if(cnt[i] == max) {
				overlap = true;
			}
		}
		
		if(overlap) {
			System.out.print("?");
		}else {
			System.out.print(ch[maxIdx]);
		}
	}
}

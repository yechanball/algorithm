package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main_1213_팰린드롬만들기 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		String str = in.readLine();
		for (int i = 0, len = str.length(); i < len; i++) {
			char ch = str.charAt(i);
			if(map.containsKey(ch)) map.put(ch, map.get(ch) + 1);
			else map.put(ch, 1);
		}
		
		List<Character> keySet = new ArrayList<Character>(map.keySet());
		Collections.sort(keySet);
		
		char center = '0';
		int oddCnt = 0;
		boolean isPoss = true;
		for (char key : keySet) {
			int cnt = map.get(key);
			if(cnt%2 == 1) {
				if(oddCnt == 0) {
					center = key;
					oddCnt++;
				}else {
					isPoss = false;
					break;
				}
			}
			for (int i = 0; i < cnt/2; i++) {
				sb.append(key);
			}
		}
		
		if(isPoss) {
			StringBuilder half = new StringBuilder(sb.toString());
			if(oddCnt == 1) sb.append(center);
			sb.append(half.reverse().toString());
		}else {
			sb = new StringBuilder();
			sb.append("I'm Sorry Hansoo");
		}
		
		out.write(sb.toString());
		out.flush();
		out.close();
	}
}

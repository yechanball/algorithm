package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main_2754_학점계산 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		Map<String, String> map = new HashMap<>();
		map.put("A+", "4.3");
		map.put("A0", "4.0");
		map.put("A-", "3.7");
		map.put("B+", "3.3");
		map.put("B0", "3.0");
		map.put("B-", "2.7");
		map.put("C+", "2.3");
		map.put("C0", "2.0");
		map.put("C-", "1.7");
		map.put("D+", "1.3");
		map.put("D0", "1.0");
		map.put("D-", "0.7");
		map.put("F", "0.0");
		
		System.out.print(map.get(in.readLine()));
	}
}

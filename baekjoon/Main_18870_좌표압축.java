package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class Main_18870_좌표압축 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();	
		
		List<Integer> input = new ArrayList<Integer>(); // 입력 리스트
		HashSet<Integer> set = new HashSet<Integer>(); // 입력 셋
		int N = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			input.add(num);
			set.add(num);
		}
		
		List<Integer> list = new ArrayList<Integer>(set); // 순서를 나타낼 리스트
		Collections.sort(list); // 오름차순 정렬
		HashMap<Integer, Integer> map = new HashMap<>(); // 순서와 값을 키를 통해 매칭
		for (int i = 0, len = list.size(); i < len; i++) {
			map.put(list.get(i), i); // key: 값, value: 순위
		}
		
		for (int i = 0, len = input.size(); i < len; i++) { // 입력값 순위 매기기
			sb.append(map.get(input.get(i))).append(" ");
		}
		
		out.write(sb.toString());
		out.flush();
		out.close();
	}
}

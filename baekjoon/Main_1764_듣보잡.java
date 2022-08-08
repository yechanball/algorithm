package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1764_듣보잡 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashMap<String, Integer> list = new HashMap<>();
		for (int i = 1; i <= N; i++) { // 듣도 못한 사람 목록
			list.put(in.readLine(), i);
		}
		
		List<String> result = new ArrayList<String>();
		String input;
		for (int i = 0; i < M; i++) {
			input = in.readLine(); // 보도 못한 사람 입력
			if(list.containsKey(input)) result.add(input); // 보도 못한 사람이 듣도 못한지 확인
		}
		
		Collections.sort(result); // 결과 정렬
		sb.append(result.size());
		for (String person : result) {
			sb.append("\n").append(person);
		}
		System.out.print(sb);
	}
}

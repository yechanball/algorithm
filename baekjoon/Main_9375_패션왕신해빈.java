package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_9375_패션왕신해빈 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(in.readLine());
		int N, answer;
		for (int tc = 1; tc <= T; tc++) {
			Map<String,Integer> map = new HashMap<String,Integer>();
			N = Integer.parseInt(in.readLine());
			answer = 1;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				st.nextToken(); // 첫번째 이름 버리기
				String k = st.nextToken();
				if(map.containsKey(k)) {
					map.put(k, map.get(k)+1); // 이미 존재하면 원래 값보다 1 늘리기
				}else {
					map.put(k, 1); // 존재하지 않은 키면 추가하기
				}
			}
			for (int value : map.values()) {
				answer *= (value+1); // 모든 의상 종류에서 안입을 옵션을 고르는 경우만 계산
			}
			sb.append(answer-1).append("\n");
		}
		out.write(sb.toString());
		out.flush();
		out.close();
	}
}
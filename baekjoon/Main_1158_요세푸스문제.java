package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1158_요세푸스문제 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i <= N; i++) {
			list.add(i);
		}
		int nowIdx = 0;
		K--; // 다음 제거할 숫자는 K-1 인덱스 차이
		sb.append("<");
		while(N > 1) {
			nowIdx += K;
			if(nowIdx >= N) nowIdx %= N; // 인덱스가 전체 개수 넘으면 다시 돌아오기
			sb.append(list.get(nowIdx)).append(", ");
			list.remove(nowIdx);
			N--;
		}
		sb.append(list.get(0)).append(">");
		System.out.print(sb);
	}
}

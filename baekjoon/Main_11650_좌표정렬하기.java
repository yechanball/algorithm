package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main_11650_좌표정렬하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		List<int[]> list = new ArrayList<int[]>(); // 0: X좌표, 1: Y좌표
		int N = Integer.parseInt(in.readLine());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			list.add(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())}); // 좌표 입력
		}
		Collections.sort(list, new Comparator<int[]>() {
			@Override
			public int compare(int[] n1, int[] n2) {
				if(n1[0] == n2[0]) return n1[1] - n2[1]; // X좌표가 같으면 Y좌표를 오름차순으로 정렬
				return n1[0] - n2[0]; // X좌표를 기준으로 오름차순 정렬
			}
		});
		for (int[] num : list) {
			sb.append(num[0]).append(" ").append(num[1]).append("\n");
		}
		out.write(sb.toString());
		out.flush();
		out.close();
	}
}

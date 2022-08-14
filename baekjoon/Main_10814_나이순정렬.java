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

public class Main_10814_나이순정렬 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();		
		StringTokenizer st;
		
		int N = Integer.parseInt(in.readLine());
		List<String[]> list = new ArrayList<String[]>(); 
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			list.add(new String[] {Integer.toString(i), st.nextToken(), st.nextToken()}); // 가입 번호, 나이, 이름 문자열의 배열을 저장
		}
		Collections.sort(list, new Comparator<String[]>() {
			@Override
			public int compare(String[] s1, String[] s2) {
				if(s1[1].equals(s2[1])) return Integer.parseInt(s1[0]) - Integer.parseInt(s2[0]); // 나이가 같다면 가입 번호 순으로 정렬하기;
				return Integer.parseInt(s1[1]) - Integer.parseInt(s2[1]); // 나이가 다르다면 나이 순 정렬
			}
		});
		for (String[] str : list) {
			sb.append(str[1]).append(" ").append(str[2]).append("\n");
		}
		out.write(sb.toString());
		out.flush();
		out.close();
	}
}

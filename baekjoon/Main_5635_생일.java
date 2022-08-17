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

public class Main_5635_생일 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		List<String[]> list = new ArrayList<String[]>();
		int N = Integer.parseInt(in.readLine());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			list.add(new String[] {st.nextToken(),st.nextToken(),st.nextToken(),st.nextToken()});
		}
		Collections.sort(list, new Comparator<String[]>() {
			@Override
			public int compare(String[] s1, String[] s2) {
				if(s1[3].equals(s2[3])) {
					if(s1[2].equals(s2[2])){
						return Integer.parseInt(s1[1]) - Integer.parseInt(s2[1]);												
					}else
						return Integer.parseInt(s1[2]) - Integer.parseInt(s2[2]);						
				}else
					return Integer.parseInt(s1[3]) - Integer.parseInt(s2[3]);
			}
		});
		sb.append(list.get(list.size()-1)[0]).append("\n").append(list.get(0)[0]);
		out.write(sb.toString());
		out.flush();
		out.close();
	}
}
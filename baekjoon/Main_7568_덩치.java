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

public class Main_7568_덩치 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		List<int[]> list = new ArrayList<int[]>();
		int N = Integer.parseInt(in.readLine());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			list.add(new int[] {i, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
		}
		
		Collections.sort(list, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return (o1[1] == o2[1]) ? (o1[2] - o2[2]) : (o1[1] - o2[1]);
			}
		});
		
		int[] result = new int[N];
		int height, weight, cnt;
		for (int i = 0; i < N; i++) {
			height = list.get(i)[1];
			weight = list.get(i)[2];
			cnt = 0;
			for (int j = i+1; j < N; j++) {
				if(list.get(j)[2] > weight && list.get(j)[1] > height) {
					cnt++;
				}
			}
			result[list.get(i)[0]] = cnt+1;
		}
		
		for(int num : result) {
			sb.append(num).append(" ");
		}
		out.write(sb.toString());
		out.flush();
		out.close();
	}
}

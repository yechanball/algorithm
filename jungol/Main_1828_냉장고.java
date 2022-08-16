package algorithm.jungol;

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

public class Main_1828_냉장고 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		List<int[]> chemical = new ArrayList<int[]>(); // [0] 최저 보관 온도, [1] 최고 보관 온도
		int N = Integer.parseInt(in.readLine());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			chemical.add(new int[] {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())});
		}
		
		Collections.sort(chemical, new Comparator<int[]>() { // 최고 보관 온도 오름차순 정렬, 최고 보관 온도가 같다면 최저 보관 온도 오름차순 정렬
			@Override
			public int compare(int[] t1, int[] t2) {
				return t1[1] != t2[1] ? t1[1]-t2[1] : t1[0]-t2[0];
			}
		});
		
		int refrigerator = 1;
		int maxTemp = chemical.get(0)[1]; // 첫 최대 상한 온도는 첫번째 화학물질의 최고 보관 온도
		for (int i = 1; i < N; i++) {
			if(chemical.get(i)[0] > maxTemp) { // 물질의 최저 보관 온도가 상한 보관 온도보다 크면 냉장고 수 늘리고 상한 온도 갱신
				maxTemp = chemical.get(i)[1];
				refrigerator++;
			}
		}
		
		out.write(Integer.toString(refrigerator)); // 필요한 냉장고 개수 출력
		out.flush();
		out.close();
	}
}

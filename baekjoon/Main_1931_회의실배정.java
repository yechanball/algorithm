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

public class Main_1931_회의실배정 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		List<int[]> meeting = new ArrayList<int[]>(); // [0] 시작시간, [1] 종료시간
		int N = Integer.parseInt(in.readLine());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			meeting.add(new int[] {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())});
		}
		
		Collections.sort(meeting, new Comparator<int[]>() { // 종료시간 오름차순 정렬, 종료시간이 같다면 시작시간 오름차순 정렬
			@Override
			public int compare(int[] n1, int[] n2) {
				return n1[1] != n2[1] ? n1[1]-n2[1] : n1[0]-n2[0];
			}
		});
		
		List<int[]> schedule = new ArrayList<int[]>(); // 최대 사용할 수 있는 회의리스트
		schedule.add(meeting.get(0));
		for (int i = 1; i < N; i++) {
			if(schedule.get(schedule.size()-1)[1] <= meeting.get(i)[0]) { // 스케쥴 마지막 끝나는 시간이 회의 시작 시간보다 같거나 작으면
				schedule.add(meeting.get(i));
			}
		}
		
		out.write(Integer.toString(schedule.size())); // 스케쥴 최대 개수 출력
		out.flush();
		out.close();
	}
}

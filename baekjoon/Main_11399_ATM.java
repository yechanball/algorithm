package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main_11399_ATM {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		List<Integer> time = new ArrayList<Integer>();
		int[] subSum = new int[N];
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < N; i++) {
			time.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(time); // 오름차순으로 정렬(짧게 걸리는 시간이 먼저 처리되어야 함)
		subSum[0] = time.get(0);
		for (int i = 1; i < N; i++) { // 부분합 계산
			subSum[i] = subSum[i-1] + time.get(i);
		}
		int totalTime = 0; // 총 소요시간 계산
		for (int i = 0; i < N; i++) {
			totalTime += subSum[i];
		}
		System.out.print(totalTime);
	}
}

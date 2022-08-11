package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_2579_계단오르기 {
	static int[] score; // 각 계단별 점수
	static Integer[] scoreSum; // 각 칸별 오를 수 있는 점수
	
	public static int jump(int N) {
		if(scoreSum[N] == null) { // 탐색하지 않은 경우
			// 두 칸 전에서 바로 두 칸 올라온 경우 / 세 칸 전에서 2칸 뛰어 직전에 도착하는 경우 최댓값 구하기
			scoreSum[N] = Math.max(jump(N-2), jump(N-3) + score[N-1]) + score[N];
		}
		return scoreSum[N];
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(in.readLine()); // 계단 칸수
		score = new int[N+1];
		for (int i = 1; i <= N; i++) {
			score[i] = Integer.parseInt(in.readLine());
		}
		scoreSum = new Integer[N+1];
		scoreSum[0] = score[0]; // 0칸, 1칸 기본 초기화
		scoreSum[1] = score[1];
		if(N > 1) scoreSum[2] = score[1] + score[2]; // 2칸 기본 초기화
		out.write(Integer.toString(jump(N)));  // 얻을 수 있는 점수 최댓값 출력
		out.flush();
		out.close();
	}
}

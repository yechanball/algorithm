package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_2961_도영이가만든맛있는음식 {
	static int N, R; // nCr, N: 전체 수, R: 뽑을 수
	static int[][] taste; // 0: 신맛, 1: 쓴맛
	static int minDiff = Integer.MAX_VALUE; // 신맛과 쓴맛의 차이 최솟값
	
	public static void combi(int cnt, int start, int sour, int bitter) {
		if(cnt == R) { // 전부 다 뽑은 경우
			int diff = Math.abs(sour - bitter); // 신맛과 쓴맛 차이
			if(diff < minDiff) minDiff = diff; // 최솟값 비교
			return;
		}else{
			for (int i = start; i < N; i++) {
				combi(cnt+1, i+1, sour*taste[i][0], bitter+taste[i][1]); // 재귀 호출
			}
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		// 입력
		N = Integer.parseInt(in.readLine());
		taste = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			taste[i][0] = Integer.parseInt(st.nextToken());
			taste[i][1] = Integer.parseInt(st.nextToken());
		}
		// 조합 생성
		for (int r = 1; r <= N; r++) { // N개중 1개에서 N개 뽑는 경우까지 찾기
			R = r; // 뽑을 개수
			combi(0, 0, 1, 0);
		}
		out.write(Integer.toString(minDiff));
		out.flush();
		out.close();
	}
}

package algorithm.swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_5215_햄버거다이어트 {
	static int maxTaste; // 극강의 미미!!
	static int N; // 재료의 수
	static int L; // 제한 칼로리
	static int[][] hamElement; // 0: 맛 점수, 1: 칼로리
	static boolean[] select; // 재료 선택 여부
	
	// 재료 조합
	public static void combination(int start, int sumTaste, int preTaste, int calorie) { // start: 인덱스 시작지점, sumTaste: 이전의 이전까지 재귀까지 누적합, preTaste: 이전의 맛, calorie: 이전까지 누적 칼로리
		if (calorie > L) { // 칼로리가 제한을 넘어간 경우, 값 비교 후 종료
			if(sumTaste > maxTaste) { // 누적 맛 점수가 최대 맛 점수를 능가하면 갱신
				maxTaste = sumTaste;
			}
			return;
		} else if(start == N){ // 끝까지 다 고른 경우, 값 비교 후 종료
			sumTaste += preTaste;
			if(sumTaste > maxTaste) { // 누적 맛 점수가 최대 맛 점수를 능가하면 갱신
				maxTaste = sumTaste;
			}
			return;
		} else {
			sumTaste += preTaste; // 칼로리가 넘지않으면 이전 맛 점수 추가
			for (int i = start; i < N; i++) {
				select[i] = true;
				combination(i+1, sumTaste, hamElement[i][0], calorie+hamElement[i][1]);
				select[i] = false;				
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(in.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			hamElement = new int[N][2];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine(), " ");				
				hamElement[i][0] = Integer.parseInt(st.nextToken());
				hamElement[i][1] = Integer.parseInt(st.nextToken());
			}
			maxTaste = Integer.MIN_VALUE; // 맛 초기화
			select = new boolean[N];
			combination(0, 0, 0, 0); // 재료 조합 호출
			sb.append(maxTaste).append("\n");
		}
		out.write(sb.toString());
		out.flush();
		out.close();
	}
}

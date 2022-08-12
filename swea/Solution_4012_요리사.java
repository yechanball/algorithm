package algorithm.swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_4012_요리사 {
	static int N; // 재료의 수
	static int[][] S; // 재료간 시너지 배열
	static int[] dishA; // A음식 재료
	static int[] dishB; // B음식 재료
	static int[] pickA = new int[2]; // A음식에서 재료 2개 담을 배열
	static int[] pickB = new int[2]; // B음식에서 재료 2개 담을 배열
	static int tasteA; // A음식 맛
	static int tasteB; // B음식 맛 
	static int minTasteDiff; // 음식 간의 맛 차이 최소
	
	// 각 음식에서 재료 두개씩 뽑아 시너지 계산
	public static void calcTaste(int cnt, int start) {
		if(cnt == 2) { // A음식 재료를 다 고른 경우
			tasteA += (S[pickA[0]][pickA[1]] + S[pickA[1]][pickA[0]]);
			tasteB += (S[pickB[0]][pickB[1]] + S[pickB[1]][pickB[0]]);
			return;
		}else {
			for (int i = start; i < N/2; i++) {
				pickA[cnt] = dishA[i];
				pickB[cnt] = dishB[i];
				calcTaste(cnt+1, i+1);
			}
		}
	}
	
	// N개의 재료에서 각 요리에 사용될 N/2개 재료 선택
	public static void combiDish(int cnt, int start, int flag) {
		if(cnt == N/2) { // A음식 재료를 다 고른 경우
			int idx = 0;
			for (int i = 0; i < N; i++) {
				if((flag & 1<<i)!=0) continue;
				dishB[idx++] = i;
			}
			tasteA = 0; // 맛 초기화
			tasteB = 0;
			calcTaste(0, 0); // 맛 계산
			int tasteDiff = Math.abs(tasteA-tasteB);
			if(tasteDiff < minTasteDiff)
				minTasteDiff = tasteDiff;
			return;
		}else {
			for (int i = start; i < N; i++) {
				dishA[cnt] = i;
				combiDish(cnt+1, i+1, flag | 1<<i);
			}
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;		
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			N = Integer.parseInt(in.readLine());
			S = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				for (int j = 0; j < N; j++) {
					S[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			dishA = new int[N/2];
			dishB = new int[N/2];
			minTasteDiff = Integer.MAX_VALUE; // 초기화
			combiDish(0, 0, 0); // 메서드 호출
			sb.append(minTasteDiff).append("\n");
		}
		out.append(sb.toString());
		out.flush();
		out.close();
	}
}

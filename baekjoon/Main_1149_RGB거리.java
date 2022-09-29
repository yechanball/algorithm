package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1149_RGB거리 {
	static int N; // 집의 수
	static int[][] rgbCost; // 각 집의 RGB 비용
	static int[][] minCost; // 누적 RGB 최소비용
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(in.readLine());
		rgbCost = new int[N][3];
		minCost = new int[N][3];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			rgbCost[i][0] = Integer.parseInt(st.nextToken());
			rgbCost[i][1] = Integer.parseInt(st.nextToken());
			rgbCost[i][2] = Integer.parseInt(st.nextToken());			
		}
		
		minCost[0] = Arrays.copyOf(rgbCost[0], 3); // 초기화
		
		int answer = Integer.MAX_VALUE;
		for (int i = 0; i < 3; i++) {
			int cost = findMinCost(N-1, i); // 최소 비용 찾기
			answer = (cost < answer) ? cost : answer;
		}
		
		out.write(Integer.toString(answer));
		out.flush();
		out.close();
	}
	
	private static int findMinCost(int N, int color) {
		if(minCost[N][color] == 0) { // 탐색하지 않은 경우
			int nowCost = rgbCost[N][color];
			
			switch (color) { // 현재 선택한 색과 이전 색을 다르게 골라 최솟값 찾기
			case 0:
				minCost[N][color] = Math.min(findMinCost(N-1, 1), findMinCost(N-1, 2)) + nowCost;
				break;
			case 1:
				minCost[N][color] = Math.min(findMinCost(N-1, 0), findMinCost(N-1, 2)) + nowCost;
				break;
			case 2:
				minCost[N][color] = Math.min(findMinCost(N-1, 0), findMinCost(N-1, 1)) + nowCost;	
				break;
			}
		}
		
		return minCost[N][color];
	}
}

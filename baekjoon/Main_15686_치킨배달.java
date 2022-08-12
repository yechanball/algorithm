package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_15686_치킨배달 {
	static int N; // 배열 칸 수
	static int M; // 폐업시키지 않을 치킨집 수
	static int chickenCnt; // 치킨집 수
	static List<int[]> chickenList; // 치킨집 배열
	static int homeCnt; // 집 수
	static List<int[]> homeList; // 집 배열
	static int[][] chickenDist; // 도시의 치킨 거리
	static int[][] resultChick; // 살아남은 치킨집 배열
	static int minChickenDist = Integer.MAX_VALUE; // 도시의 치킨 거리 최솟값
	
	// 치킨 거리 계산 메서드 -> (r1,c1)와 (r2,c2)사이 치킨 거리 = |r1-r2|+|c1-c2|
	public static int calcChickenDist(int r1, int c1, int r2, int c2) {
		return Math.abs(r1-r2)+Math.abs(c1-c2);
	}
	
	public static void findSurviveChick(int cnt, int start) {
		if(cnt == M) { // M개 치킨집 다 고른 경우
			int sum = 0;
			for (int i = 0; i < homeCnt; i++) {
				int min = Integer.MAX_VALUE;
				for (int j = 0; j < M; j++) { // 각 집의 치킨 거리 계산
					if(resultChick[j][i] < min) // 치킨 거리 최솟값 갱신 
						min = resultChick[j][i];
				}
				sum += min; // 치킨거리 누적
			}
			if(sum < minChickenDist) // 도시의 치킨거리 최솟값 갱신
				minChickenDist = sum;
			return;
		}else {
			for (int i = start; i < chickenCnt; i++) {
				resultChick[cnt] = Arrays.copyOf(chickenDist[i], homeCnt);
				findSurviveChick(cnt+1, i+1);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		// 입력
		int[][] map = new int[N+1][N+1];
		chickenList = new ArrayList<int[]>();
		homeList = new ArrayList<int[]>();
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) { // 치킨집인 경우
					chickenList.add(new int[]{i,j}); // 치킨집 위치 추가					
				}else if(map[i][j] == 1) { // 집인 경우
					homeList.add(new int[]{i,j}); // 집 위치 추가
				}
			}
		}
		chickenCnt = chickenList.size();
		homeCnt = homeList.size();
		// 치킨집별 모든 집 사이 치킨 거리 계산
		chickenDist = new int[chickenCnt][homeCnt];
		for (int i = 0; i < chickenCnt; i++) {
			for (int j = 0; j < homeCnt; j++) {
				chickenDist[i][j] = calcChickenDist(chickenList.get(i)[0], chickenList.get(i)[1], homeList.get(j)[0], homeList.get(j)[1]);
			}
		}
		// 살아남을 치킨집 찾기
		resultChick = new int[M][homeCnt];
		findSurviveChick(0, 0);
		// 도시의 치킨거리 최솟값 출력
		out.write(Integer.toString(minChickenDist));
		out.flush();
		out.close();
	}
}

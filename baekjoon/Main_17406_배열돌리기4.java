package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_17406_배열돌리기4 {
	static int[][] originArr; // 첫 입력 배열
	static int[][] arr; // 회전시킬 배열
	static int[][] rotate; // 회전 연산 배열
	static int[] permOrder; // 회전 연산 순서 순열 결과
	static boolean[] visited; // 순열 생성시 중복 체크 배열
	static int N;
	static int M;
	static int K;
	static int min = Integer.MAX_VALUE;
	
	public static void permutationint(int cnt) { // 순열 구하기
		if(cnt == K) { // 더 이상 뽑을 것이 없을 때 재귀 종료
			for (int num : permOrder) { // 순열로 생성된 순서에 맞추어 회전 연산 진행
				rotation(rotate[num][0], rotate[num][1], rotate[num][2]);
			}
			for (int i = 0; i < N; i++) { // 각 행 합 계산 후 최솟값 비교
				int sum = 0;
				for (int j = 0; j < M; j++) {
					sum += arr[i][j];
				}
				min = (sum < min) ? sum : min;
			}
			for(int i = 0; i < N; i++){ // 회전시킨 배열 초기화
				System.arraycopy(originArr[i], 0, arr[i], 0, M);
			}
			return;
		}else { // 고르지 않은 것 중 하나 뽑기
			for (int num = 0; num < K; num++) {
				if(!visited[num]) {
					permOrder[cnt] = num;
					visited[num] = true;
					permutationint(cnt+1); // 선택하고 재귀 호출
					visited[num] = false; // 다음 선택지를 위해 체크 풀어주기
				}
			}
		}
	}
	
	public static void rotation(int r, int c, int s) { // 부분 배열 회전하기
		int startRow = r-s-1;
		int startCol = c-s-1;
		int endRow = r+s-1;
		int endCol = c+s-1;
		for (int i = 0; i < s; i++) {
			int start = arr[startRow+i][startCol+i]; // 회전 시작 위치
			for (int j = startRow+i; j < endRow-i; j++) arr[j][startCol+i] = arr[j+1][startCol+i]; // 왼쪽 열 이동
			for (int j = startCol+i; j < endCol-i; j++) arr[endRow-i][j] = arr[endRow-i][j+1]; // 하단 행 이동
			for (int j = endRow-i; j > startRow+i; j--) arr[j][endCol-i] = arr[j-1][endCol-i]; // 오른쪽 열 이동
			for (int j = endCol-i; j > startCol+i; j--) arr[startRow+i][j] = arr[startRow+i][j-1]; // 상단 행 이동
			arr[startRow+i][startCol+i+1] = start;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		originArr = new int[N][M];
		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < M; j++) {
				originArr[i][j] = Integer.parseInt(st.nextToken());
				arr[i][j] = originArr[i][j];
			}
		}
		rotate = new int[K][3];
		permOrder = new int[K];
		visited = new boolean[K];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < 3; j++) {
				rotate[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		permutationint(0); // 순열 생성 후 회전
		
		System.out.print(min);
	}
}

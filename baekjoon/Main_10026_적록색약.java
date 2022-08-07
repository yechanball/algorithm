package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10026_적록색약 {
	static int N;
	static char[][] rgbNormal; // 일반인이 보는 RGB
	static char[][] rgbWeakness; // 적록색약이 보는 RGB
	static boolean[][] checkNormal; // 일반인 확인
	static boolean[][] checkWeakness; // 적록색약 확인
	
	private static void searchNormal(int preColor, int row, int col) { // 일반인 색 탐색
		if(row < 0 || row >= N || col < 0 || col >= N) return; // 범위를 벗어난 경우 종료
		else if(checkNormal[row][col] || rgbNormal[row][col] != preColor) return; // 이미 확인했거나 이전과 색이 다른 경우 종료
		else {
			checkNormal[row][col] = true; // 확인 완료
			searchNormal(preColor, row-1, col);  // 상
			searchNormal(preColor, row+1, col);  // 하
			searchNormal(preColor, row, col-1);  // 좌
			searchNormal(preColor, row, col+1);  // 우	
		}
	}
	
	private static void searchWeakness(int preColor, int row, int col) { // 적록색약 색 탐색
		if(row < 0 || row >= N || col < 0 || col >= N) return; // 범위를 벗어난 경우 종료
		else if(checkWeakness[row][col] || rgbWeakness[row][col] != preColor) return; // 이미 확인했거나 이전과 색이 다른 경우 종료
		else {
			checkWeakness[row][col] = true; // 확인 완료
			searchWeakness(preColor, row-1, col);  // 상
			searchWeakness(preColor, row+1, col);  // 하
			searchWeakness(preColor, row, col-1);  // 좌
			searchWeakness(preColor, row, col+1);  // 우	
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		rgbNormal= new char[N][N];
		rgbWeakness= new char[N][N];
		String input;
		for (int i = 0; i < N; i++) {
			input = in.readLine();
			for (int j = 0; j < N; j++) {
				rgbNormal[i][j] = input.charAt(j);
				if(input.charAt(j) == 'G') rgbWeakness[i][j] = 'R'; // 적록색약인 경우 G를 R로 읽기
				else rgbWeakness[i][j] = input.charAt(j);				
			}
		}
		
		checkNormal = new boolean[N][N];
		checkWeakness = new boolean[N][N];
		int notRGColorWeakness = 0;
		int rgColorWeakness = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!checkNormal[i][j]) {
					searchNormal(rgbNormal[i][j], i, j);
					notRGColorWeakness++;
				}
				if(!checkWeakness[i][j]) {
					searchWeakness(rgbWeakness[i][j], i, j);
					rgColorWeakness++;
				}
			}
		}
		
		System.out.print(notRGColorWeakness+" "+rgColorWeakness);
		
	}
}

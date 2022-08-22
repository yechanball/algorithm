package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_3025_돌던지기 {
	static int R, C; // R: 행, C: 열
	static char[][] map; // 시뮬레이션 맵 -> . 빈칸   X 장애물  O 굳은 화산탄 
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		R = Integer.parseInt(st.nextToken()); // 행 입력
		C = Integer.parseInt(st.nextToken()); // 열 입력
		map = new char[R][C]; // RxC Map 생성
		
		for (int i = 0; i < R; i++) { // 초기 Map 정보 입력
			String input = in.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = input.charAt(j);
			}
		}
		
		int N = Integer.parseInt(in.readLine()); // N: 날아올 화산탄의 횟수
		int inputCol;
		for (int i = 0; i < N; i++) {
			inputCol = Integer.parseInt(in.readLine()) - 1; // 주어진 화산탄의 열은 왼쪽 기준 1번부터 시작이므로 1빼서 입력 받기
			moveDown(0,inputCol); // (0,inputCol) 좌표에서 화산탄 굴리기
		}
		
		for (int i = 0; i < R; i++) { // Map 결과 출력 문자열에 넣기
			for (int j = 0; j < C; j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}	
		sb.deleteCharAt(sb.length()-1); // 마지막 줄바꿈 삭제
		out.write(sb.toString()); // 결과 출력
		out.flush();
		out.close();
	}
	
	public static void moveDown(int row, int col) { // 화산탄 아래로 굴리기 메서드
		if(row == R-1 || map[row+1][col] == 'X') { // 맨 아래에 화산탄이 도착했거나 아래칸이 장애물로 막혀있는 경우 굳히기
			map[row][col] = 'O'; // 굳은 화산탄 추가
			return; // 재귀 종료
		}else if(map[row+1][col] == '.') { // 아래가 빈 칸이라면 아래로 이동
			moveDown(row+1, col); // 아래칸으로 재귀 호출
		}else if(col-1 >= 0 && map[row][col-1] == '.' && map[row+1][col-1] == '.') { // 왼쪽 칸과 왼쪽-아래 칸이 비어있는 경우 왼쪽-아래 칸으로 이동 
			moveDown(row+1, col-1); // 왼쪽 아래칸으로 재귀 호출
		}else if(col+1 < C && map[row][col+1] == '.' && map[row+1][col+1] == '.') { // 오른쪽 칸과 오른쪽-아래 칸이 비어있는 경우 오른쪽-아래 칸으로 이동 
			moveDown(row+1, col+1); // 오른쪽 아래칸으로 재귀 호출
		}else { // 이동이 불가한 경우 화산탄 굳히기
			map[row][col] = 'O'; // 굳은 화산탄 추가
			return; // 재귀 종료
		}	
	}
}

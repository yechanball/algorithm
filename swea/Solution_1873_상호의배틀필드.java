package algorithm.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1873_상호의배틀필드 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		
		for (int testcase = 1; testcase <= T; testcase++) {
			sb.append("#").append(testcase).append(" ");
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			
			// H x W 필드 생성
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			char[][] field = new char[H][W];
			
			// 전차 위치 좌표
			int tankRow = 0;
			int tankCol = 0;
			
			// 필드 입력 및 전차 위치 파악
			String str="";
			for (int i = 0; i < H; i++) {
				str = in.readLine();
				for (int j = 0; j < W; j++) {
					field[i][j] = str.charAt(j);
					if(field[i][j] == '^' || field[i][j] == 'v' || field[i][j] == '<' || field[i][j] == '>' ) {
						tankRow = i;
						tankCol = j;
					}
				}
			}
			
			// 사용자 명령 입력
			int N = Integer.parseInt(in.readLine());
			str = in.readLine();
			for (int i = 0; i < N; i++) {
				switch (str.charAt(i)) {
				case 'U': // 위 이동
					field[tankRow][tankCol] = '^';
					if( (tankRow-1)>=0 && field[tankRow-1][tankCol] == '.') {
						field[tankRow][tankCol] = '.';						
						field[--tankRow][tankCol] = '^';
					}
					break;
				case 'D': // 아래 이동
					field[tankRow][tankCol] = 'v';
					if( (tankRow+1)<H && field[tankRow+1][tankCol] == '.') {
						field[tankRow][tankCol] = '.';						
						field[++tankRow][tankCol] = 'v';
					}
					break;
				case 'L': // 왼쪽 이동
					field[tankRow][tankCol] = '<';
					if( (tankCol-1)>=0 && field[tankRow][tankCol-1] == '.') {
						field[tankRow][tankCol] = '.';						
						field[tankRow][--tankCol] = '<';
					}
					break;
				case 'R': // 오른쪽 이동
					field[tankRow][tankCol] = '>';
					if( (tankCol+1)<W && field[tankRow][tankCol+1] == '.') {
						field[tankRow][tankCol] = '.';						
						field[tankRow][++tankCol] = '>';
					}
					break;
				case 'S': // 포탄 발사
					if (field[tankRow][tankCol] == '^') {
						for (int j = tankRow-1; j >=0 ; j--) {
							if(field[j][tankCol] == '*') {
								field[j][tankCol] = '.';
								break;
							}else if(field[j][tankCol] == '#') {
								break;
							}
						}
					}else if (field[tankRow][tankCol] == 'v') {
						for (int j = tankRow+1; j < H ; j++) {
							if(field[j][tankCol] == '*') {
								field[j][tankCol] = '.';
								break;
							}else if(field[j][tankCol] == '#') {
								break;
							}
						}
					}else if (field[tankRow][tankCol] == '<') {
						for (int j = tankCol-1; j >= 0 ; j--) {
							if(field[tankRow][j] == '*') {
								field[tankRow][j] = '.';
								break;
							}else if(field[tankRow][j] == '#') {
								break;
							}
						}
					}else {
						for (int j = tankCol+1; j < W ; j++) {
							if(field[tankRow][j] == '*') {
								field[tankRow][j] = '.';
								break;
							}else if(field[tankRow][j] == '#') {
								break;
							}
						}
					}
					break;
				default:
					break;
				}
			}
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					sb.append(field[i][j]);
				}
				sb.append("\n");
			}			
		}
		System.out.print(sb);
	}
}

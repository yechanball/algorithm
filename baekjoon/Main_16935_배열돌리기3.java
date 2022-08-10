package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_16935_배열돌리기3 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(in.readLine(), " ");
		boolean isRotate = false;
		int[][] rotateArr = new int[M][N];
		int[][] subArr;
		int[] tmpArr;
		int tmpNum;
		for (int r = 0; r < R; r++) {
			switch(Integer.parseInt(st.nextToken())) {
			case 1: // 상하 반전
				if (isRotate) { // [M][N] 상태인 경우
					tmpArr = new int[N];
					for (int i = 0; i < M/2; i++) {
						tmpArr = rotateArr[i];
						rotateArr[i] = rotateArr[M-i-1];
						rotateArr[M-i-1] = tmpArr;
					}
				}else { // [N][M] 상태인 경우
					tmpArr = new int[M];
					for (int i = 0; i < N/2; i++) {
						tmpArr = arr[i];
						arr[i] = arr[N-i-1];
						arr[N-i-1] = tmpArr;
					}
				}
				break;
			case 2: // 좌우 반전
				if (isRotate) { // [M][N] 상태인 경우
					for (int i = 0; i < M; i++) {
						for (int j = 0; j < N/2; j++) {
							tmpNum = rotateArr[i][j];
							rotateArr[i][j] = rotateArr[i][N-j-1];
							rotateArr[i][N-j-1] = tmpNum;						
						}
					}
				}else { // [N][M] 상태인 경우
					for (int i = 0; i < N; i++) {
						for (int j = 0; j < M/2; j++) {
							tmpNum = arr[i][j];
							arr[i][j] = arr[i][M-j-1];
							arr[i][M-j-1] = tmpNum;						
						}
					}
				}
				break;
			case 3: // 시계방향 90도 회전
				if (isRotate) { // [M][N] 상태인 경우 -> [N][M]
					for (int i = 0; i < M; i++) {
						for (int j = 0; j < N; j++) {
							arr[j][M-i-1] = rotateArr[i][j];						
						}
					}
					isRotate = false;
				}else { // [N][M] 상태인 경우 -> [M][N]
					for (int i = 0; i < N; i++) {
						for (int j = 0; j < M; j++) {
							rotateArr[j][N-i-1] = arr[i][j];						
						}
					}
					isRotate = true;
				}
				break;
			case 4: // 반시계방향 90도 회전
				if (isRotate) { // [M][N] 상태인 경우 -> [N][M]
					for (int i = 0; i < M; i++) {
						for (int j = 0; j < N; j++) {
							arr[N-j-1][i] = rotateArr[i][j];						
						}
					}
					isRotate = false;
				}else { // [N][M] 상태인 경우 -> [M][N]
					for (int i = 0; i < N; i++) {
						for (int j = 0; j < M; j++) {
							rotateArr[M-j-1][i] = arr[i][j];						
						}
					}	
					isRotate = true;
				}
				break;
			case 5: // N/2 x M/2 부분배열 시계방향 회전
				if (isRotate) { // [M][N] 상태인 경우
					subArr = new int[M/2][N/2];
					for (int i = 0; i < M/2; i++) { // 좌상 배열 저장
						for (int j = 0; j < N/2; j++) {
							subArr[i][j] = rotateArr[i][j];
						}
					}
					for (int i = 0; i < M/2; i++) { // 부분 배열 회전
						for (int j = 0; j < N/2; j++) {
							rotateArr[i][j] = rotateArr[M/2+i][j]; // 좌하 -> 좌상
							rotateArr[M/2+i][j] = rotateArr[M/2+i][N/2+j]; // 우하 -> 좌하
							rotateArr[M/2+i][N/2+j] = rotateArr[i][N/2+j]; // 우상 -> 우하
							rotateArr[i][N/2+j] = subArr[i][j]; // 좌상 -> 우상						
						}
					}			
				}else { // [N][M] 상태인 경우
					subArr = new int[N/2][M/2];
					for (int i = 0; i < N/2; i++) { // 좌상 배열 저장
						for (int j = 0; j < M/2; j++) {
							subArr[i][j] = arr[i][j];
						}
					}
					for (int i = 0; i < N/2; i++) { // 부분 배열 회전
						for (int j = 0; j < M/2; j++) {
							arr[i][j] = arr[N/2+i][j]; // 좌하 -> 좌상
							arr[N/2+i][j] = arr[N/2+i][M/2+j]; // 우하 -> 좌하
							arr[N/2+i][M/2+j] = arr[i][M/2+j]; // 우상 -> 우하
							arr[i][M/2+j] = subArr[i][j]; // 좌상 -> 우상						
						}
					}
				}
				break;
			case 6: // N/2 x M/2 부분배열 반시계방향 회전
				if (isRotate) { // [M][N] 상태인 경우
					subArr = new int[M/2][N/2];
					for (int i = 0; i < M/2; i++) { // 좌상 배열 저장
						for (int j = 0; j < N/2; j++) {
							subArr[i][j] = rotateArr[i][j];
						}
					}
					for (int i = 0; i < M/2; i++) { // 부분 배열 회전
						for (int j = 0; j < N/2; j++) {
							rotateArr[i][j] = rotateArr[i][N/2+j]; // 우상 -> 좌상
							rotateArr[i][N/2+j] = rotateArr[M/2+i][N/2+j]; // 우하 -> 우상
							rotateArr[M/2+i][N/2+j] = rotateArr[M/2+i][j]; // 좌하 -> 우하
							rotateArr[M/2+i][j] = subArr[i][j]; // 좌상 -> 좌하				
						}
					}		
				}else { // [N][M] 상태인 경우
					subArr = new int[N/2][M/2];
					for (int i = 0; i < N/2; i++) { // 좌상 배열 저장
						for (int j = 0; j < M/2; j++) {
							subArr[i][j] = arr[i][j];
						}
					}
					for (int i = 0; i < N/2; i++) { // 부분 배열 회전
						for (int j = 0; j < M/2; j++) {
							arr[i][j] = arr[i][M/2+j]; // 우상 -> 좌상
							arr[i][M/2+j] = arr[N/2+i][M/2+j]; // 우하 -> 우상
							arr[N/2+i][M/2+j] = arr[N/2+i][j]; // 좌하 -> 우하
							arr[N/2+i][j] = subArr[i][j]; // 좌상 -> 좌하				
						}
					}
				}		
				break;
			}
		}
		if (isRotate) {
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					sb.append(rotateArr[i][j]).append(" ");
				}
				sb.append("\n");
			}			
		}else {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					sb.append(arr[i][j]).append(" ");
				}
				sb.append("\n");
			}						
		}
		out.write(sb.toString());
		out.flush();
		out.close();
	}
}

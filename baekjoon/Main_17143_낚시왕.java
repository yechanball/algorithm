package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main_17143_낚시왕 {
	static int R, C, M; // R:행, C:열, M:상어의 수
	static int sharkSum = 0; // 잡은 상어의 크기 합
	static int[][] board; // 주어진 격자판 -> 낚시왕:-1, 상어:번호, 빈칸:0
	static List<int[]> sharks = new ArrayList<int[]>(); // num(상어번호), r(행), c(열), s(속력), d(방향), z(크기)
	static List<int[]> tmpSharks = new ArrayList<int[]>();
	static int[] dr = new int[] {0, -1, 1, 0, 0}; // 1:상, 2:하, 3:우, 4:좌
	static int[] dc = new int[] {0, 0, 0, 1, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		board = new int[R+1][C+1];
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			sharks.add(new int[] {i, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
			board[sharks.get(i-1)[1]][sharks.get(i-1)[2]] = sharks.get(i-1)[0];
		}
		
		board[0][0] = -1;
		goFish(1);
		
		out.write(Integer.toString(sharkSum));
		out.flush();
		out.close();
	}

	private static void goFish(int cnt) {
		if(cnt == C+1) { // 낚시왕이 끝까지 이동한 경우
			return; // 종료
		}
		
		board[0][cnt] = -1;
		
		for (int i = 1; i <= R; i++) { // 낚시왕이 있는 열에서 가장 가까운 상어 잡기
			if(board[i][cnt] != 0) {
				removeShark(board[i][cnt]);
				board[i][cnt] = 0;
				break;
			}
		}
		
		System.out.println("---cnt : "+ cnt+"번째 변경 전-----");
		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println("");
		}
		moveShark(); // 상어 이동	
		System.out.println("--- 변경 후-----");
		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println("");
		}
		goFish(cnt+1); // 재귀 호출
	}

	private static void removeShark(int sharkNum) { // 상어 제거
		for (int i = 0, size = sharks.size(); i < size; i++) {
			if(sharks.get(i)[0] == sharkNum) {  
				sharkSum += sharks.get(i)[5]; // 상어 크기 더하기
				sharks.remove(i); // 상어 목록에서 상어 번호 찾아서 삭제
				break;
			}
		}
	}
	
	private static void moveShark() { // 상어 이동
		tmpSharks.removeAll(tmpSharks);
		
		for (int i = 0, len = sharks.size(); i < len; i++) {
			int[] shark = sharks.get(i);
			int row = shark[1];
			int col = shark[2];
			int speed = shark[3];
			int direction = shark[4];
			
			board[row][col] = 0; // 격자판에서 상어 지우기
			
			if(direction == 1) {
				if(row > speed) {
					row -= speed;
				}else if(((speed-row+1)/(R-1))%2 == 0) {
					row = (speed-row+1)%(R-1) + 1;
					direction = 2;
				}else {
					row = R - ((speed-row+1)%(R-1));
				}
			}else if(direction == 2) {
				if(R-row > speed) {
					row += speed;
				}else if(((speed-R+row)/(R-1))%2 == 0) {
					row = R - (speed-R+row)%(R-1);
					direction = 1;
				}else {
					row = ((speed-row+1)%(R-1));
				}
			}else if(direction == 3) {
				if(C-col > speed) {
					col += speed;
				}else if(((speed-C+col)/(C-1))%2 == 0) {
					if(((speed-C+col)%(C-1)) == 0) {
						col = C;						
					}else {
						col = (speed-C+col)%(C-1) + 1;						
					}
					direction = 4;
				}else {
					if(((speed-col+1)%(C-1)) == 0) {
						col = C-1;
						direction = 4;
					}else {
						col = C - ((speed-col+1)%(C-1)) + 1;						
					}
				}
			}else if(direction == 4) {
				if(col > speed) {
					col -= speed;
				}else if(((speed-col+1)/(C-1))%2 == 0) {
					if(((speed-col+1)%(C-1)) == 0) {
						col = C;
					}else {
						col = (speed-col+1)%(C-1) + 1;						
					}
					direction = 3;
				}else {
					if(((speed-col+1)%(C-1)) == 0) {
						col = C-1;
						direction = 3;
					}else {
						col = C - ((speed-col+1)%(C-1)) + 1;						
					}
				}
			}
			
//			for (int j = 0; j < speed; j++) {
//				int nr = row + dr[direction];
//				int nc = col + dc[direction];
//				
//				if(nr <= 0 || nr > R || nc <= 0 || nc > C) { // 격자판 넘는 경우 방향 바꾸기
//					if(direction >= 3) {
//						direction = (direction == 3) ? 4 : 3;
//					}else {
//						direction = (direction == 1) ? 2 : 1;						
//					}
//				}
//				
//				row += dr[direction];
//				col += dc[direction];
//			}
			
			shark[1] = row;
			shark[2] = col;
			shark[4] = direction;
			
			tmpSharks.add(shark);
		}
		
		sharks.removeAll(sharks);
		if(tmpSharks.size() > 1) {
			Collections.sort(tmpSharks, new Comparator<int[]>() { // 행, 행이 같다면 열로 정렬
				@Override
				public int compare(int[] s1, int[] s2) {
					return (s1[1] == s2[1]) ? s1[2] - s2[2] : s1[1] - s2[1];
				}
			});
			
			int preNum = 0;
			int[] preShark = tmpSharks.get(preNum);
			int idx = 0;
			boolean isExist = false;
			sharks.add(preShark);
			
			for (int i = 1, len = tmpSharks.size(); i < len; i++) {
				int nowNum = i;
				int[] nowShark = tmpSharks.get(nowNum);
				isExist = false;
				
				if(preShark[1] == nowShark[1] && preShark[2] == nowShark[2]) { // 위치가 같다면
					if(preShark[5] > nowShark[5]) { // 사이즈가 작은 상어 삭제
						for (int j = 0; j <= idx; j++) {
							if(sharks.get(j)[0] == preShark[0]) {
								isExist = true;
								break;
							}
						}
						if(!isExist) {
							sharks.add(preShark);
							idx++;
						}
					}else {
						sharks.remove(idx);
						sharks.add(nowShark);
						preNum = nowNum;
						preShark = tmpSharks.get(preNum);
					}
				}else {
					sharks.add(nowShark);
					idx++;
					preNum = nowNum;
					preShark = tmpSharks.get(preNum);
				}
			}			
		}else {
			for (int[] shark : tmpSharks) {
				sharks.add(shark);
			}
		}
		
		for (int[] shark : sharks) {
			board[shark[1]][shark[2]] = shark[0];
		}
	}
}

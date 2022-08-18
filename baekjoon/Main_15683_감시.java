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

public class Main_15683_감시 {
	static int N, M, cctvCnt = 0, minBlind = Integer.MAX_VALUE; // 행, 열 크기, cctv의 수, 사각지대의 최소 크기
	static List<int[]> cctvList; // cctv 리스트
	static List<int[][]> cctv; // cctv 방향
	// 방향 0:상, 1:우, 2:하, :3좌
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void cctvInit() { // cctv 리스트와 방향 배열 생성 및 초기화
		cctvList = new ArrayList<int[]>();
		/* [no, row, col, directionCnt]  
		 * [1, r, c, 4]: 1번 cctv, 방향인덱스: 4
		 * [2, r, c, 2]: 2번 cctv, 방향인덱스: 2
		 * [3, r, c, 4]: 3번 cctv, 방향인덱스: 4
		 * [4, r, c, 4]: 3번 cctv, 방향인덱스: 4
		 * [5, r, c, 1]: 3번 cctv, 방향인덱스: 1
		 * -> 방향 탐색할때는 cctv.get(no)[direction]로 접근 */
		cctv = new ArrayList<int[][]>();
		cctv.add(new int[][] {{0}}); // 0번 cctv는 X
		cctv.add(new int[][] {{0},{1},{2},{3}}); // 1번 cctv는 [4][0] 배열, [상,우,하,좌]
		cctv.add(new int[][] {{0,2},{1,3}}); // 2번 cctv는 [2][2] 배열, [상하,좌우]
		cctv.add(new int[][] {{0,1},{1,2},{2,3},{3,0}}); // 3번 cctv는 [4][2] 배열, [우상,우하,좌하,좌상]
		cctv.add(new int[][] {{3,0,1},{0,1,2},{1,2,3},{2,3,0}}); // 4번 cctv는 [4][3] 배열, [좌상우,상우하,우하좌,하좌상]
		cctv.add(new int[][] {{0,1,2,3}}); // 5번 cctv는 [1][4] 배열, [상하좌우]
	}
	
	public static void setMonitoring(int cnt, int[][] originOffice, int space) {
		if(cnt == cctvCnt) { // 모든 cctv 방향을 확인하면 종료
			minBlind = (space < minBlind) ? space : minBlind; // 남은 공간이 최소 공간인지 비교
			return; // 재귀 종료
		}else {
			int[][] office = new int[N][M]; // 원본 카피
			for (int i = 0; i < N; i++) {
				office[i] = Arrays.copyOf(originOffice[i], M);
			}
			int[] nowCctv = Arrays.copyOf(cctvList.get(cnt),4); // 현재 방향을 바꿀 cctv [no, row, col, directionCnt] 
			for (int d = 0; d < nowCctv[3]; d++) { // 방향 종류만큼 반복
				int[] direction = Arrays.copyOf(cctv.get(nowCctv[0])[d], cctv.get(nowCctv[0])[d].length);
				int checkWatch = 0;
				for (int direct : direction) {
					checkWatch += watchOffice(office, nowCctv[1], nowCctv[2], direct);
				}
				// 출력 테스트
//				System.out.println(cnt+"번째 사무실 상황");
//				System.out.print("\n현재 cctv: "+Arrays.toString(nowCctv));
//				System.out.println("탐색 방향: "+Arrays.toString(direction));				
//				for (int i = 0; i < N; i++) {
//					for (int j = 0; j < M; j++) {
//						System.out.print(office[i][j]+"\t");
//					}
//					System.out.println("");
//				}
				
				setMonitoring(cnt+1, office, space-checkWatch); // 현재 감시하고 있는 방향 상태에서 다음 cctv 설정을 변경하기 위해 재귀 호출
				
				for (int i = 0; i < N; i++) { // 다음 방향으로 설정을 바꾸기 위해 초기화
					office[i] = Arrays.copyOf(originOffice[i], M);
				}
			}			
		}
	}
	
	public static int watchOffice(int[][] office, int row, int col, int direct) { // cctv 위치를 기준으로 감시영역 표시
		int watchCnt = 0;
		
		while(true) {
			row += dr[direct]; // 해당 방향으로 한칸 이동
			col += dc[direct];
			
			if(row < 0 || row >= N || col < 0 || col >= M || office[row][col] == 6)
				break; // 범위를 벗어나거나 벽을 만난 경우 종료
			else if(office[row][col] != 0) 
				continue; // 해당 위치에 cctv가 있거나 이미 감시하고 있는 곳은 무시
			else {
				office[row][col] = -1;
				watchCnt++;
			}
		}
		return watchCnt; // 감시한 칸 수 반환
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[][] office = new int[N][M];
		int space = N*M; // 사무실 공간 크기
		cctvInit();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < M; j++) {
				office[i][j] = Integer.parseInt(st.nextToken());
				if(office[i][j] == 6) space--; // 6(벽)인 경우 사무실 남은 공간 줄이기
				else if(office[i][j] != 0) { // 0(빈공간), 6(벽)이 아닌 경우 -> cctv인 경우
					cctvList.add(new int[] {office[i][j], i, j, cctv.get(office[i][j]).length});
					cctvCnt++;
					space--;
				}
			}
		}
		setMonitoring(0, office, space); // 재귀 메서드 호출
		out.write(Integer.toString(minBlind));
		out.flush();
		out.close();
	}
}

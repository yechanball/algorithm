package algorithm.swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_5644_무선충전 {
	static int[][] map; // 각 배열 칸에는 BC의 충전 범위에 해당되면 비트마스킹을 이용하여 체크
	static List<int[]> batteryC; // BC 정보를 담을 배열 -> 0:x좌표, 1:y좌표, 2:충전범위, 3:처리량
	static int[] dA, dB; // A, B 이동 정보 배열
	static int[] chargerA, chargerB; // A, B 충전량 저장 배열	
	static int A, totalA, totalB; // A, B 총 충전량	
	static int[] dY = {0,-1,0,1,0}; // 정지,상,우,하,좌 방향 배열
	static int[] dX = {0,0,1,0,-1};
	
	public static int calcDist(int x1, int y1, int x2, int y2) { // 거리 계산 메서드
		return Math.abs(x1-x2) + Math.abs(y1-y2);
	}
	
	public static void markCoverage(int no, int X, int Y, int cover) { // BC 기준으로 충전범위 마스킹
		int startX = X-cover<1 ? 1 : X-cover;
		int endX = X+cover>10 ? 10 : X+cover;
		int startY = Y-cover<1 ? 1 : Y-cover;
		int endY = Y+cover>10 ? 10 : Y+cover;
		
		for (int i = startY; i <= endY; i++) {
			for (int j = startX; j <= endX; j++) {
				if(calcDist(j, i, X, Y) <= cover) {
					map[i][j] |= 1<<no; // BC의 해당하는 충전범위이면 비트 마스킹
				}
			}
		}
	}
	
	public static void move(int M, int aX, int aY, int bX, int bY) { // M시간일때 A와 B 움직이기
		if(M >= dA.length) return;
		
		// A 좌표 움직이기
		aX += dX[dA[M]];
		aY += dY[dA[M]];
		
		// B 좌표 움직이기
		bX += dX[dB[M]];
		bY += dY[dB[M]];
		
		if(map[aY][aX] == 0 && map[bY][bX] == 0) { // A,B가 충전범위에 없는 경우
			chargerA[M] = 0;
			chargerB[M] = 0;
		}
		else if(map[aY][aX] != 0 && map[bY][bX] == 0) { // B만 충전범위에 없는 경우
			for (int i = 0; i < A; i++) {
				if((map[aY][aX] & 1<<i) != 0) {
					chargerA[M] = batteryC.get(i)[3];
					break;
				}
			}
			chargerB[M] = 0;
		}
		else if(map[aY][aX] == 0 && map[bY][bX] != 0) { // A만 충전범위에 없는 경우
			chargerA[M] = 0;
			for (int i = 0; i < A; i++) {
				if((map[bY][bX] & 1<<i) != 0) {
					chargerB[M] = batteryC.get(i)[3];
					break;
				}
			}
		}
		else if(map[aY][aX] != 0 && map[bY][bX] != 0) { // 둘 다 충전범위에 있는 경우
			if((map[aY][aX] & map[bY][bX]) == 0) { // 둘이 겹치는 것이 없다면
				for (int i = 0; i < A; i++) {
					if((map[aY][aX] & 1<<i) != 0) {
						chargerA[M] = batteryC.get(i)[3];
						break;
					}
				}
				for (int i = 0; i < A; i++) {
					if((map[bY][bX] & 1<<i) != 0) {
						chargerB[M] = batteryC.get(i)[3];
						break;
					}
				}
			}
			else { // 들이 겹치는 것이 있다면
				List<Integer> listA = new ArrayList<>();
				List<Integer> listB = new ArrayList<>();
				for (int i = 0; i < A; i++) {
					if((map[aY][aX] & 1<<i) != 0) listA.add(i);
					if((map[bY][bX] & 1<<i) != 0) listB.add(i);
				}
				
				if(listA.get(0) != listB.get(0)) {
					chargerA[M] = batteryC.get(listA.get(0))[3];
					chargerB[M] = batteryC.get(listB.get(0))[3];					
				}else {
					int tmp = batteryC.get(listA.get(0))[3];
					if(listA.size() > 1 && listB.size() > 1) {
						if(batteryC.get(listA.get(1))[3] > batteryC.get(listB.get(1))[3]) {
							chargerA[M] = batteryC.get(listA.get(1))[3];
							chargerB[M] = tmp;
						}else {
							chargerA[M] = tmp;
							chargerB[M] = batteryC.get(listB.get(1))[3];
						}
					}else if(listA.size() > 1) {
						chargerA[M] = batteryC.get(listA.get(1))[3];
						chargerB[M] = tmp;
					}else if(listB.size() > 1) {
						chargerA[M] = tmp;
						chargerB[M] = batteryC.get(listB.get(1))[3];
					}else {
						chargerA[M] = tmp/2;
						chargerB[M] = tmp/2;						
					}
				}
			}
		}
		move(M+1, aX, aY, bX, bY);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			map = new int[11][11]; // 지도 배열 생성
			st = new StringTokenizer(in.readLine(), " ");
			int M = Integer.parseInt(st.nextToken()); // 총 이동시간
			A = Integer.parseInt(st.nextToken()); // BC의 개수
			
			dA = new int[M+1]; // A 이동 정보
			dB = new int[M+1]; // B 이동 정보
			
			st = new StringTokenizer(in.readLine(), " ");
			for (int i = 1; i <= M; i++) { // A 이동 정보 입력
				dA[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(in.readLine(), " ");
			for (int i = 1; i <= M; i++) { // B 이동 정보 입력
				dB[i] = Integer.parseInt(st.nextToken());
			}
			
			batteryC = new ArrayList<int[]>();
			for (int i = 0; i < A; i++) { // BC 정보 입력
				st = new StringTokenizer(in.readLine(), " ");
				batteryC.add(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
			}
			
			Collections.sort(batteryC, new Comparator<int[]>() {
				@Override
				public int compare(int[] n1, int[] n2) {
					return n2[3] - n1[3]; // 처리량 기준 내림차순 정렬
				}
			});
			
			for (int i = 0; i < A; i++) { // BC기준으로 충전범위 마스킹
				markCoverage(i, batteryC.get(i)[0], batteryC.get(i)[1], batteryC.get(i)[2]);
//				System.out.println("---------비트마스킹 테스트---------");
//				for (int k = 1; k < 11; k++) {
//					for (int j = 1; j < 11; j++) {
//						System.out.print(map[k][j]+" ");
//					}
//					System.out.println("");
//				}
			}
			
			chargerA = new int[M+1]; // A 충전량 저장 배열
			chargerB = new int[M+1]; // B 충전량 저장 배열
			move(0, 1, 1, 10, 10);
			int sum = 0;
//			System.out.println(Arrays.toString(chargerA));
//			System.out.println(Arrays.toString(chargerB));
			for(int num : chargerA) sum += num;
			for(int num : chargerB) sum += num;
			sb.append(sum).append("\n");
		}
		out.write(sb.toString());
		out.flush();
		out.close();
	}
}

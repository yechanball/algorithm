package algorithm.swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_15170_낚시터자리잡기 {
	static int N; // 낚시터 자리수
	static int[] fishSpot; // 낚시터 자리에 앉은 사람 수
	static int[] gate = new int[4]; // 게이트 위치
	static int[] waitFicher = new int[4]; // 각 게이트에서 기다리는 낚시꾼 수
	static int[] entryOrder = new int[3]; // 입장 순서
	static int distSum, minDistSum; // 이동거리 합, 이동거리 합 최솟값
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(in.readLine()); // 테스트 케이스 입력
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			N = Integer.parseInt(in.readLine()); // 낚시터 자리수
			fishSpot = new int[N+1]; // 낚시터 자리에 앉은 사람 수
			gate = new int[4]; // 게이트 위치
			waitFicher = new int[4]; // 각 게이트에서 기다리는 낚시꾼 수
			for (int i = 1; i <= 3; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				gate[i] = Integer.parseInt(st.nextToken());
				waitFicher[i] = Integer.parseInt(st.nextToken());
			}
			
			minDistSum = Integer.MAX_VALUE;
			perm(0,0); // 입장 순서 순열 생성
			
			sb.append(minDistSum).append("\n");
		}
		out.write(sb.toString());
		out.flush();
		out.close();
	}
	
	public static void perm(int cnt, int bit) { // 비트마스킹을 활용한 순열
		if(cnt == 3) {
			Arrays.fill(fishSpot, 0);
			entry(); // 순서가 결정되면 입장 시작
			return;
		}
		
		for (int i = 0; i < 3; i++) {
			if( (bit & 1<<i) != 0 ) continue;
			entryOrder[cnt] = i+1;
			perm(cnt+1, bit | 1<<i);
		}
	}
	
	public static void entry() { // 낚시꾼 게이트 순서대로 입장
		int fisher, idx, i; // 낚시꾼 수, 출발 인덱스
		int cnt, sumL, sumR; // 왼쪽 우선 배치, 오른쪽 우선 배치
		distSum = 0;
		
		for (int num : entryOrder) {
			fisher = waitFicher[num];
			idx = gate[num];
			sumL = 0;
			sumR = 0;

			cnt = 0;
			i = 0;
			int[] leftPos = new int[fisher];
			while(cnt != fisher) {
				if(idx-i > 0 && fishSpot[idx-i] == 0) { // 왼쪽
					leftPos[cnt] = idx-i;
					sumL += (i+1);
					cnt++;
				}	
				if(cnt == fisher) break;
				if(i != 0 && idx+i <= N && fishSpot[idx+i] == 0) { // 오른쪽
					leftPos[cnt] = idx+i;
					sumL += (i+1);
					cnt++;
				}
				i++;
			}
		
			cnt = 0;
			i = 0;
			int[] rightPos = new int[fisher];
			while(cnt != fisher) {
				if(idx+i <= N && fishSpot[idx+i] == 0) { // 오른쪽
					rightPos[cnt] = idx+i;
					sumR += (i+1);
					cnt++;
				}
				if(cnt == fisher) break;
				if(i != 0 && idx-i > 0 && fishSpot[idx-i] == 0) { // 왼쪽
					rightPos[cnt] = idx-i;
					sumR += (i+1);
					cnt++;
				}	
				i++;
			}

			// 크기 비교해서 더욱 작은 값으로 배치
			if(sumL < sumR) {
				distSum += sumL;
				for (int pos : leftPos) {
					fishSpot[pos] = num;
				}
			}else {
				distSum += sumR;
				for (int pos : rightPos) {
					fishSpot[pos] = num;
				}
			}	
		}
		
//		System.out.println(distSum +" -> "+Arrays.toString(fishSpot));
		minDistSum = (distSum < minDistSum) ? distSum : minDistSum; // 이동거리 합 최솟값 갱신
	}
}

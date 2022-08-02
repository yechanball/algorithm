package algorithm.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1208_Flatten {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int[] box = new int[100];
		int dump, maxIdx, minIdx, diff;
		
		for (int testcase = 1; testcase <= 10; testcase++) {
			sb.append("#").append(testcase).append(" ");
			dump = Integer.parseInt(in.readLine());
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			for (int i = 0; i < 100; i++) {
				box[i] = Integer.parseInt(st.nextToken());
			}
			// 오름차순 정렬
			Arrays.sort(box);
			// 최솟값 최댓값 위치 지정
			minIdx = 0;
			maxIdx = 99;
			// 덤프 횟수만큼 덤프 시도
			for (int i = 0; i < dump; i++) {
				// 최솟값 위치 탐색
				for (int j = 0; j < 100; j++) {
					if(box[j]<box[minIdx]) {
						minIdx = j;
						break;
					}
				}
				// 최댓값 위치 탐색
				for (int j = 99; j >= 0; j--) {
					if(box[j]>box[maxIdx]) {
						maxIdx = j;
						break;
					}
				}
				// 덤프 진행
				box[minIdx]++;
				box[maxIdx]--;
			}
			// 오름차순 정렬
			Arrays.sort(box);
			// 차이 계산
			diff = box[99]-box[0];
			sb.append(diff).append("\n");
		}
		System.out.println(sb);
	}
}

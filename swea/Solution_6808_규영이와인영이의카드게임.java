package algorithm.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_6808_규영이와인영이의카드게임 {
	static int[] kyuCard = new int[9]; // 규영 카드
	static int[] inCard = new int[9]; // 인영 카드
	static int kyuWin; // 규영 이긴 횟수
	static int kyuLose;	// 규영 진 횟수
	
	public static void cardGame(int cnt, boolean[] inCardCheck, int kyuScore, int inScore) {
		if(cnt == 9) {
			if(kyuScore > inScore) kyuWin++;
			else if(kyuScore < inScore) kyuLose++;
		}else {
			for (int i = 0; i < 9; i++) {
				if(!inCardCheck[i]) {
					inCardCheck[i] = true; // 선택한 숫자 체크
					int sum = kyuCard[cnt] + inCard[i];
					if(kyuCard[cnt] > inCard[i]) cardGame(cnt+1, inCardCheck, kyuScore+sum, inScore); // 다음 재귀 호출 (규영이 이긴 경우)
					else if(kyuCard[cnt] < inCard[i]) cardGame(cnt+1, inCardCheck, kyuScore, inScore+sum); // 다음 재귀 호출 (인영이 이긴 경우)
					inCardCheck[i] = false; // 순열을 위해 선택한 숫자 체크 해제
				}
			}
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int[] card = new int[19];
			kyuWin = 0;
			kyuLose = 0;
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(in.readLine(), " ");
			for (int i = 0; i < 9; i++) { // 규영 카드 입력
				kyuCard[i] = Integer.parseInt(st.nextToken());
				card[kyuCard[i]] = 1; // 규영이 사용한 카드 기록
			}
			int cnt = 0;
			for (int i = 1; i <= 18; i++) { // 인영 카드 입력
				if(card[i] == 0) inCard[cnt++] = i;
			}
			boolean[] inCardCheck = new boolean[9]; // 인영 카드 사용 확인
			cardGame(0, inCardCheck, 0, 0);
			sb.append(kyuWin).append(" ").append(kyuLose).append("\n");
		}
		System.out.print(sb);
	}
}

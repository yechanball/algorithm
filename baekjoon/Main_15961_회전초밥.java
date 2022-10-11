package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_15961_회전초밥 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken()); // 접시 수
		int D = Integer.parseInt(st.nextToken()); // 초밥 가짓수
		int K = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시 수
		int C = Integer.parseInt(st.nextToken()); // 쿠폰 번호
		
		int[] belt = new int[N]; // 회전 초밥 벨트 상태
		int[] susi = new int[D+1]; // 각 번호에 해당하는 초밥을 먹고 있는지 체크하는 배열
		for (int i = 0; i < N; i++) {
			belt[i] = Integer.parseInt(in.readLine());
		}
				
		int start = 0; // 시작 위치
		int end = K-1; // 종료 위치
		int dish = 0; // 먹을 수 있는 초밥 가짓수
		for (int i = start; i <= end; i++) { // 시작 위치부터 연속해서 K개 고른 경우 초밥 가짓수 체크
			if(susi[belt[i]] == 0) dish++;
			susi[belt[i]]++;
		}

		int maxDish = (susi[C] == 0) ? dish+1 : dish; // 먹을 수 있는 초밥의 최대 가짓수 (쿠폰으로 받을 수 있는 초밥을 선택 안한 경우 가짓수 추가)

		while(start < N) { // 탐색 (시작 위치가 다시 처음으로 돌아가기 전까지 -> N번째 접시 시작까지 체크)
			if(susi[belt[start]] == 1) dish--; // 한 개만 선택되었던 초밥인 경우 가짓수 감소
			susi[belt[start++]]--; // 이전 시작 위치 초밥 제거
			
			if(++end == N) end = 0; // 마지막 위치 이동
			if(susi[belt[end]] == 0) dish++; // 한 번도 선택되지 않은 초밥인 경우 가짓수 증가
			susi[belt[end]]++; // 마지막 위치 초밥 추가
			
			
			maxDish = (susi[C] == 0) ? Math.max(dish+1, maxDish) : Math.max(dish, maxDish); // 최댓값 체크 (쿠폰으로 받을 수 있는 초밥을 선택 안한 경우 가짓수 추가)
		}
		
		out.write(Integer.toString(maxDish));
		out.flush();
		out.close();
	}
}

package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_20299_3대측정 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken()); // 신청한 동아리 수
		int S = Integer.parseInt(st.nextToken()); // 팀원 3명의 능력 합 가입 조건
		int M = Integer.parseInt(st.nextToken()); // 개인 능력치 가입 조건
		
		int cnt = 0; // 가입 가능한 동아리의 수
		int x1, x2, x3, total; // 동아리원 능력치와 능력치 합
		// 동아리 능력치 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			x1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			x3 = Integer.parseInt(st.nextToken());
			total = x1 + x2 + x3;
			
			if(x1 >= M && x2 >= M && x3 >= M && total >= S) { // 개인 능력치가 조건 이상이고 전체 합도 조건 이상인 경우
				cnt++; // 동아리 수 증가
				sb.append(x1).append(" ").append(x2).append(" ").append(x3).append(" ");
			}
		}
		// 결과 출력
		out.write(Integer.toString(cnt));
		out.append("\n");
		out.append(sb.toString());
		out.flush();
		out.close();
	}
}

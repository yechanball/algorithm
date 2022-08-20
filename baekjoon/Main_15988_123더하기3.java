package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_15988_123더하기3 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		long[] caseNum = new long[1_000_001]; // 메모이제이션 배열
		 // 점화식을 위해 1번째, 2번째, 3번째를 초기화
		caseNum[1] = 1;
		caseNum[2] = 2;
		caseNum[3] = 4;
		for (int i = 4; i <= 1_000_000; i++) {
			caseNum[i] = (caseNum[i-1] + caseNum[i-2] + caseNum[i-3]) % 1_000_000_009;
		}
		
		int T = Integer.parseInt(in.readLine()); // 테스트 케이스 개수
		for (int tc = 1; tc <= T; tc++) {
			sb.append(caseNum[Integer.parseInt(in.readLine())]).append("\n");
		}
		out.write(sb.toString());
		out.flush();
		out.close();
	}
}

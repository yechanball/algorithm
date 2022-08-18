package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class Main_1914_하노이탑 {
	static StringBuilder sb = new StringBuilder();
	static long cnt = 0;
	
	private static void hanoi(int N, int start, int temp, int end) {
		if(N==1) { // 원판이 한개만 남은 경우
			sb.append("\n").append(start).append(" ").append(end); // 원판을 start에서 end로 움직이기
			cnt++;
		}else {
			hanoi(N-1, start, end, temp); // start에 있던 N-1개를 end을 거쳐 temp로 움직이기
			sb.append("\n").append(start).append(" ").append(end); // N원판을 start에서 end로 움직이기
			cnt++;
			hanoi(N-1, temp, start, end); // temp에 있던 N-1개를 start을 거쳐 end로 움직이기			
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(in.readLine());
		if(N <= 20) { // N이 20과 같거나 작으면 과정 출력
			hanoi(N, 1, 2, 3); // 원판 개수, 시작, 임시, 최종 위치
			out.write(Long.toString(cnt));
			out.write(sb.toString());
		}else { // 원판이 N개인 경우 움직이는 횟수는 2^N - 1
			BigInteger answer = BigInteger.ONE;
			for (int i = 1; i <= N; i++) { // 2의 N제곱 구하기
				answer = answer.multiply(new BigInteger("2"));
			}
			answer = answer.subtract(BigInteger.ONE);
			out.write(answer.toString());
		}
		out.flush();
		out.close();
	}
}

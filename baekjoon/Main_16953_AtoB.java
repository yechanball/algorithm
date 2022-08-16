package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_16953_AtoB {
	static int minCnt = Integer.MAX_VALUE; // 최소 연산 시행 횟수
	
	private static void make(int A, int B, int cnt) {
		if(A == B) { // B를 A로 만든 경우 최소 횟수 비교 
			if(cnt < minCnt) minCnt = cnt;
		}else if(A > B){ // B가 A보다 작아지면 종료
			return;
		}else { // 연산 시행
			if(B%2 == 0) make(A, B/2, cnt+1); // 2로 나눌 수 있으면 2로 나누기
			else if(B%10 == 1) make(A, B/10, cnt+1); // 1이 수의 가장 오른쪽에 있는 경우 1 제거
			else return; // 두 연산이 불가능한 경우 종료
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		make(A, B, 1); // 연산 호출
		if(minCnt == Integer.MAX_VALUE) out.write("-1"); // 만들 수 없는 경우
		else out.write(Integer.toString(minCnt));
		out.flush();
		out.close();
	}
}

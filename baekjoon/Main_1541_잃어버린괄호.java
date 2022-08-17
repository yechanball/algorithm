package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1541_잃어버린괄호 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(in.readLine(), "-"); // -를 기준으로 문자열 나누기
		List<Integer> subSum = new ArrayList<Integer>();
		while(st.hasMoreTokens()) { // -를 기준으로 나눈 문자열 모두 탐색
			StringTokenizer subSt = new StringTokenizer(st.nextToken(), "+");
			int sum = 0;
			while(subSt.hasMoreTokens()) { // 부분 문자열의 합 계산
				sum += Integer.parseInt(subSt.nextToken());				
			}
			subSum.add(sum);
		}
		int result = subSum.get(0);
		for (int i = 1, size = subSum.size(); i < size; i++) {
			result -= subSum.get(i);
		}
		out.write(Integer.toString(result));
		out.flush();
		out.close();
	}
}

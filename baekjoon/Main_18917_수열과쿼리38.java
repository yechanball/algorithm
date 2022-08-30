package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_18917_수열과쿼리38 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(in.readLine()); // 쿼리의 수
		long sum = 0; // 모든 원소 총합
		long xor = 0; // 모든 원소를 XOR한 값		
		for (int i = 0; i < N; i++) {
			String input = in.readLine();
			int x;
			switch (input.charAt(0)) {
			case '1': // 1 X: 가장 뒤에 X를 추가
				st = new StringTokenizer(input, " ");
				st.nextToken();
				x = Integer.parseInt(st.nextToken());
				sum += x;
				xor ^= x;
				break;
			case '2': // 2 X: X를 제거(중복인 경우 가장 앞에 있는거 하나 제거)
				st = new StringTokenizer(input, " ");
				st.nextToken();
				x = Integer.parseInt(st.nextToken());
				sum -= x;
				xor ^= x;
				break;
			case '3': // 3: 모든 원소 더한 값 출력
				sb.append(sum).append("\n");				
				break;
			case '4': // 4: 모든 원소를 XOR한 값 출력				
				sb.append(xor).append("\n");
				break;
			}
		}
		out.write(sb.toString());
		out.flush();
		out.close();
	}
}

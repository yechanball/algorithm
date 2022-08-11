package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_3040_백설공주와일곱난쟁이 {
	static int[] miniMe = new int[9]; // 난쟁이 모자에 적힌 수 배열
	static int[] realMiniMe = new int[7]; // 리얼 일곱 난쟁이
	
	public static void combi(int cnt, int start, int sum, int flag) throws IOException {
		if(cnt == 7) {
			if(sum == 100) { // 일곱명 합이 100이면 출력후 종료
				BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
				StringBuilder sb = new StringBuilder();
				for (int i = 0; i < 7; i++) {
					sb.append(realMiniMe[i]).append("\n");
				}
				out.write(sb.toString());
				out.flush();
				out.close();
				return;
			}
		}else {
			for (int i = start; i < 9; i++) {
				if( (flag & 1<<i) != 0 ) continue; // 이미 마스킹되어 있으면 건너뛰기
				realMiniMe[cnt] = miniMe[i];
				combi(cnt+1, start+1, sum+miniMe[i], flag | 1<<i);
			}
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 9; i++) {
			miniMe[i] = Integer.parseInt(in.readLine());
		}
		combi(0, 0, 0, 0); // 일곱 난쟁이 찾기
	}
}

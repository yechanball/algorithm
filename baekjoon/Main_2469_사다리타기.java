package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2469_사다리타기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(in.readLine()); // 사다리 세로줄 개수
		int N = Integer.parseInt(in.readLine()); // 사다리 가로줄 입력 개수
		
		// 사다리 입력, 출력 설정
		int[] input = new int[K];
		int[] output = new int[K];
		String str = in.readLine();
		for (int i = 0; i < K; i++) {
			input[i] = i+1;
			output[i] = str.charAt(i) - 64;
		}
		
		// 현재 사다리 가로줄 입력
		String[] ladder = new String[N];
		int hiddenLine = 0;
		for (int i = 0; i < N; i++) {
			ladder[i] = in.readLine();
			if(ladder[i].charAt(0) == '?') {
				hiddenLine = i;
			}
		}
		
		// 사다리 타기: 위 -> 아래
		int tmp;
		for (int i = 0; i < hiddenLine; i++) {
			for (int k = 0; k < K-1; k++) {
				if(ladder[i].charAt(k) == '*') continue;
				tmp = input[k];
				input[k] = input[k+1];
				input[k+1] = tmp;
			}
		}
		
		// 사다리 타기: 아래 -> 위
		for (int i = N-1; i > hiddenLine; i--) {
			for (int k = 0; k < K-1; k++) {
				if(ladder[i].charAt(k) == '*') continue;
				tmp = output[k];
				output[k] = output[k+1];
				output[k+1] = tmp;
			}
		}
		
		// 감추어진 가로줄 생성
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < K-1; i++) {
			if(input[i] == output[i]) {
				sb.append("*");
				continue;
			}else {
				tmp = input[i];
				input[i] = input[i+1];
				input[i+1] = tmp;
				sb.append("-");
				i++;
				if(i < K-1) {
					sb.append("*");					
				}
			}
		}
		
		// 감추어진 가로줄로 실행했을 경우 값이 같은지 확인
		boolean isPossible = true;
		for (int i = 0; i < K; i++) {
			if(input[i] == output[i]) continue;
			else {
				isPossible = false;
				break;
			}
		}
		
		if(isPossible){
			System.out.print(sb.toString());
		}else {
			for (int i = 0; i < K-1; i++) {
				System.out.print("x");
			}
		}
	}
}

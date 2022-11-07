package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_16120_PPAP {
	public static void main(String[] args) throws IOException {
		String str = new BufferedReader(new InputStreamReader(System.in)).readLine();
		boolean isPPAP = true;
		if((str.length() - 1) % 3 != 0) { // 길이 조건 확인, PPAP 문자열의 길이: 첫째항이 1이고, 공차가 3인 등차수열
			isPPAP = false;
		}else if(!(str.length() == 1 && str.equals("P"))) { // 문자열 크기가 1이고 P인 경우를 제외한 경우 탐색
			while(true) { // 순차적으로 변환하며 PPAP 문자열 확인
				if(!str.contains("PPAP")) { // 문자열에 PPAP가 포함되지 않은 경우 -> false, 종료
					isPPAP = false;
					break;
				}
				if(str.equals("PPAP")) break; // 문자열이 PPAP와 일치하는 경우 -> true, 종료
				str = str.replaceAll("PPAP", "P"); // PPAP 부분문자열을 P로 치환
			}
		}
		System.out.print((isPPAP) ? "PPAP" : "NP");
	}
}
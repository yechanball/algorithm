package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_12891_DNA비밀번호 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		
		int S = Integer.parseInt(st.nextToken()); // 전체 문자열 길이
		int T = Integer.parseInt(st.nextToken()); // 부분 문자열 길이
		char[] dna = new char[] {'A', 'C', 'G', 'T'}; // DNA 문자
		String input = in.readLine(); // 문자열 입력
		st = new StringTokenizer(in.readLine(), " ");
		int[] dnaNow = new int[4];
		int[] dnaNeed = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())}; // 필요 DNA 개수
		boolean isCollect = true;
		int answer = 0;
		
		for (int i = 0; i <= (S-T); i++) {
			if(i == 0) {
				for (int j = 0; j < T; j++) { // 첫 부분 문자열 문자의 개수 세기
					for (int k = 0; k < 4; k++) {
						if(input.charAt(j) == dna[k]) {
							dnaNow[k]++;
							break;
						}
					}
				}				
			}
			else {
				isCollect = true;
				for (int j = 0; j < 4; j++) { // 이전 문자 개수 줄이기
					if(input.charAt(i-1) == dna[j]) {
						dnaNow[j]--;
						break;
					}
				}
				for (int j = 0; j < 4; j++) { // 뒤에 추가되는 문자 개수 추가하기
					if(input.charAt(i-1+T) == dna[j]) {
						dnaNow[j]++;
						break;
					}
				}	
			}
			
			for (int j = 0; j < 4; j++) { // 필요 문자 개수와 비교하기
				if(dnaNow[j] < dnaNeed[j]) {
					isCollect = false;
					break;
				}
			}
			if(isCollect) answer++;
		}
		
		System.out.print(answer);	
	}
}

package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_1747_소수팰린드롬 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(in.readLine());
		boolean[] isComposite = new boolean[1_003_002]; // 1,000,000 이상인 소수 & 팰린드롬수는 1,003,001 이므로 배열크기를 1,003,002로 설정
		
		boolean isPalindrome;
		int answer = 0, left, right, cnt = 0;
		isComposite[1] = true;
		for(int i = 1; i <= 1_003_001; i++) {
			if(!isComposite[i]) { // 소수 체크
				cnt = 2;
				while(i*cnt <= 1_003_001) { // 소수의 배수 제거
					isComposite[i*cnt] = true;
					cnt++;
				}
				if(i >= N) { // N보다 큰 소수에 대해서 팰린드롬인지 검사
					String number = Integer.toString(i);
					isPalindrome = true;
					left = 0;
					right = number.length()-1;
					for (int j = 0, halfLen = number.length()/2; j < halfLen; j++) {
						if(number.charAt(left+j) != number.charAt(right-j) ) {
							isPalindrome = false;
							break;
						}
					}
					if(isPalindrome) { // 소수이면서 팰린드롬수를 만족하면 종료
						answer = i;
						break;
					}
				}
			}
		}
		
		out.write(Integer.toString(answer));
		out.flush();
		out.close();
	}
}

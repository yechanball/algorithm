package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_14916_거스름돈 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(in.readLine());
		int two = 0, five = N/5; // 2원 동전 수, 5원 동전 수
		int min = Integer.MAX_VALUE; // 동전 최소 개수
		int remain;
		
		while(five*5 >= 0) {
			remain = N - (five*5); // 5원 동전을 사용한 금액 제외하고 나머지
			if( remain%2 == 0 ) { // 나머지가 2원 동전으로 채울 수 있는지 확인
				two = remain/2;
				min = five + two; // 5원 동전 수와 2원 동전수의 합이 최솟값
				break;
			}
			five--;
		}
		
		if(min == Integer.MAX_VALUE) out.write("-1");
		else out.write(Integer.toString(min));
		out.flush();
		out.close();
	}
}
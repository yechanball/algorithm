package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_2839_설탕배달 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(in.readLine());
		int three = 0, five = N/5; // 3킬로 봉지수와 5킬로 봉지수
		int min = Integer.MAX_VALUE; // 봉지 최소 개수
		int remain;
		
		while(five*5 >= 0) {
			remain = N - (five*5); // 5킬로 봉지를 제외하고 나머지
			if( remain%3 == 0 ) { // 나머지가 3킬로 봉지로 채울 수 있는지 확인
				three = remain/3;
				min = five + three; // 5킬로 봉지와 3킬로 봉지의 합이 최솟값
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

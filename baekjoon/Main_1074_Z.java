package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_1074_Z {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		// 현재 배열 사이즈 2^N, 순서는 0 ~ 2^(N+1)-1번
		int currSize = (int) Math.pow(2, N);
		int startCnt = 0;
		int range;
		
		while(currSize > 2) { // 2x2 배열이 될때까지 쪼개기
			currSize /= 2; // 사이즈 1/2씩 감소
			range = currSize*currSize; // 값 범위
			
			if(r < currSize && c < currSize ) continue; // 좌상단 영역
			else if(r < currSize && c >= currSize ) { // 우상단 영역
				startCnt += range;
				c -= currSize;
			}
			else if(r >= currSize && c < currSize ) { // 좌하단 영역
				startCnt += range*2;
				r -= currSize;
			}
			else { // 우하단 영역
				startCnt += range*3;
				r -= currSize;
				c -= currSize;
			}
		}
		
		if(r == 0 && c == 0 ) out.write(Integer.toString(startCnt)); // 좌상
		else if(r == 0 && c == 1 ) out.write(Integer.toString(startCnt+1)); // 우상
		else if(r == 1 && c == 0 ) out.write(Integer.toString(startCnt+2)); // 좌하
		else out.write(Integer.toString(startCnt+3)); // 우하
		out.flush();
		out.close();
	}
}

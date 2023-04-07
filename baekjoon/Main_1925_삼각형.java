package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1925_삼각형 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());		
		int x1 = Integer.parseInt(st.nextToken());
		int y1 = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(in.readLine());		
		int x2 = Integer.parseInt(st.nextToken());
		int y2 = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(in.readLine());		
		int x3 = Integer.parseInt(st.nextToken());
		int y3 = Integer.parseInt(st.nextToken());
		
		if((y2 - y1) * (x3 - x2) == (y3 - y2) * (x2 - x1)) System.out.print("X");
		else {
			int[] len = new int[3];
			len[0] = dist(x1, y1, x2, y2);
			len[1] = dist(x2, y2, x3, y3);
			len[2] = dist(x3, y3, x1, y1);
			
			if(len[0] == len[1] && len[1] == len[2]) System.out.print("JungTriangle");
			else {
				Arrays.sort(len);
				
				if(len[0] == len[1] || len[1] == len[2] || len[2] == len[0]) {
					if(len[0] + len[1] < len[2]) System.out.print("Dunkak2Triangle");
					else if(len[0] + len[1] == len[2]) System.out.print("Jikkak2Triangle");
					else System.out.print("Yeahkak2Triangle");
				}else {
					if(len[0] + len[1] < len[2]) System.out.print("DunkakTriangle");
					else if(len[0] + len[1] == len[2]) System.out.print("JikkakTriangle");
					else System.out.print("YeahkakTriangle");
				}
			}
		}
	}
	
	public static int dist(int x1, int y1, int x2, int y2) {
		return (x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1);
	}
}

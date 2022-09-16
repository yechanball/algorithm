package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_1002_터렛 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(in.readLine()); // 테스트케이스 개수
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(in.readLine(), " ");
			// 원1 -> 중심 (x1,y1) 반지름 r1 
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int r1 = Integer.parseInt(st.nextToken());
			// 원2 -> 중심 (x2,y2) 반지름 r2 
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			
			// 소수점 비교가 어려움으로 제곱근대신 제곱상태로 비교
			int distance = (x1-x2)*(x1-x2) + (y1-y2)*(y1-y2); // 두 원 중심거리 제곱
			int rDifPow = (r1-r2)*(r1-r2); // 두 반지름의 차 제곱
			int rSumPow = (r1+r2)*(r1+r2); // 두 반지름의 합 제곱
			
			if(x1 == x2 && y1 == y2 && r1 == r2) { // 두원의 중심 좌표가 같고 반지름이 같은 동심원인 경우 -> 교점이 무한대
				sb.append("-1").append("\n");
			}else if(distance > rDifPow && distance < rSumPow) { // 두 원의 교점이 2개일 경우 : R - r < d < R + r
				sb.append("2").append("\n");
			}else if(distance == rDifPow || distance == rSumPow) { // 두 원의 교점이 1개일 경우 : d = R - r 또는 d = R + r
				sb.append("1").append("\n");				
			}else { // 두 원의 교점이 없는 경우 : d < R - r 또는 d > R + r
				sb.append("0").append("\n");								
			}
		}
		
		out.write(sb.toString());
		out.flush();
		out.close();
	}
}

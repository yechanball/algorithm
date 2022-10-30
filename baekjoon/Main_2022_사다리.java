package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2022_사다리 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		double x = Double.parseDouble(st.nextToken());
		double y = Double.parseDouble(st.nextToken());
		double c = Double.parseDouble(st.nextToken());
		
		// 두 빌딩 사이 거리 : d
		// 왼쪽 높이 : hx = root(x^2 - d^2), 오른쪽 높이 : hy = root(y^2 - d^2)
		// 교차 지점 높이 : c = (hx * hy) / (hx + hy)
		double left = 0; // 왼쪽 포인터
		double right = (x < y) ? x : y; // 오른쪽 포인터
		double diff = 0.001; // 오차 범위
		
		// 이분 탐색
		while(right - left >= diff) { // 오른쪽 포인터가 항상 왼쪽보다 오른쪽에 있을때만 탐색
			double mid = (left + right)/2; // 두 빌딩사이 거리 가정
			double hx = Math.sqrt(x*x - mid*mid);
			double hy = Math.sqrt(y*y - mid*mid);
			double pridictC = (hx*hy)/(hx+hy); // 예측한 교차 높이
			if(c < pridictC) { // 예측한 교차 높이가 원래 교차 높이보다 높은 경우 -> 두 사이 거리가 더욱 멀어져야 함
				left = mid;
			}else { // 낮은 경우는 두 사이 거리를 가깝게
				right = mid;
			}
		}
		
		System.out.print(String.format("%.3f", right));
	}
}

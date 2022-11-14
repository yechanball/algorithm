package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_7869_두원 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		
		double x1 = Double.parseDouble(st.nextToken());
		double y1 = Double.parseDouble(st.nextToken());
		double r1 = Double.parseDouble(st.nextToken());
		double x2 = Double.parseDouble(st.nextToken());
		double y2 = Double.parseDouble(st.nextToken());
		double r2 = Double.parseDouble(st.nextToken());
		
		double d = Math.sqrt((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1)); // 두 원 중심거리
		double area = 0; // 두 원이 겹치는 영역 넓이
		
		if(r1+r2 <= d) { // 두 원이 겹치지 않는 경우 -> 넓이: 0
			area = 0;
		}else if(Math.abs(r2-r1) >= d) { // 한 원이 다른 원 내부에 있는 경우 -> 넓이: 작은 원 넓이
			double rMin = Math.min(r1, r2);
			area = Math.PI * rMin * rMin; // S = Pi * r^2
		}else { // 두 원의 교점이 2개인 경우 -> 넓이: 겹치는 영역(부채꼴 - 삼각형)
			// 중심각 : theta1, theta2
			double theta1 = Math.acos((r1*r1 + d*d - r2*r2)/(2*r1*d))*2;
			double theta2 = Math.acos((r2*r2 + d*d - r1*r1)/(2*r2*d))*2;
			// 겹치는 영역 넓이 : 부채꼴 넓이 - 삼각형 넓이
			area = (r1*r1*theta1 - r1*r1*Math.sin(theta1) + r2*r2*theta2 - r2*r2*Math.sin(theta2))/2;
		}
		
		System.out.print((area == 0) ? "0.000" : Math.round(area*1000)/1000.0); // 넓이 소수점 셋째자리까지 출력
	}
}
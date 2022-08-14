package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2869_달팽이는올라가고싶다 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int A = Integer.parseInt(st.nextToken()); // 낮에 올라가는 높이
		int B = Integer.parseInt(st.nextToken()); // 밤에 내려가는 높이
		int V = Integer.parseInt(st.nextToken()); // 올라가야할 높이
		double oneDayUp = A - B; // 하루에 올라갈 수 있는 높이
		double day = Math.ceil((V-A)/oneDayUp)+1; // 마지막날 한번에 올라갈 수 있는 높이를 제외하고 올라가는데 걸리는 날짜 계산
		System.out.print((int)day);
	}
}

package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_26068_치킨댄스를추는곰곰이를본임스2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int answer = 0;
		int N = Integer.parseInt(in.readLine());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), "-");
			String tmp = st.nextToken();
			int day = Integer.parseInt(st.nextToken());
			if(day <= 90) answer++;
		}
		System.out.print(answer);
	}
}

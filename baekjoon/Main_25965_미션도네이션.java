package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_25965_미션도네이션 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(in.readLine());
		for (int n = 0; n < N; n++) {
			int M = Integer.parseInt(in.readLine());
			long[][] dona = new long[M][3];
			for (int m = 0; m < M; m++) {
				st = new StringTokenizer(in.readLine(), " ");
				dona[m][0] = Long.parseLong(st.nextToken());
				dona[m][1] = Long.parseLong(st.nextToken());
				dona[m][2] = Long.parseLong(st.nextToken());
			}
			
			st = new StringTokenizer(in.readLine(), " ");
			long k = Long.parseLong(st.nextToken());
			long d = Long.parseLong(st.nextToken());
			long a = Long.parseLong(st.nextToken());
			
			long money = 0;
			for (int m = 0; m < M; m++) {
				long missionMoney = dona[m][0] * k - dona[m][1] * d + dona[m][2] * a;
				if(missionMoney > 0) {
					money += missionMoney;
				}
			}
			
			sb.append(money).append("\n");
		}
		
		out.write(sb.toString());
		out.flush();
		out.close();
	}
}
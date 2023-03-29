package algorithm.baekjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_26145_출제비재분배 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int NM = N + M;
		
		int[] money = new int[NM];
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			money[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < NM; j++) {
				int tmpMoney = Integer.parseInt(st.nextToken());
				money[i] -= tmpMoney;
				money[j] += tmpMoney;
			}
		}
		
		for (int i = 0; i < NM; i++) {
			sb.append(money[i] + " ");
		}
		out.write(sb.toString());
		out.flush();
		out.close();
	}
}

/*
[입력 1]
3 2
200 400 100
0 40 30 10 20
60 0 50 20 40
0 10 0 30 40

[출력 1]
160 280 100 60 100

*/

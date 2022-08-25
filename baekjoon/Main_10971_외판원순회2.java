package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_10971_외판원순회2 {
	static int N; // 도시 개수
	static int[][] money; // 도시간 이동 비용 행렬
	static boolean[] visited; // 도시 방문 체크
	static long minMoney = Long.MAX_VALUE; // 도시 순회 최소 비용
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(in.readLine());
		money = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < N; j++) {
				money[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visited = new boolean[N];
		visited[0] = true;
		travelCity(0, 0, 0); // 0번 도시를 시작점으로 모든 도시 순회하기
		
		out.write(Long.toString(minMoney));
		out.flush();
		out.close();
	}
	
	public static void travelCity(int city, int sumMoney, int visitCnt) { // 도시 번호, 비용, 방문 도시 개수
		if(visitCnt == N-1) { // N개의 도시를 전부 순회한 경우
			if(money[city][0] != 0) { // 마지막 도시에서 시작도시로 오는 길이 있다면
				sumMoney += money[city][0]; // 마지막 도시에서 처음 도시로 돌아오기
				if(sumMoney < minMoney) { // 현재 비용이 최소 비용보다 적은 경우
					minMoney = sumMoney;
				}				
			}
			return;
		}
		
		if(sumMoney >= minMoney) return;
		
		for (int i = 0; i < N; i++) {
			if(money[city][i] != 0 && !visited[i]) { // city -> i로 가는 길이 있고, i 도시를 방문하지 않은 경우
				visited[i] = true;
				travelCity(i, sumMoney + money[city][i], visitCnt+1);
				visited[i] = false;
			}
		}		
	}
}

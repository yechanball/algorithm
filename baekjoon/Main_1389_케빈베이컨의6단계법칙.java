package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_1389_케빈베이컨의6단계법칙 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] relation = new int[N+1][N+1];
		for (int i = 0; i <= N; i++) {
			for (int j = 0; j <= N; j++) {
				relation[i][j] = Integer.MAX_VALUE;
			}
		}
		
		int from, to;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			 // 주어진 초기 친구 관계 1단계
			relation[from][to] = 1; 
			relation[to][from] = 1;
		}
		
		// 플로이드-워셜 알고리즘
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if(i == j || i == k || j == k) continue;
					
					if(relation[i][k] == Integer.MAX_VALUE || relation[k][j] == Integer.MAX_VALUE) continue;
					
					if(relation[i][j] > relation[i][k] + relation[k][j]) {
						relation[i][j] = relation[i][k] + relation[k][j];
						relation[j][i] = relation[i][k] + relation[k][j];
					}
				}
			}
		}

		int minPerson = 0;
		int minKevinBaconNum = Integer.MAX_VALUE;
		
		for (int i = 1; i <= N; i++) {
			int kevinBaconNum = 0;
			for (int j = 1; j <= N; j++) {
				if(relation[i][j] == Integer.MAX_VALUE) continue;
				kevinBaconNum += relation[i][j];
			}
			
			if(kevinBaconNum == minKevinBaconNum) { // 친구 단계가 같다면 번호 작은 것으로 갱신
				minPerson = Math.min(i, minPerson);
			}else if(kevinBaconNum < minKevinBaconNum) { // 친구 단계가 작으면 번호 갱신
				minKevinBaconNum = kevinBaconNum;
				minPerson = i;
			}
		}
		
		System.out.print(minPerson);
	}
}

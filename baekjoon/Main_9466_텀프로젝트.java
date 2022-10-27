package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_9466_텀프로젝트 {
	static int[] student;
	static boolean[] team;
	static boolean[] visited;
	static int notTeam;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(in.readLine());
			student = new int[N+1];
			team = new boolean[N+1];
			notTeam = N;
			
			st = new StringTokenizer(in.readLine(), " ");
			for (int i = 1; i <= N; i++) {
				student[i] = Integer.parseInt(st.nextToken());
				if(student[i] == i) { // 자기 자신을 가리키는 경우 바로 팀으로 선택
					team[i] = true;
					notTeam--;
				}
			}
			
			visited = new boolean[N+1];
			for (int i = 1; i <= N; i++) {
				if(team[i]) continue; // 이미 팀으로 설정된 경우 탐색 X	
				dfs(i);
			}
			sb.append(notTeam).append("\n");
		}
		out.write(sb.toString());
		out.flush();
		out.close();
	}
	
	public static void dfs(int now) {
		if (visited[now]) { // 이미 방문한 경우
			team[now] = true; // 팀 설정
			notTeam--;
		}else {
			visited[now] = true;	
		}
		
		int next = student[now];
		if(!team[next]) { // 다음이 아직 팀이 설정되지 않은 경우 탐색
			dfs(next);
		}
			
		visited[now] = false; // 방문 체크 해제
		team[now] = true;
	}
}

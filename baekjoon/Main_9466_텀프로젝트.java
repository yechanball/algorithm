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
	static boolean isTeam;
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
				if(team[i]) continue; // 이미 팀으로 선택된 경우 탐색 X				
				isTeam = false;
				dfs(i, i);
			}
			sb.append(notTeam).append("\n");
		}
		out.write(sb.toString());
		out.flush();
		out.close();
	}
	
	public static void dfs(int start, int now) {
		if (team[now]) { // 이미 팀으로 선택된 학생을 탐색하는 경우 종료
			isTeam = false;
			return;
		}
		else {
			visited[now] = true;
			int next = student[now];
			
			if(next == start) { // 번호를 따라 연결했을때 자기 자신으로 돌아오는 경우 -> true 반환
				isTeam = true;
				team[now] = true;
				notTeam--;
				return;
			}else {
				dfs(start, next);			
			}
			
			if(isTeam) { // 팀으로 만들 수 있다면 팀 선택
				team[now] = true;
				notTeam--;
			}			
		}
	}
}

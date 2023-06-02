package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_9328_열쇠 {
	static class Pos {
		int r, c;
    
		public Pos(int r, int c){
			this.r = r;
			this.c = c;
		}
	}

	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(in.readLine());
		for(int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int h = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			char[][] map = new char[h+2][w+2];
			Arrays.fill(map[0], '.');
			for(int i = 1; i <= h; i++){
				String input = in.readLine();
				map[i][0] = '.';
				for(int j = 1; j <= w; j++){
					map[i][j] = input.charAt(j-1);
				}
				map[i][w+1] = '.';
			}
			Arrays.fill(map[h+1], '.');

			boolean[] key = new boolean[26];
			String inputKey = in.readLine();
			if(!inputKey.equals("0")) {
				for(int i = 0, len = inputKey.length(); i < len; i++) {
					int idx = inputKey.charAt(i) -'a';
					key[idx] = true;
				}
			}

			int maxCnt = bfs(map, h, w, key);
			sb.append(maxCnt + "\n");
		}
		out.write(sb.toString());
		out.flush();
		out.close();
	}

	public static int bfs(char[][] map, int h, int w, boolean[] key) {
		Queue<Pos> que = new ArrayDeque<>();
		que.offer(new Pos(0, 0));

		boolean[][] visited = new boolean[h+2][w+2];
		visited[0][0] = true;

		List<Pos>[] door = new ArrayList[26];
		for(int i = 0; i < 26; i++) {
			door[i] = new ArrayList<>();
		}

		int cnt = 0;
		while(!que.isEmpty()) {
			Pos curr = que.poll();

			for(int d = 0; d < 4; d++) {
				int nr = curr.r + dr[d];
				int nc = curr.c + dc[d];

				if(nr < 0 || nr > h+1 || nc < 0 || nc > w+1 || visited[nr][nc] || map[nr][nc] == '*') continue;

				if(Character.isUpperCase(map[nr][nc])){
					int idx = map[nr][nc] - 'A';
					if(key[idx]) {
						map[nr][nc] = '.';
						visited[nr][nc] = true;
						que.add(new Pos(nr, nc));
					}else door[idx].add(new Pos(nr, nc));
				}else {
					if(Character.isLowerCase(map[nr][nc])){
						int idx = map[nr][nc] - 'a';
						key[idx] = true;

						for(Pos pos : door[idx]){
							if(visited[pos.r][pos.c]) continue;
							map[pos.r][pos.c] ='.';
							visited[pos.r][pos.c] = true;
							que.add(new Pos(pos.r, pos.c));
						}
					}
					if(map[nr][nc] == '$') cnt++;
					visited[nr][nc] = true;
					que.add(new Pos(nr, nc));
				}
			}
		}

		return cnt;
	}
}

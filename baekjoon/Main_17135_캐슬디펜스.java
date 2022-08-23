package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main_17135_캐슬디펜스 {
	static int N, M, D; // 행과 열 크기, 궁수의 공격 거리 제한
	static int[][] originMap; // 첫 입력 받은 위치
	static List<Enemy> enemyList = new ArrayList<Enemy>(); // 적 위치 정보 리스트
	static int[] archPosition; // 궁수
	static int maxKill = 0; // 궁수의 공격으로 제거할 수 있는 적의 최대 수
	
	public static class Enemy {
		int r; // 행
		int c; // 열
		int d; // 궁수 거리
		
		public Enemy(int r, int c, int d) {
			super();
			this.r = r;
			this.c = c;
			this.d = d;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		// N, M, D 값 입력
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		// 격자판 상태 입력, 궁수 위치 고려해서 N+1행으로 생성
		originMap = new int[N+1][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < M; j++) {
				originMap[i][j] = Integer.parseInt(st.nextToken());
				if (originMap[i][j] == 1) { // 적인 경우
					enemyList.add(new Enemy(i, j, -1));	// 궁수 거리는 초기에 -1로 초기화				
				}
			}
		}
		// 궁수 배치 생성 -> 게임 시작 -> 적 제거 수 계산 -> 최댓값 찾기
		archPosition = new int[3];
		setArcher(0, 0);
		
		// 출력
		out.write(Integer.toString(maxKill));
		out.flush();
		out.close();
	}
	
	public static void setArcher(int cnt, int start) { // 궁수 배치 조합  mC3 -> M개의 열 중에 3자리 배치
		if(cnt == 3) { // 궁수 3명을 배치 완료하면
			startGame(); // 게임 시작
			return;
		}
		for (int i = start; i < M; i++) {
			archPosition[cnt] = i;
			setArcher(cnt+1, i+1);
		}
	}
	
	public static void startGame() {
		// 원래 맵을 게임에서 사용할 맵으로 복사
		int[][] map = new int[N][M];
		mapCopyTo(map);
		
		int turn = 0; // 턴수
		Deque<Enemy> q = new ArrayDeque<Enemy>(); // 적들의 정보를 저장할 큐
		
		while(!q.isEmpty()) { // 모든 적이 사라질때까지 반복
			turn++; // 턴수 하나 늘리기
			
			// kill
			// while 반복으로 적들이 전부 없어질때까지 반복
			// 반복문 안 순서 : 궁수 공격 -> 탈출조건 체크 -> 적 이동 -> 탈출조건 체크
			
		}		
		
		// 반복 종료되면 kill과 maxkill 비교
		
	}
	
	
	public static int calcDist(int r1, int c1, int r2, int c2) { // 두 위치 사이 거리 계산 후 거리 반환
		return Math.abs(r1-r2) + Math.abs(c1-c2);
	}
	
	public static void mapCopyTo(int[][] map) {
		for (int i = 0; i < N; i++) {
			map[i] = Arrays.copyOf(originMap[i], M);
		}
	}
}

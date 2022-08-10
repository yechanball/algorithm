package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16927_배열돌리기2 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		Queue<Integer> queue = new ArrayDeque<>();
		int range = Math.min(N, M)/2; 
		for (int i = 0; i < range; i++) {
			for (int j = i; j < M-i; j++) queue.offer(arr[i][j]);  // 상단 행 읽기
			for (int j = i+1; j < N-i; j++) queue.offer(arr[j][M-i-1]); // 오른쪽 열 읽기
			for (int j = M-i-2; j >= i; j--) queue.offer(arr[N-i-1][j]); // 하단 행 읽기
			for (int j = N-i-2; j > i; j--) queue.offer(arr[j][i]); // 왼쪽 열 읽기
			
			int cycle = R%queue.size();
			for (int r = 1; r <= cycle; r++) { // 회전 연산 반복, 한칸씩 밀기
				queue.offer(queue.poll());
			}
			
			for (int j = i; j < M-i; j++) arr[i][j] = queue.poll();  // 상단 행 입력
			for (int j = i+1; j < N-i; j++) arr[j][M-i-1] = queue.poll(); // 오른쪽 열 입력
			for (int j = M-i-2; j >= i; j--) arr[N-i-1][j] = queue.poll(); // 하단 행 입력
			for (int j = N-i-2; j > i; j--) arr[j][i] = queue.poll(); // 왼쪽 열 입력			
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		out.write(sb.toString());
		out.flush();
		out.close();
	}
}

package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2042_구간합구하기 {
	static long[] input;
	static long[] tree;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		input = new long[N+1];
		for (int i = 1; i <= N; i++) {
			input[i] = Long.parseLong(in.readLine());
		}
		
		tree = new long[N*4];
		init(1, N, 1); // 세그먼트 트리는 1번부터 시작

		for (int i = 0; i < M+K; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Long.parseLong(st.nextToken());
			
			if(a == 1) { // 갱신
				long diff = c - input[b];
				input[b] = c;
				update(1, N, 1, b, diff);
			}else { // 구간합 출력
				sb.append(sum(1, N, 1, b, (int)c)).append("\n");
			}
		}
		System.out.print(sb.toString());
	}
	
	public static long init(int start, int end, int nodeNum) { // 세그먼트 트리 초기화
		if(start == end) return tree[nodeNum] = input[start];
		
		int mid = (start + end) / 2;
		return tree[nodeNum] = init(start, mid, nodeNum * 2) + init(mid+1, end, nodeNum * 2 + 1);
	}
	
	public static long sum(int start, int end, int nodeNum, int left, int right) { // 세그먼트 트리 구간합 계산
		if(right < start || left > end) return 0; // 범위 밖에 있는 경우
		if(left <= start && end <= right) return tree[nodeNum]; // 범위 안에 있는 경우
		
		int mid = (start + end) / 2;
		return sum(start, mid, nodeNum * 2, left, right) + sum(mid+1, end, nodeNum * 2 + 1, left, right);
	}
	
	public static void update(int start, int end, int nodeNum, int index, long diff) { // 세그먼트 트리 갱신
		if(index < start || index > end) return; // 범위 밖에 있는 경우
		
		tree[nodeNum] += diff;
		if(start == end) return;
		
		int mid = (start + end) / 2;
		update(start, mid, nodeNum * 2, index, diff);
		update(mid+1, end, nodeNum * 2 + 1, index, diff);
	}
}

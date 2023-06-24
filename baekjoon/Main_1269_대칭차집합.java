package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main_1269_대칭차집합 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int cntA = Integer.parseInt(st.nextToken());
		int cntB = Integer.parseInt(st.nextToken());
		
		HashSet<Integer> A = new HashSet<>();
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < cntA; i++) {
			A.add(Integer.parseInt(st.nextToken()));
		}
		
		int cntIS = 0;
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < cntB; i++) {
			if(A.contains(Integer.parseInt(st.nextToken()))) cntIS++;
		}
		
		int ans = cntA + cntB - cntIS*2;
		System.out.println(ans);
	}
}

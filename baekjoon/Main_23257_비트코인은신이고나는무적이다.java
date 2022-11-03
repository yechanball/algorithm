package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_23257_비트코인은신이고나는무적이다 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); // 이전 월봉의 수
		int M = Integer.parseInt(st.nextToken()); // 뽑아야하는 월봉의 수
		
		Set<Integer> A = new HashSet<Integer>();
		Set<Integer> result = new HashSet<Integer>();
		
		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < N; i++) { // 이전 월봉들 A1~An 입력
			int input = Math.abs(Integer.parseInt(st.nextToken()));
			A.add(input);
			result.add(input);
		}
		
		for (int t = 0; t < M-1; t++) { // M-1번 XOR 연산 진행
			Set<Integer> tmp = new HashSet<Integer>();
		    tmp.addAll(result);
		    result.removeAll(result);
		    
		    Iterator<Integer> iter1 = A.iterator();
		    while(iter1.hasNext()) {
		    	int num1 = iter1.next();
		    	
		    	Iterator<Integer> iter2 = tmp.iterator();
			    while(iter2.hasNext()) {
			    	result.add(num1 ^ iter2.next());
			    }
		    }
		}
		
		int nextA = 0; // 다음 월봉 예측값(=결과의 최댓값)
		Iterator<Integer> iter = result.iterator();
	    while(iter.hasNext()) {
	    	nextA = Math.max(iter.next(), nextA);
	    }
		
	    System.out.print(nextA);
	}
}

package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_24416_알고리즘수업피보나치수1 {
	static int recursionCnt = 0, dpCnt = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		fib(n);
		fibonacci(n);
		System.out.print(recursionCnt + " " + dpCnt);
	}
	
	private static int fib(int n) {
		if(n == 1 || n == 2) {
			recursionCnt++;
			return 1;
		}
		else return (fib(n - 1) + fib(n - 2));
	}
	
	private static int fibonacci(int n) {
		int[] f = new int[n + 1];
		f[1] = 1;
		f[2] = 1;		
		for (int i = 3; i <= n; i++) {
			dpCnt++;
			f[i] = f[i - 1] + f[i - 2];
		}
		return f[n];
	}
}

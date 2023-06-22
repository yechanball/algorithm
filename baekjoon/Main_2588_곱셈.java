package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2588_곱셈 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int num1 = Integer.parseInt(in.readLine());
		int num2 = Integer.parseInt(in.readLine());
		
		System.out.println(num1 * (num2%10));
		System.out.println(num1 * (num2%100/10));
		System.out.println(num1 * (num2/100));
		System.out.println(num1 * num2);
	}
}

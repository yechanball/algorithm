package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_10773_제로 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(in.readLine());
		ArrayList<Integer> list = new ArrayList<>();
		int num;
		for (int i = 0; i < K; i++) {
			num = Integer.parseInt(in.readLine());
			if(num != 0) list.add(num);
			else list.remove(list.size()-1);
		}
		int sum = 0;
		for(int i : list) sum += i;
		System.out.print(sum);
	}
}

package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main_3052_나머지 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < 10; i++) {
			set.add(Integer.parseInt(in.readLine())%42);
		}
		System.out.print(set.size());
	}
}

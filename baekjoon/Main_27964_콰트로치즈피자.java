package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main_27964_콰트로치즈피자 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		HashSet<String> toppings = new HashSet<>();
		for (int i = 0; i < N; i++) {
			String topping = st.nextToken();
			
			if(topping.endsWith("Cheese")) {
				toppings.add(topping);
			}
		}

		System.out.print(toppings.size() >= 4 ? "yummy" : "sad");
	}
}

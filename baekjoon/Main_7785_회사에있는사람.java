package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main_7785_회사에있는사람 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		HashSet<String> set = new HashSet<>();
		
		int n = Integer.parseInt(in.readLine());
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			String name = st.nextToken();
			String opt = st.nextToken();
			
			if(opt.equals("enter")) set.add(name);
			else set.remove(name);
		}
		
		ArrayList<String> list = new ArrayList<>(set);
		Collections.sort(list, Collections.reverseOrder());
		
		for (String name : list) {
			System.out.println(name);
		}
	}
}

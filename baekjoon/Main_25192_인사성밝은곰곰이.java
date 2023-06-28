package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main_25192_인사성밝은곰곰이 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		HashSet<String> set = new HashSet<>();
		
		int N = Integer.parseInt(in.readLine()), cnt = 0;
		
		for (int i = 0; i < N; i++) {
			String chat = in.readLine();
			
			if(chat.equals("ENTER")) {
				cnt += set.size();
				set = new HashSet<>();
			}else {
				set.add(chat);				
			}
		}
		cnt += set.size();
		
		System.out.println(cnt);
	}
}

package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1193_분수찾기 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int X = Integer.parseInt(in.readLine());
		int num = 0, cnt = 0;
		while(true){
			if(cnt >= X){
				cnt = X - (cnt-num);
				break;
			}
			cnt += (++num);
		}
		if(num % 2 == 0) System.out.print(cnt +"/"+(num-cnt+1));
		else System.out.print((num-cnt+1)+"/"+cnt);
	}
}

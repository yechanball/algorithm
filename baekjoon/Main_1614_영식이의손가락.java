package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1614_영식이의손가락 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		long finger = Long.parseLong(in.readLine());
		long cnt = Long.parseLong(in.readLine());
		
		if(finger == 1) {
			System.out.print(8*cnt);
		}else if(finger == 2){
			System.out.print(cnt/2*8 + cnt%2*6 + 1);			
		}else if(finger == 3){
			System.out.print(cnt/2*8 + cnt%2*4 + 2);			
		}else if(finger == 4){
			System.out.print(cnt/2*8 + cnt%2*2 + 3);	
		}else {
			System.out.print(8*cnt + 4);
		}
	}
}

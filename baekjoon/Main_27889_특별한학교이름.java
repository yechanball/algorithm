package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_27889_특별한학교이름 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		char key = in.readLine().charAt(0);
		if(key == 'B') System.out.print("Branksome Hall Asia");
		else if(key == 'K') System.out.print("Korea International School");
		else if(key == 'N') System.out.print("North London Collegiate School");
		else System.out.print("St. Johnsbury Academy");
	}
}
